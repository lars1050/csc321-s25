import math
import random
import copy

from location import Location

# potential direction the robot can move (up,right,down,left) -- not diagonal
MOVE_CHOICES = [ "N", "E", "S", "W"]
    
# each direction NSEW signifies changes in row and column (in grid coordinates)
MOVES = { "N":Location(row=-1,col=0), "E":Location(row=0,col=1),
          "S":Location(row=1,col=0), "W":Location(row=0,col=-1) }

class RobotWorld:
    '''
    Create a grid in which a robot moves around, avoiding pits and searching for gold.
    If the grid value is 0, it means it is empty.
    Otherwise, it will have a value of "pit" "robot" or "gold".

    The coordinates of the grid are very different from graphics coordinates.
    The grid follows typical matrix access, meaning grid[row][col].
    Whereas graphics windows are generally referenced as col,row in that order.
    The origin [0][0] of the grid is the upper left corner of the grid.
    The origin of the graphics window (0,0) is in the center.
    '''

    def __init__(self, grid_size = 7, pit_percent = 10):
        self.size = grid_size
        # create a grid size X size
        self.grid = [ [ 0 for i in range(self.size) ] for j in range(self.size) ]
       
        # size x size grid spaces (make pit_percent of those into pits)
        self.pit_count = int(pit_percent/100*self.size*self.size)
        self.add_random_pits(self.pit_count)

        # randomly place 1 robot and save its start location (to restart the moves while learning)
        self.robot_location = self.add_random("robot")
        self.robot_start_location = copy.copy(self.robot_location)
        
        self.add_random("gold")

        # initialize the status of the robot
        self.robot_alive = True
        self.found_gold = False

        # calculate the cost of dying (greater than cost of any other solution)
        self.die_cost = self.size*self.size + 1
        self.last_move = 0

        # potential solution for this problem is a series of movements through the grid.
        # Creating as many random moves as there are open grid spaces (size^2 -pits-(1 gold)-(1 robot)
        self.starter = [ random.choice(MOVE_CHOICES)
                         for i in range(self.size*self.size - self.pit_count - 2) ]

    def add_random_pits(self,number_pits):
        '''
        randomly place pits in the environment. These must be avoided by the robot.
        '''
        for i in range(number_pits):
            self.add_random("pit")

    def add_random(self,entity):
        '''
        Find an open space to place this entity. It could be a robot, gold, or a pit.
        To place it, is to set that grid location equal to the appropriate string, which is entity.
        An empty space is designated with a value of 0.
        '''
        # Keep trying until an emply grid space is found in which to place the entity
        placed = False
        while not placed:
            # choose a random grid location
            row = random.randrange(self.size)
            col = random.randrange(self.size)
            if self.grid[row][col] == 0:
                self.grid[row][col] = entity
                placed = True
        return Location(row=row,col=col)

    def cost(self,solution):
    	# >>>>>>> COMPLETE THIS 
        # count the number of moves it takes to find gold
        # OR make it very costly if the robot dies
        self.robot_location = copy.copy(self.robot_start_location)
        move_count = 0
        cost = 0
        for mov in solution:
        	move_count += 1
            status = self.move_robot(mov)
            if status=="dead":
                # have it cost more to die early
                return cost
            if status=="gold":
                self.last_move = move_count
                return cost
        self.last_move = move_count
        return cost
            

    def generate_neighbor(self,solution):
    	# >>>>>>>>>>>>>> COMPLETE THIS (try different approaches)
    	# randomly modify a move in some way (you decide)
        neighbor = solution.copy()
		# modify in some way ...
        return neighbor

    def move_robot(self,direction):
        status = "fine"
        r = self.robot_location.row + MOVES[direction].row
        c = self.robot_location.col + MOVES[direction].col
        
        if r<0 or r>=self.size or c<0 or c>=self.size:
            # fell off the grid. invalid movement. robot died.
            self.robot_alive = False
            status = "dead"
            return

        elif self.grid[r][c] == "pit":
            # fell into pit. robot died.
            self.robot_alive = False
            status = "dead"

        elif self.grid[r][c] == "gold":
            # yahoo. found the gold. move on top of it
            self.found_gold = True
            status = "gold"

        else:
            status = "fine"

        # move robot to the new grid location
        self.robot_location = Location(row=r,col=c)

        return status
            
        
        
        
        



        
