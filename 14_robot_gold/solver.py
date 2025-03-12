from environment import *
from display import *
from ai import *

import copy

# create a new "grid" world.
#first parameter is size of grid. second is percent pits in world
env = RobotWorld(10,20)

# create a graphics display for the environment
display = Display(env)

# set up the simulated annealing and learn some moves
ai = Ai(env)
moves = ai.solve_problem()

# this is the best series of moves found.
# once the robot finds gold or dies, it stops moving
for m in moves:
    print(m,end='')
print()

# animate the series of moves in the best solution
print(env.robot_start_location)
env.robot_location = copy.copy(env.robot_start_location)
for m in moves:
    status = env.move_robot(m)
    #print('moved to rc',env.location.row, env.location.col)
    if status=="gold":
        print('yahoo')
        break
    if status=="dead":
        print('blah')
        display.draw_not_alive(env.robot_location.row,env.robot_location.col)
        break
    display.redraw()





    
