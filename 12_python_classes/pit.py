import random

class Pit:
    '''
    Square pit located somewhere in an environment.
    '''

    def __init__(self, x=0, y=0, size=20):
        self.location = [x,y]
        self.size = size

    def make_random(self,width,height):
        '''
        The pit is at a random location and a random size.
        The origin of the environment is at the center.
        The left edge is at -width/2 and right edge at width/2
        '''

        # determine random location within the environment
        w_half = (int) (width/2)
        h_half = (int) (height/2)
        self.location = [ random.randint(-w_half, w_half-self.size),
                          random.randint(-h_half, h_half-self.size) ]

        # random sized pit
        self.size = random.randint(20,50)

        # calculate x,y of middle of square (used to determine if robot overlaps pit)
        self.middle = [(int)(self.location[0]+self.size/2), (int)(self.location[1]+self.size/2)]

        # returning self (using the Builder pattern)
        return self
