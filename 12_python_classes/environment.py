import math

import robot
from pit import *

class Environment:
    '''
    A simple environment for robots to move around in.
    It has pits that robots can fall in and some gold to be found.
    Note that the origin of the environment is at the center.
    This means the left edge is at -width/2 and right edge is width/2
    '''

    def __init__(self, width=500, height=500):
        self.width = width
        self.height = height

        # a list of pits randomly distributed around the environment
        self.pits = []

        # a list of robots moving around the environment
        self.robots = []

        # set the environment parameters for the Robot class.
        # this keeps robots in bounds of the environment
        robot.env_width = self.width
        robot.env_height = self.height

    def add_random_pit(self):
        # make a randomly located in the environment
        pit = Pit().make_random(self.width,self.height)
        self.pits.append(pit)

    def add_random_robot(self):
        
        # randomly place in the environment
        x = random.randint((int)(-self.width/2)+10, (int)(self.width/2)-10)
        y = random.randint((int)(-self.height/2)+10, (int)(self.height/2)-10)
        
        # add a new robot to the list of robots
        self.robots.append(robot.Robot(x,y))

    def update(self):
        # each robot moves according to its speed and direction
        for r in self.robots:
            r.move()
            # determine if the robot has fallen in a pit
            if self.in_pit(r):
                r.not_alive()

    def in_pit(self,r):
        # determine if robot has fallen in any of the pits
        # this does not work great because of comparing circles to squares
        # often the robot is close (but not in) and "falls in"
        for pit in self.pits:
            deltaX = math.pow(pit.middle[0]-r.location[0],2)
            deltaY = math.pow(pit.middle[1]-r.location[1],2)
            if math.pow(deltaX+deltaY,0.5) <= r.radius+pit.size/2:
                return True
            
        # if not in any pit, then ...
        return False


        
