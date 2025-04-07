import threading
import time
import turtle

# number of times "button" has been clicked
clicks = 0

# states
OFF = 0
LOW = 1
MID = 2
HIGH = 3

# states and their corresponding colors representing brightness of the light
states = [[OFF,'#000000'],[LOW,'#fcf7b8'],[MID,'#faeb48'],[HIGH,'#ffff00']]

turtle.setup(200,500)
pen = turtle.Turtle()
pen.hideturtle()
pen.color('white')
pen.speed(0)

def change_light(state):
    # refill the light with a new color based on the current state
    print('changing to',state)
    pen.fillcolor(states[state][1])
    pen.begin_fill()
    pen.circle(60)
    pen.end_fill()

def button_check():
    global clicks
    while(1):
        # every quarter of a second, check if something has been entered
        time.sleep(.25)
        input('enter to push button')
        clicks += 1

# start the thread to check for the "push" of the button
button_handler = threading.Thread(target=button_check)
button_handler.start()

# note that clicks%4 will indicate which state it should be in.


