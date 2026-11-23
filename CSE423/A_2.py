# ====== Catch the Diamonds! ======
# CSE423 - Computer Graphics, Lab 02 Activity Task
#
# Rules implemented:
#   - Diamonds fall from the top of the screen, randomly colored/positioned.
#   - A catcher at the bottom is moved with LEFT / RIGHT arrow keys.
#   - Catching a diamond (AABB collision) increases score (printed to console),
#     a new diamond spawns and fall speed gradually ramps up.
#   - Missing a diamond ends the game (catcher turns red, "Game Over" printed).
#   - Top-left teal "<-" button: restart the game (score/speed reset).
#   - Top-middle amber "||" / play button: pause/resume the game.
#   - Top-right red "X" button: prints "Goodbye" + score, then quits.
#   - Pressing 'c' toggles Cheat Mode: the catcher smoothly chases the
#     diamond's x position (not a teleport) so it never misses.
#
# IMPORTANT CONSTRAINT (per assignment):
#   Only the OpenGL()/GLUT() functions that already appear in the two demo
#   files (Hello_openGL.py and Lets_draw_sth.py) are used anywhere below,
#   plus glutLeaveMainLoop() which the assignment text explicitly names for
#   terminating the app. Every single shape (diamond, catcher, buttons,
#   icons) is drawn using ONLY the GL_POINTS primitive, via a generic
#   midpoint line drawing algorithm (8-way symmetry) built from the
#   Zone-0 pseudocode given in the lab document.
#
#   Author: (your name here)
# ===================================

from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
import random
import time

# ---------------------------------------------------------------------------
# Window / world configuration
# ---------------------------------------------------------------------------
WIN_W, WIN_H = 600, 800

GROUND_Y = 0

# Catcher configuration
CATCHER_Y = 40                 # y of the catcher's bottom edge
CATCHER_HEIGHT = 22
CATCHER_TOP_HALF = 55          # half-width of the catcher's top (wide) edge
CATCHER_BOTTOM_HALF = 28       # half-width of the catcher's bottom (narrow) edge
CATCHER_CHEAT_SPEED = 260.0    # cheat-mode chase speed (px / sec) - deliberately
                                # finite so the catcher visibly *moves* to the
                                # diamond instead of teleporting there.

# Diamond configuration
DIAMOND_HALF = 14
DIAMOND_START_Y = WIN_H - 110
DIAMOND_BASE_SPEED = 110.0     # px / sec
DIAMOND_SPEED_STEP = 8.0       # extra px/sec added every successful catch
DIAMOND_TIME_RAMP = 2.0        # extra px/sec added per elapsed second (difficulty ramp)

BRIGHT_COLORS = [
    (1.0, 0.2, 0.2), (0.2, 1.0, 0.3), (0.25, 0.55, 1.0),
    (1.0, 0.9, 0.15), (1.0, 0.4, 0.9), (0.3, 1.0, 1.0),
    (1.0, 0.6, 0.1), (0.7, 0.3, 1.0),
]

WHITE = (1.0, 1.0, 1.0)
RED = (1.0, 0.1, 0.1)

# Buttons (x_min, x_max, y_min, y_max) in world coordinates
LEFT_BTN = (30, 90, WIN_H - 55, WIN_H - 15)
PAUSE_BTN = (WIN_W / 2 - 30, WIN_W / 2 + 30, WIN_H - 55, WIN_H - 15)
CROSS_BTN = (WIN_W - 90, WIN_W - 30, WIN_H - 55, WIN_H - 15)


# ---------------------------------------------------------------------------
# Generic Midpoint Line Drawing Algorithm (all 8 zones, GL_POINTS only)
# ---------------------------------------------------------------------------
def find_zone(dx, dy):
    """Classify the direction (dx, dy) into one of the 8 zones described
    in the lab document (Zone 0..7)."""
    if dx >= 0 and dy >= 0:
        return 0 if dx >= dy else 1
    elif dx < 0 and dy >= 0:
        return 3 if -dx >= dy else 2
    elif dx < 0 and dy < 0:
        return 4 if -dx >= -dy else 5
    else:  # dx >= 0 and dy < 0
        return 7 if dx >= -dy else 6


