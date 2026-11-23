import math
import random

from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *


camera_pos = (0, 500, 500)   
camera_mode = "third"         
camera_angle = 90.0       
camera_height = 500.0       
camera_radius = 700.0        

fovY = 120                   
GRID_LENGTH = 600            
TILE = 60                    
WALL_HEIGHT = 120              


player_pos = [0.0, 0.0]        
player_angle = 0.0             
player_life = 5
game_over = False

MOVE_STEP = 25.0
TURN_STEP = 5.0
PLAYER_HALF_HEIGHT = 60.0      

cheat_mode = False
cheat_vision = False
cheat_gun_angle = 0.0
cheat_fire_cooldown = 0       
CHEAT_TURN_SPEED = 1.5
CHEAT_FOV_HALF_ANGLE = 2.0     

game_score = 0
bullets_missed = 0
MAX_MISSES = 10

bullets = []       
BULLET_SPEED = 14.0
BULLET_SIZE = 8

enemies = []       
NUM_ENEMIES = 5
ENEMY_SPEED = 0.03
ENEMY_HIT_RADIUS = 35.0
ENEMY_TOUCH_RADIUS = 45.0

frame_count = 0




def spawn_enemy():
    while True:
        x = random.uniform(-GRID_LENGTH + 80, GRID_LENGTH - 80)
        y = random.uniform(-GRID_LENGTH + 80, GRID_LENGTH - 80)
        if math.hypot(x - player_pos[0], y - player_pos[1]) > 200:
            break
    return {'x': x, 'y': y, 'phase': random.uniform(0, math.pi * 2), 'scale': 1.0}


def init_enemies():
    enemies.clear()
    for _ in range(NUM_ENEMIES):
        enemies.append(spawn_enemy())


def reset_game():
    global player_pos, player_angle, player_life, game_over
    global game_score, bullets_missed, cheat_mode, cheat_vision, cheat_gun_angle

    player_pos = [0.0, 0.0]
    player_angle = 0.0
    player_life = 5
    game_over = False
    game_score = 0
    bullets_missed = 0
    cheat_mode = False
    cheat_vision = False
    cheat_gun_angle = 0.0
    bullets.clear()
    init_enemies()




def draw_text(x, y, text, font=GLUT_BITMAP_HELVETICA_18):
    glColor3f(1, 1, 1)
    glMatrixMode(GL_PROJECTION)
    glPushMatrix()
    glLoadIdentity()

   
    gluOrtho2D(0, 1000, 0, 800)  

    glMatrixMode(GL_MODELVIEW)
    glPushMatrix()
    glLoadIdentity()


    glRasterPos2f(x, y)
    for ch in text:
        glutBitmapCharacter(font, ord(ch))

   
    glPopMatrix()
    glMatrixMode(GL_PROJECTION)
    glPopMatrix()
    glMatrixMode(GL_MODELVIEW)


def draw_grid():
    glBegin(GL_QUADS)
    cols = int((2 * GRID_LENGTH) / TILE)
    for row in range(cols):
        for col in range(cols):
            x0 = -GRID_LENGTH + col * TILE
            y0 = -GRID_LENGTH + row * TILE
            x1 = x0 + TILE
            y1 = y0 + TILE

            if (row + col) % 2 == 0:
                glColor3f(1.0, 1.0, 1.0)      
            else:
                glColor3f(0.7, 0.5, 0.95)     

            glVertex3f(x0, y0, 0)
            glVertex3f(x1, y0, 0)
            glVertex3f(x1, y1, 0)
            glVertex3f(x0, y1, 0)
    glEnd()


def draw_boundaries():
    L = GRID_LENGTH
    H = WALL_HEIGHT

    glBegin(GL_QUADS)
    glColor3f(0, 0, 1)
    glVertex3f(-L, -L, 0)
    glVertex3f(-L, L, 0)
    glVertex3f(-L, L, H)
    glVertex3f(-L, -L, H)

    glColor3f(0, 1, 0)
    glVertex3f(L, -L, 0)
    glVertex3f(L, L, 0)
    glVertex3f(L, L, H)
    glVertex3f(L, -L, H)

    glColor3f(0, 1, 1)
    glVertex3f(-L, L, 0)
    glVertex3f(L, L, 0)
    glVertex3f(L, L, H)
    glVertex3f(-L, L, H)

    glColor3f(0.7, 0.2, 0.9)
    glVertex3f(-L, -L, 0)
    glVertex3f(L, -L, 0)
    glVertex3f(L, -L, H)
    glVertex3f(-L, -L, H)
    glEnd()


