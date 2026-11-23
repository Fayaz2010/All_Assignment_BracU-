from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *

import random
import math

WIDTH = 1600
HEIGHT = 900

points = []
speed = 5

angles = [45, 135, 225, 315]


def create_point(mx, my):

    angle = random.choice(angles)

    rad = math.radians(angle)

    dx = math.cos(rad)
    dy = math.sin(rad)

    r = random.random()
    g = random.random()
    b = random.random()

    # x, y, direction_x, direction_y, r, g, b
    points.append([mx, HEIGHT - my, dx, dy, r, g, b])


def draw_points():

    glPointSize(5)

    glBegin(GL_POINTS)

    for p in points:

        glColor3f(p[4], p[5], p[6])
        glVertex2f(p[0], p[1])

    glEnd()


def update(value):

    global speed

    for p in points:

        p[0] += p[2] * speed
        p[1] += p[3] * speed

        # Bounce from left/right wall
        if p[0] <= 0:
            p[0] = 0
            p[2] *= -1

        elif p[0] >= WIDTH:
            p[0] = WIDTH
            p[2] *= -1

        # Bounce from top/bottom wall
        if p[1] <= 0:
            p[1] = 0
            p[3] *= -1

        elif p[1] >= HEIGHT:
            p[1] = HEIGHT
            p[3] *= -1

    glutPostRedisplay()
    glutTimerFunc(16, update, 0)


def display():

    glClear(GL_COLOR_BUFFER_BIT)
    glLoadIdentity()

    draw_points()

    glutSwapBuffers()


def mouse(button, state, x, y):

    if button == GLUT_LEFT_BUTTON and state == GLUT_DOWN:
        create_point(x, y)


def special_keys(key, x, y):

    global speed

    if key == GLUT_KEY_UP:

        speed += 1
        print("Speed:", speed)

    elif key == GLUT_KEY_DOWN:

        if speed > 1:
            speed -= 1

        print("Speed:", speed)


def init():

    glClearColor(0.0, 0.0, 0.0, 1.0)

    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0, WIDTH, 0, HEIGHT, -1, 1)

    glMatrixMode(GL_MODELVIEW)


def main():

    glutInit()

    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB)

    glutInitWindowSize(WIDTH, HEIGHT)

    glutCreateWindow(b"Moving Colored Balls")

    init()

    glutDisplayFunc(display)
    glutMouseFunc(mouse)
    glutSpecialFunc(special_keys)

    glutTimerFunc(16, update, 0)

    glutMainLoop()


if __name__ == "__main__":
    main()