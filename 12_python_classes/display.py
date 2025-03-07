# https://www.geeksforgeeks.org/python-turtle-screen-setup-method/#
import turtle

#import environment

class Display:
    '''
    Turtle graphics window for displaying the robot environment.
    Each robot is a turtle that redraws as its location is updated.
    Pits are stationary - drawn as boxes 1 time.
    '''
    
    def __init__(self,env):
        # the environment being displayed
        self.env = env

        # create the graphics window
        self.screen = turtle.Screen()
        self.screen.setup(env.width,env.height)
        self.screen.bgcolor("gray")
        self.turtle = turtle.Turtle()
        self.turtle.hideturtle()
        self.turtle.speed(0)

        # create a list of robots that will be dynamically updated
        self.robots = []

    def draw(self):
        # draw stationary pits
        for pit in self.env.pits:
            self.draw_pit(pit)

        # create a turtle robot to correspond to each robot in the environment
        for robot in self.env.robots:
            # turtle is hidden while it is being placed
            trobot = turtle.Turtle(shape="circle", visible=False)
            trobot.speed(0)
            trobot.shape("circle")
            trobot.color("green")
            trobot.pu() # pen up
            trobot.goto(robot.location[0],robot.location[1])
            
            # now it is placed so it should be visible
            trobot.showturtle()

            # add the pair [ robot in the environment, corresponding turtle robot]
            self.robots.append([robot,trobot])

    def update(self):
        '''
        relocate, thus redraw each "turtle" that corresponds to a robot in the environment.
        The list of robot pairs are in self.robots.
        The robots move within the environment and are redisplayed here.
        '''
        
        # time to redraw the turtles (because the robots in the environment moved)
        for robot in self.robots:
            
            # if fell in a pit and not alive ...
            if not robot[0].alive:
                robot[1].color("red")
                continue # move on to the next one

            # move the turtle robot to the new location of the corresponding robot in the environment
            robot[1].setx(robot[0].location[0])
            robot[1].sety(robot[0].location[1])

    def draw_pit(self,pit):
        # a pit is a square. its location specifies the location of the lower left corner
        location = pit.location

        # move the turtle to the pit location (pen up while moving)
        pen = self.turtle
        pen.pu()
        pen.goto(location[0],location[1])
        pen.pd()

        # set the color of the pit
        pen.fillcolor("black")

        # draw bottom, right, top, left edge
        pen.begin_fill()
        pen.goto(location[0]+pit.size,location[1])
        pen.goto(location[0]+pit.size,location[1]+pit.size)
        pen.goto(location[0],location[1]+pit.size)
        pen.goto(location[0],location[1])
        pen.end_fill()
        


        