def draw_player():
    glPushMatrix()
    glTranslatef(player_pos[0], player_pos[1], 0)
    glRotatef(player_angle, 0, 0, 1)

    if game_over:
        glRotatef(90, 1, 0, 0)
        glTranslatef(0, 0, -20)

    for side in (-1, 1):
        glPushMatrix()
        glColor3f(0, 0, 1)
        glTranslatef(12 * side, 0, 40)
        glRotatef(180, 1, 0, 0)
        gluCylinder(gluNewQuadric(), 9, 9, 40, 10, 10)
        glPopMatrix()

    glPushMatrix()
    glColor3f(0.33, 0.42, 0.18)
    glTranslatef(0, 0, 65)
    glPushMatrix()
    glScalef(1.0, 0.65, 1.3)
    glutSolidCube(40)
    glPopMatrix()
    glPopMatrix()

    for side in (-1, 1):
        glPushMatrix()
        glColor3f(0, 0, 1)
        glTranslatef(24 * side, 0, 70)
        glRotatef(90 * side, 0, 1, 0)
        gluCylinder(gluNewQuadric(), 6, 6, 30, 8, 8)
        glPopMatrix()

        glPushMatrix()
        glColor3f(0.96, 0.80, 0.69)
        glTranslatef(24 * side + (30 * side), 0, 70)
        gluSphere(gluNewQuadric(), 8, 10, 10)
        glPopMatrix()

    glPushMatrix()
    glColor3f(0, 0, 0)
    glTranslatef(0, 0, 105)
    gluSphere(gluNewQuadric(), 16, 12, 12)
    glPopMatrix()

    glPushMatrix()
    glColor3f(0.15, 0.15, 0.15)
    glTranslatef(0, 0, 70)
    glRotatef(-90, 0, 1, 0)
    gluCylinder(gluNewQuadric(), 4, 4, 45, 8, 8)
    glPopMatrix()

    glPopMatrix()


def draw_enemies():
    for e in enemies:
        s = e['scale']
        glPushMatrix()
        glTranslatef(e['x'], e['y'], 0)
        glScalef(s, s, s)

        glPushMatrix()
        glColor3f(1, 0, 0)
        glTranslatef(0, 0, 20)
        gluSphere(gluNewQuadric(), 22, 12, 12)
        glPopMatrix()

        glPushMatrix()
        glColor3f(0, 0, 0)
        glTranslatef(0, 0, 48)
        gluSphere(gluNewQuadric(), 10, 10, 10)
        glPopMatrix()

        glPopMatrix()


def draw_bullets():
    for b in bullets:
        glPushMatrix()
        glColor3f(1, 1, 0)
        glTranslatef(b['x'], b['y'], 40)
        glutSolidCube(BULLET_SIZE)
        glPopMatrix()


def draw_scene_objects():
    draw_grid()
    draw_boundaries()
    draw_player()
    draw_enemies()
    draw_bullets()




def keyboardListener(key, x, y):
    
    global player_pos, player_angle, cheat_mode, cheat_vision

    if key == b'r':
        if game_over:
            reset_game()
        return

    if game_over:
        return

    rad = math.radians(player_angle)
    dx = math.cos(rad)
    dy = math.sin(rad)

    if key == b'w':
        player_pos[0] += dx * MOVE_STEP
        player_pos[1] += dy * MOVE_STEP

    if key == b's':
        player_pos[0] -= dx * MOVE_STEP
        player_pos[1] -= dy * MOVE_STEP

    if key == b'a':
        if not cheat_mode:
            player_angle += TURN_STEP

    if key == b'd':
        if not cheat_mode:
            player_angle -= TURN_STEP

    if key == b'c':
        cheat_mode = not cheat_mode

    if key == b'v':
        cheat_vision = not cheat_vision

    limit = GRID_LENGTH - 40
    player_pos[0] = max(-limit, min(limit, player_pos[0]))
    player_pos[1] = max(-limit, min(limit, player_pos[1]))


def specialKeyListener(key, x, y):
    
    global camera_height, camera_angle

    if key == GLUT_KEY_UP:
        camera_height += 10
        camera_height = min(camera_height, 1200)

    if key == GLUT_KEY_DOWN:
        camera_height -= 10
        camera_height = max(camera_height, 50)

    if key == GLUT_KEY_LEFT:
        camera_angle -= 3

    if key == GLUT_KEY_RIGHT:
        camera_angle += 3


def mouseListener(button, state, x, y):
   
    global camera_mode

    
    if button == GLUT_LEFT_BUTTON and state == GLUT_DOWN:
        if not game_over:
            fire_bullet(player_angle)

    if button == GLUT_RIGHT_BUTTON and state == GLUT_DOWN:
        camera_mode = "first" if camera_mode == "third" else "third"


def fire_bullet(angle):
    rad = math.radians(angle)
    bullets.append({
        'x': player_pos[0] + math.cos(rad) * 50,
        'y': player_pos[1] + math.sin(rad) * 50,
        'angle': angle,
    })




