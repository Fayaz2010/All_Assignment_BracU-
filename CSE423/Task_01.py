from OpenGL.GL import *     
from OpenGL.GLUT import *  
from OpenGL.GLU import *    
import random
rain_dx = 0          # Rain bending amount

sky = 0.75           # Sky brightness (0 = dark, 1 = bright)

x, y = 250, 250


# ===== Function to draw a single point =====
def draw_house():
                   
    
    glColor3f(0.55, 0.38, 0.05)   
    glBegin(GL_TRIANGLES)
    glVertex2f(0, 0)      
    glVertex2f(0, 600)       
    glVertex2f(1500, 0)      
    glEnd()
    glBegin(GL_TRIANGLES)
    glVertex2f(1500, 600)       
    glVertex2f(0, 600)     
    glVertex2f(1500, 0)      
    glEnd()
    draw_grass() 
    glColor3f(1.0, 1.0, 1.0)
    glBegin(GL_TRIANGLES)
    glVertex2f(500, 510)      
    glVertex2f(500, 350)      
    glVertex2f(1000, 350)      
    glEnd()
    glBegin(GL_TRIANGLES)
    glVertex2f(500, 510)      
    glVertex2f(1000, 510)     
    glVertex2f(1000, 350)      
    glEnd()
    glColor3f(0.0, 0.0, 0.75)

    glBegin(GL_TRIANGLES)
    glVertex2f(490, 510)       
    glVertex2f(1010, 510)      
    glVertex2f(740, 620)      
    glEnd()

    # door 
    glColor3f(0.40, 0.50, 0.80)
    glBegin(GL_TRIANGLES)
    glVertex2f(710, 460)      
    glVertex2f(790, 460)     
    glVertex2f(710, 350)     
    glEnd()
    glBegin(GL_TRIANGLES)
    glVertex2f(710, 350)     
    glVertex2f(790, 460)       
    glVertex2f(790, 350)       
    glEnd()

    # door lock

    glColor3f(0.0, 0.0, 0.0)
    glPointSize(10)         
    glBegin(GL_POINTS)    
    glVertex2f(775,405 )    
    glEnd()    

    # window 1st
    glColor3f(0.40, 0.50, 0.80)

    glBegin(GL_TRIANGLES)
    glVertex2f(810, 400)      
    glVertex2f(900, 400)     
    glVertex2f(810, 460)       
    glEnd()
    glBegin(GL_TRIANGLES)
    glVertex2f(900, 460)       
    glVertex2f(900, 400)       
    glVertex2f(810, 460)       
    glEnd()



    # window 2nd
    glBegin(GL_TRIANGLES)
    glVertex2f(600, 400)       
    glVertex2f(690, 400)      
    glVertex2f(600, 460)       
    glEnd()
    glBegin(GL_TRIANGLES)
    glVertex2f(690, 460)       
    glVertex2f(690, 400)       
    glVertex2f(600, 460)       
    glEnd()

   # window 1st
    glColor3f(0.0, 0.0, 0.0)   
    glBegin(GL_LINES)
    glVertex2f(645, 400) 
    glVertex2f(645, 460) 
    glEnd()
    glBegin(GL_LINES)
    glVertex2f(600, 430) 
    glVertex2f(690, 430) 
    glEnd()

    # window 2nd


    glBegin(GL_LINES)
    glVertex2f(855, 400) 
    glVertex2f(855, 460) 
    glEnd()
    glBegin(GL_LINES)
    glVertex2f(810, 430) 
    glVertex2f(900, 430) 
    glEnd()

# Rain drops
raindrops = []

for i in range(250):         
    raindrops.append([
        random.randint(0, 1500),   
        random.randint(0, 900)   
    ])
def draw_rain():
    global sky

    if sky < 0.35:
        glColor3f(1, 1, 1)          # White rain at night
    else:
        glColor3f(0.7, 0.9, 1.0)    # Blue rain during day

    glBegin(GL_LINES)

    for drop in raindrops:
        rx = drop[0]
        ry = drop[1]

        glVertex2f(rx, ry)
        glVertex2f(rx + rain_dx, ry - 15)

    glEnd()
def update(value):
    for drop in raindrops:

        drop[0] += rain_dx
        drop[1] -= 10

        if drop[1] < 0:
            drop[1] = 900
            drop[0] = random.randint(0,1500)

        if drop[0] < 0:
            drop[0] = 1500

        if drop[0] > 1500:
            drop[0] = 0

    glutPostRedisplay()
    glutTimerFunc(16, update, 0)

def special_keys(key, x, y):
    global rain_dx

    if key == GLUT_KEY_LEFT:
        rain_dx -= 1

    elif key == GLUT_KEY_RIGHT:
        rain_dx += 1

    glutPostRedisplay()



def keyboard(key, x, y):
    global sky

    if key == b'd':

        sky += 0.05

        if sky > 1:
            sky = 1

    elif key == b'n':

        sky -= 0.05

        if sky < 0.05:
            sky = 0.05

    glutPostRedisplay()



def draw_grass():
    glColor3f(0.0, 1.0, 0.0)      

    grass_width = 65             
    grass_height = 80             

    for x in range(0, 1500, grass_width):
        glBegin(GL_TRIANGLES)
        glVertex2f(x, 500)                            
        glVertex2f(x + grass_width, 500)             
        glVertex2f(x + grass_width / 2, 500 + grass_height)  
        glEnd()

# lighting
lightning = False
def update(value):
    global lightning

    # Move rain
    for drop in raindrops:
        drop[1] -= 10
        if drop[1] < 0:
            drop[1] = 900
            drop[0] = random.randint(0, 1500)

    # 1% chance of lightning
    if random.randint(1, 100) == 1:
        lightning = True
    else:
        lightning = False

    glutPostRedisplay()
    glutTimerFunc(16, update, 0)


# ===== Set up 2D coordinate system =====
def setup_projection():
    glViewport(0, 0, 1500, 900)    
    glMatrixMode(GL_PROJECTION)    
    glLoadIdentity()               
    glOrtho(0.0, 1500, 0.0, 900, 0.0, 1.0)  
    glMatrixMode(GL_MODELVIEW)     


# ===== Display callback =====
def display():
    if lightning:
        glClearColor(0.95, 0.95, 1.0, 1.0)   # Bright white-blue flash
    else:
        glClearColor(0.0, 0.0, 0.0, 0.0)  # Normal sky
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)  
    glLoadIdentity()                                    
    setup_projection()                                  
   # glColor3f(1.0, 1.0, 0.0)                         
    draw_house() 
    draw_rain()
    draw_lightning()
     
    glutSwapBuffers()   

def draw_lightning():
    if not lightning:
        return

    glColor3f(1.0, 1.0, 0.9)
    glLineWidth(4)

    glBegin(GL_LINE_STRIP)
    glVertex2f(800, 900)
    glVertex2f(770, 800)
    glVertex2f(820, 700)
    glVertex2f(780, 600)
    glVertex2f(830, 500)
    glEnd()
     



def main():
    glutInit()                              
    glutInitDisplayMode(GLUT_RGBA)       
    glutInitWindowSize(1500, 900)          
    glutInitWindowPosition(0, 0)        
    glutCreateWindow(b"OpenGL 2D Point")    
    glutDisplayFunc(display)
    glutTimerFunc(16, update, 0)   
    glutKeyboardFunc(keyboard)
    glutSpecialFunc(special_keys)
                 
    glutMainLoop()                           


# ===== Run the program =====
if __name__ == "__main__":
    main()
