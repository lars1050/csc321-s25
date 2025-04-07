import time
import turtle

# states
RED = 0
YELLOW = 1
GREEN = 2

# red on for 10 seconds
# yellow on for 3 seconds
# green on for 10 seconds

# Determine expired time with ...
# start = time.time()
# duration = start - time.time()

# used for turtle graphics display of traffic light
colors = ["red","yellow","green"]

turtle.setup(200,500)
pen = turtle.Turtle()
pen.hideturtle()
pen.speed(0)

def draw_light(state):
    # state is RED, YELLOW, or GREEN (which are integers)
    pen.pu()
    # order of lights is red, yellow, green
    pen.goto(0,-state*100)
    pen.pd()
    pen.fillcolor(colors[state])
    pen.begin_fill()
    pen.circle(40)
    pen.end_fill()

def undraw_light(state):
    # undraw the light so it can transition to a different color
    pen.pu()
    pen.goto(0,-state*100)
    pen.pd()
    pen.fillcolor("white")
    pen.begin_fill()
    pen.circle(40)
    pen.end_fill()
    
    
def draw_lights():
    # draw all 3 lights with red at the top
    draw_light(RED)
    draw_light(YELLOW)
    draw_light(GREEN)
    
draw_lights()


        
    