def setupCamera():
   
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    gluPerspective(fovY, 1.25, 0.1, 1500)
    glMatrixMode(GL_MODELVIEW)
    glLoadIdentity()

    if camera_mode == "third":
        rad = math.radians(camera_angle)
        x = camera_radius * math.cos(rad)
        y = camera_radius * math.sin(rad)
        z = camera_height
        gluLookAt(x, y, z,
                  0, 0, 0,
                  0, 0, 1)
    else:
     
        look_angle = cheat_gun_angle if (cheat_mode and cheat_vision) else player_angle
        rad = math.radians(look_angle)


        eye_x = player_pos[0] + math.cos(rad) * 20
        eye_y = player_pos[1] + math.sin(rad) * 20
        eye_z = PLAYER_HALF_HEIGHT + 20

        target_x = eye_x + math.cos(rad) * 200
        target_y = eye_y + math.sin(rad) * 200
        target_z = eye_z

        gluLookAt(eye_x, eye_y, eye_z,
                  target_x, target_y, target_z,
                  0, 0, 1)



def update_bullets():
    global bullets_missed
    survivors = []
    for b in bullets:
        rad = math.radians(b['angle'])
        b['x'] += math.cos(rad) * BULLET_SPEED
        b['y'] += math.sin(rad) * BULLET_SPEED

        # out of arena -> missed
        if abs(b['x']) > GRID_LENGTH or abs(b['y']) > GRID_LENGTH:
            bullets_missed += 1
            continue

        hit = False
        for e in enemies:
            if math.hypot(b['x'] - e['x'], b['y'] - e['y']) < ENEMY_HIT_RADIUS:
                register_enemy_hit(e)
                hit = True
                break
        if hit:
            continue

        survivors.append(b)
    bullets[:] = survivors


def register_enemy_hit(enemy):
    global game_score
    game_score += 1
    fresh = spawn_enemy()
    enemy['x'], enemy['y'], enemy['phase'], enemy['scale'] = (
        fresh['x'], fresh['y'], fresh['phase'], fresh['scale']
    )


def update_enemies():
    global player_life, game_over
    for e in enemies:

        dx = player_pos[0] - e['x']
        dy = player_pos[1] - e['y']
        dist = math.hypot(dx, dy)
        if dist > 1e-3:
            e['x'] += (dx / dist) * ENEMY_SPEED
            e['y'] += (dy / dist) * ENEMY_SPEED

        
        e['phase'] += 0.06
        e['scale'] = 1.0 + 0.3 * math.sin(e['phase'])

        if dist < ENEMY_TOUCH_RADIUS:
            player_life -= 1
            register_enemy_hit(e)
            if player_life <= 0:
                player_life = 0
                game_over = True


def update_cheat_mode():
    global cheat_gun_angle, cheat_fire_cooldown, player_angle

    if not cheat_mode:
        return

    cheat_gun_angle = (cheat_gun_angle + CHEAT_TURN_SPEED) % 360
    player_angle = cheat_gun_angle 

    if cheat_fire_cooldown > 0:
        cheat_fire_cooldown -= 1
        return

    
    for e in enemies:
        dx = e['x'] - player_pos[0]
        dy = e['y'] - player_pos[1]
        target_angle = math.degrees(math.atan2(dy, dx)) % 360
        diff = abs((target_angle - cheat_gun_angle + 180) % 360 - 180)
        
        distance = math.hypot(dx, dy)

        if diff <= CHEAT_FOV_HALF_ANGLE and distance < 500:
            fire_bullet(cheat_gun_angle)
            cheat_fire_cooldown = 12
            break


def idle():
   
    global frame_count
    frame_count += 1

    global game_over
    if not game_over:
        update_cheat_mode()
        update_bullets()
        update_enemies()
        if bullets_missed >= MAX_MISSES:
            game_over = True

    glutPostRedisplay()




def showScreen():
    
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glLoadIdentity()
    glViewport(0, 0, 1000, 800)

    setupCamera()

    glPointSize(20)
    glBegin(GL_POINTS)
    glVertex3f(-GRID_LENGTH, GRID_LENGTH, 0)
    glEnd()

    draw_scene_objects()

    draw_text(10, 770, f"Player Life Remaining: {player_life}")
    draw_text(10, 740, f"Game Score: {game_score}")
    draw_text(10, 710, f"Player Bullet Missed: {bullets_missed}")
    draw_text(10, 680, f"Cheat Mode: {'ON' if cheat_mode else 'OFF'}")
    draw_text(10, 650, f"Camera: {camera_mode.upper()}")

    if game_over:
        draw_text(370, 400, "GAME OVER - Press R to Restart",
                  font=GLUT_BITMAP_TIMES_ROMAN_24)

    glutSwapBuffers()



def main():
    init_enemies()

    glutInit()
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH)
    glutInitWindowSize(1000, 800)
    glutInitWindowPosition(0, 0)
    glutCreateWindow(b"Bullet Frenzy - CSE423 Assignment 3")

    glutDisplayFunc(showScreen)
    glutKeyboardFunc(keyboardListener)
    glutSpecialFunc(specialKeyListener)
    glutMouseFunc(mouseListener)
    glutIdleFunc(idle)

    glutMainLoop()


if __name__ == "__main__":
    main()