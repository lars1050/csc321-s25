import time

from display import *
from robot import *
from environment import *

# define the size of the environment and create it
ENV_WIDTH = 900
ENV_HEIGHT = 700

env = Environment(ENV_WIDTH,ENV_HEIGHT)

# add some pits (random location and size)
for i in range(5):
    env.add_random_pit()

# add some robots (random location and speed)
for i in range(3):
    env.add_random_robot()

# set up the display of the environment
display = Display(env)
display.draw()

# run the display
for i in range(1000):
    env.update()
    display.update()
    time.sleep(.001)



    