def to_zone0(dx, dy, zone):
    """Map a direction vector (dx, dy) from its zone into Zone-0 space,
    using the 8-way symmetry (swap / reflect) described in the lab doc."""
    if zone == 0:
        return dx, dy
    if zone == 1:
        return dy, dx
    if zone == 2:
        return dy, -dx
    if zone == 3:
        return -dx, dy
    if zone == 4:
        return -dx, -dy
    if zone == 5:
        return -dy, -dx
    if zone == 6:
        return -dy, dx
    if zone == 7:
        return dx, -dy


def from_zone0(px, py, zone):
    """Inverse of to_zone0(): map a Zone-0 point back to its original zone."""
    if zone == 0:
        return px, py
    if zone == 1:
        return py, px
    if zone == 2:
        return -py, px
    if zone == 3:
        return -px, py
    if zone == 4:
        return -px, -py
    if zone == 5:
        return -py, -px
    if zone == 6:
        return py, -px
    if zone == 7:
        return px, -py


def run_zone0(x1, y1, x2, y2):
    """Midpoint line algorithm for Zone-0 (0 <= dy <= dx), exactly the
    pseudocode from the lab document, using pure integer arithmetic."""
    points = []
    dx = x2 - x1
    dy = y2 - y1

    if dx == 0:
        points.append((x1, y1))
        return points

    d = 2 * dy - dx
    incE = 2 * dy
    incNE = 2 * (dy - dx)
    y = y1

    x = x1
    while x <= x2:
        points.append((x, y))
        if d > 0:
            d += incNE
            y += 1
        else:
            d += incE
        x += 1
    return points


def midpoint_line(x1, y1, x2, y2):
    """General midpoint line drawing algorithm for a line between any two
    points, in any of the 8 zones/directions, built on top of Zone-0's
    algorithm using the 'eight way symmetry' technique from the lab doc.
    Returns a list of integer (x, y) pixel coordinates."""
    x1, y1 = int(round(x1)), int(round(y1))
    x2, y2 = int(round(x2)), int(round(y2))

    if x1 == x2 and y1 == y2:
        return [(x1, y1)]

    dx = x2 - x1
    dy = y2 - y1
    zone = find_zone(dx, dy)

    zdx, zdy = to_zone0(dx, dy, zone)
    zone0_points = run_zone0(0, 0, zdx, zdy)

    pixels = []
    for (px, py) in zone0_points:
        ox, oy = from_zone0(px, py, zone)
        pixels.append((x1 + ox, y1 + oy))
    return pixels


def draw_point_list(points, color, size=2):
    """Draws a list of pixel coordinates using GL_POINTS only."""
    glColor3f(*color)
    glPointSize(size)
    glBegin(GL_POINTS)
    for (x, y) in points:
        glVertex2f(x, y)
    glEnd()


def draw_midpoint_line(x1, y1, x2, y2, color, size=2):
    draw_point_list(midpoint_line(x1, y1, x2, y2), color, size)


# ---------------------------------------------------------------------------
# Game state
# ---------------------------------------------------------------------------
state = {
    "score": 0,
    "game_over": False,
    "playing": True,
    "cheat_mode": False,
    "catcher_x": WIN_W / 2,
    "diamond_x": WIN_W / 2,
    "diamond_y": DIAMOND_START_Y,
    "diamond_color": random.choice(BRIGHT_COLORS),
    "diamond_speed": DIAMOND_BASE_SPEED,
    "elapsed": 0.0,
    "last_time": None,
}


def spawn_diamond():
    state["diamond_x"] = random.uniform(DIAMOND_HALF + 20, WIN_W - DIAMOND_HALF - 20)
    state["diamond_y"] = DIAMOND_START_Y
    state["diamond_color"] = random.choice(BRIGHT_COLORS)


def reset_game():
    state["score"] = 0
    state["game_over"] = False
    state["playing"] = True
    state["diamond_speed"] = DIAMOND_BASE_SPEED
    state["elapsed"] = 0.0
    state["catcher_x"] = WIN_W / 2
    spawn_diamond()
    print("Starting over!")


# ---------------------------------------------------------------------------
# Drawing
# ---------------------------------------------------------------------------
def draw_diamond():
    cx, cy = state["diamond_x"], state["diamond_y"]
    h = DIAMOND_HALF
    top = (cx, cy + h)
    right = (cx + h, cy)
    bottom = (cx, cy - h)
    left = (cx - h, cy)

    pts = []
    pts += midpoint_line(*top, *right)
    pts += midpoint_line(*right, *bottom)
    pts += midpoint_line(*bottom, *left)
    pts += midpoint_line(*left, *top)
    draw_point_list(pts, state["diamond_color"], size=2)


