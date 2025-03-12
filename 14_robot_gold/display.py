# https://www.geeksforgeeks.org/python-turtle-screen-setup-method/#
import turtle

#import environment

WINDOW_SIZE = 800
    
class Display:

    def __init__(self,env):
        print('initializing display')

        self.env = env

        self.screen = turtle.Screen()
        self.screen.setup(WINDOW_SIZE+50, WINDOW_SIZE+50)
        self.screen.bgcolor("white")
        self.turtle = turtle.Turtle()
        self.turtle.hideturtle()
        self.turtle.speed(0)

        self.robot = turtle.Turtle(shape="circle",visible="False")
        self.robot.hideturtle()

        self.square_size = WINDOW_SIZE/env.size

        self.draw_grid()
        self.draw_stuff()

    def convert_row(self,r):
        '''
        Each row is marked by a line above and below. This returns the point centered between them.
        grid world origin is upper left. graphics origin is at the center.
        '''
        return WINDOW_SIZE/2 - r*self.square_size - self.square_size/2

    def convert_col(self,c):
        '''
        Each column is marked by a line to the left and to the right.
        This returns the point centered between them.
        grid world origin is upper left. graphics origin is at the center.
        '''
        return -WINDOW_SIZE/2 + c*self.square_size + self.square_size/2

    def draw_stuff(self):
        '''
        Iterate through the grid world to figure out what to display where.
        '''
        grid = self.env.grid
        for r in range(len(grid)):
            for c in range(len(grid[r])):
                if grid[r][c] == "pit":
                    self.draw_pit(r,c)
                elif grid[r][c] == "robot":
                    self.draw_robot(r,c)
                elif grid[r][c] == "gold":
                    self.draw_gold(r,c)
                # else nothing there to draw

    def redraw(self):
        '''
        When the robot moves, it is drawn at a new location.
        The grid_r and grid_c are at the center of the grid square.
        '''
        self.robot.pu()
        grid_r = self.convert_row(self.env.robot_location.row) - self.square_size/2
        grid_c = self.convert_col(self.env.robot_location.col)
        self.robot.goto(grid_c,grid_r)
        self.robot.color("green")
        font_style = ("Arial", 48, "normal")
        self.robot.write("🤖", align="center", font=font_style)


    def draw_robot(self,r,c):
        '''
        The first drawing of the robot.
        The converted coordinates are at the center of the grid.
        The robot is drawn so that its bottom is at the designated x,y location.
        '''
        print('robot at',r,c)
        self.robot.pu()
        self.robot.goto(self.convert_col(c),self.convert_row(r)-self.square_size/2)
        self.robot.color("green")
        font_style = ("Arial", 48, "normal")
        self.robot.write("🤖", align="center", font=font_style)
        #self.robot.showturtle()

    def draw_not_alive(self,r,c):
        '''
        Drawing the robot at its location, but it died.
        '''
        self.robot.pu()
        self.robot.goto(self.convert_col(c),self.convert_row(r)-self.square_size/2)
        self.robot.color("green")
        font_style = ("Arial", 48, "normal")
        self.robot.write("☠️", align="center", font=font_style)
            

    def draw_gold(self,r,c):
        # circles are drawn such that the bottom of the circle is its location
        print('gold at',r,c)
        self.turtle.pu()
        self.turtle.goto(self.convert_col(c),self.convert_row(r)-self.square_size/2)
        self.turtle.pd()
        font_style = ("Arial", 48, "normal")
        self.turtle.write("💰", align="center", font=font_style)
        #self.turtle.color("yellow")

        #self.turtle.circle(self.square_size/2)
        #self.turtle.color('black')

    def draw_pit(self,r,c):
        #print('pit at',r,c)
        self.turtle.pu()
        self.turtle.goto(self.convert_col(c),self.convert_row(r)-self.square_size/2)
        self.turtle.pd()
        font_style = ("Arial", 48, "normal")
        self.turtle.write("🌋", align="center", font=font_style)
        #self.turtle.circle(self.square_size/2)
        

    def draw_grid(self):
        '''
        Origin of the graphics window is at the center so each edge is +/-WINDOW_SIZE/2.
        The graphics window is divided evenly by the size of the grid world.
        The lines are then calculated to draw a grid onto the graphics window.
        '''
    
        half_window = WINDOW_SIZE/2

        # draw horizontal lines
        for i in range(self.env.size+1):
            r = -half_window + i*self.square_size
            self.turtle.pu()
            self.turtle.goto(-half_window,r)
            self.turtle.pd()
            self.turtle.goto(half_window,r)
        

        # draw vertical lines
        for i in range(self.env.size+1):
            c = -half_window + i*self.square_size
            self.turtle.pu()
            self.turtle.goto(c,-half_window)
            self.turtle.pd()
            self.turtle.goto(c,half_window)        

        