def draw_catcher():
    cx = state["catcher_x"]
    top_left = (cx - CATCHER_TOP_HALF, CATCHER_Y + CATCHER_HEIGHT)
    top_right = (cx + CATCHER_TOP_HALF, CATCHER_Y + CATCHER_HEIGHT)
    bottom_right = (cx + CATCHER_BOTTOM_HALF, CATCHER_Y)
    bottom_left = (cx - CATCHER_BOTTOM_HALF, CATCHER_Y)

    color = RED if state["game_over"] else WHITE

    pts = []
    pts += midpoint_line(*top_left, *bottom_left)     # left slanted side
    pts += midpoint_line(*bottom_left, *bottom_right)  # bottom
    pts += midpoint_line(*bottom_right, *top_right)   # right slanted side
    pts += midpoint_line(*top_right, *top_left)       # top
    draw_point_list(pts, color, size=2)


def draw_left_arrow_button():
    x0, x1, y0, y1 = LEFT_BTN
    cx, cy = (x0 + x1) / 2, (y0 + y1) / 2
    color = (0.0, 0.8, 0.9)  # bright teal

    pts = []
    pts += midpoint_line(cx + 14, cy + 14, cx - 14, cy)   # upper diagonal
    pts += midpoint_line(cx - 14, cy, cx + 14, cy - 14)   # lower diagonal
    pts += midpoint_line(cx - 14, cy, cx + 16, cy)        # stem
    draw_point_list(pts, color, size=2)


def draw_middle_button():
    x0, x1, y0, y1 = PAUSE_BTN
    cx, cy = (x0 + x1) / 2, (y0 + y1) / 2
    color = (1.0, 0.75, 0.0)  # amber

    pts = []
    if state["playing"] and not state["game_over"]:
        # Pause icon: two vertical bars
        pts += midpoint_line(cx - 8, cy - 15, cx - 8, cy + 15)
        pts += midpoint_line(cx + 8, cy - 15, cx + 8, cy + 15)
    else:
        # Play icon: right-pointing triangle outline
        pts += midpoint_line(cx - 10, cy - 15, cx - 10, cy + 15)
        pts += midpoint_line(cx - 10, cy + 15, cx + 13, cy)
        pts += midpoint_line(cx + 13, cy, cx - 10, cy - 15)
    draw_point_list(pts, color, size=2)


def draw_cross_button():
    x0, x1, y0, y1 = CROSS_BTN
    color = (1.0, 0.15, 0.15)  # red
    pts = []
    pts += midpoint_line(x0 + 5, y0 + 5, x1 - 5, y1 - 5)
    pts += midpoint_line(x0 + 5, y1 - 5, x1 - 5, y0 + 5)
    draw_point_list(pts, color, size=2)


def setup_projection():
    glViewport(0, 0, WIN_W, WIN_H)
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0, WIN_W, 0, WIN_H, 0, 1)
    glMatrixMode(GL_MODELVIEW)


def display():
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glLoadIdentity()
    setup_projection()

    draw_left_arrow_button()
    draw_middle_button()
    draw_cross_button()

    if not state["game_over"]:
        draw_diamond()
    draw_catcher()

    glutSwapBuffers()


# ---------------------------------------------------------------------------
# Collision (AABB, per the lab document's pseudocode)
# ---------------------------------------------------------------------------
def has_collided(box1, box2):
    return (box1["x"] < box2["x"] + box2["width"] and
            box1["x"] + box1["width"] > box2["x"] and
            box1["y"] < box2["y"] + box2["height"] and
            box1["y"] + box1["height"] > box2["y"])


def diamond_box():
    return {
        "x": state["diamond_x"] - DIAMOND_HALF,
        "y": state["diamond_y"] - DIAMOND_HALF,
        "width": DIAMOND_HALF * 2,
        "height": DIAMOND_HALF * 2,
    }


def catcher_box():
    return {
        "x": state["catcher_x"] - CATCHER_TOP_HALF,
        "y": CATCHER_Y,
        "width": CATCHER_TOP_HALF * 2,
        "height": CATCHER_HEIGHT,
    }


# ---------------------------------------------------------------------------
# Update / animation (delta-time based, per the lab document's tip)
# ---------------------------------------------------------------------------
def update():
    now = time.time()
    if state["last_time"] is None:
        state["last_time"] = now
    dt = now - state["last_time"]
    state["last_time"] = now
    # Guard against huge dt spikes (e.g. window drag)
    dt = min(dt, 0.05)

    if state["playing"] and not state["game_over"]:
        state["elapsed"] += dt

        # Cheat mode: chase the diamond's x position smoothly
        if state["cheat_mode"]:
            target = state["diamond_x"]
            cx = state["catcher_x"]
            diff = target - cx
            max_step = CATCHER_CHEAT_SPEED * dt
            if abs(diff) <= max_step:
                state["catcher_x"] = target
            else:
                state["catcher_x"] += max_step if diff > 0 else -max_step

        # Clamp catcher within the screen
        min_x = CATCHER_TOP_HALF
        max_x = WIN_W - CATCHER_TOP_HALF
        state["catcher_x"] = max(min_x, min(max_x, state["catcher_x"]))

        # Diamond falls
        speed = (DIAMOND_BASE_SPEED
                 + state["score"] * DIAMOND_SPEED_STEP
                 + state["elapsed"] * DIAMOND_TIME_RAMP)
        state["diamond_speed"] = speed
        state["diamond_y"] -= speed * dt

        # Collision check
        if has_collided(diamond_box(), catcher_box()):
            state["score"] += 1
            print(f"Score: {state['score']}")
            spawn_diamond()
        elif state["diamond_y"] - DIAMOND_HALF <= GROUND_Y:
            state["game_over"] = True
            print(f"Game Over! Score: {state['score']}")

    glutPostRedisplay()


# ---------------------------------------------------------------------------
# Input handling
# ---------------------------------------------------------------------------
def keyboard_listener(key, x, y):
    if key == b'c':
        state["cheat_mode"] = not state["cheat_mode"]
        print("Cheat Mode:", "ON" if state["cheat_mode"] else "OFF")
    glutPostRedisplay()


CATCHER_STEP = 18  # pixels moved per LEFT/RIGHT key event (GLUT auto-repeats
                    # this callback while the key is held, giving continuous
                    # movement - same pattern as speed changes in the demo).


def special_key_listener(key, x, y):
    """Handles LEFT/RIGHT arrow keys to move the catcher, mirroring the
    UP/DOWN handling style used in Lets_draw_sth.py's special_key_listener."""
    if state["game_over"] or not state["playing"] or state["cheat_mode"]:
        glutPostRedisplay()
        return

    min_x = CATCHER_TOP_HALF
    max_x = WIN_W - CATCHER_TOP_HALF

    if key == GLUT_KEY_LEFT:
        state["catcher_x"] = max(min_x, state["catcher_x"] - CATCHER_STEP)
    elif key == GLUT_KEY_RIGHT:
        state["catcher_x"] = min(max_x, state["catcher_x"] + CATCHER_STEP)

    glutPostRedisplay()


def point_in_rect(px, py, rect):
    x0, x1, y0, y1 = rect
    return x0 <= px <= x1 and y0 <= py <= y1


def mouse_listener(button, gstate, x, y):
    if button != GLUT_LEFT_BUTTON or gstate != GLUT_DOWN:
        return

    # Convert GLUT screen coords (origin top-left) to our world coords
    # (origin bottom-left), same idea as convert_coordinate() in the demo.
    world_x = x
    world_y = WIN_H - y

    if point_in_rect(world_x, world_y, LEFT_BTN):
        reset_game()
    elif point_in_rect(world_x, world_y, PAUSE_BTN):
        state["playing"] = not state["playing"]
    elif point_in_rect(world_x, world_y, CROSS_BTN):
        print(f"Goodbye. Score: {state['score']}")
        glutLeaveMainLoop()

    glutPostRedisplay()


# ---------------------------------------------------------------------------
# Main entry point
# ---------------------------------------------------------------------------
def main():
    glutInit()
    glutInitDisplayMode(GLUT_RGBA)
    glutInitWindowSize(WIN_W, WIN_H)
    glutInitWindowPosition(100, 100)
    glutCreateWindow(b"Catch the Diamonds!")

    spawn_diamond()

    glutDisplayFunc(display)
    glutIdleFunc(update)
    glutKeyboardFunc(keyboard_listener)
    glutSpecialFunc(special_key_listener)
    glutMouseFunc(mouse_listener)

    glutMainLoop()


if __name__ == "__main__":
    main()