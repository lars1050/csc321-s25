### 15 Strategy Pattern with Functions

This is an in-class exercise. If you miss class and you want to earn credit, complete this assignment on your own. Push your work to gitlab and complete a (re)grade request form. Be sure to give me access to the repo and provide the exact address where I can look at the work.

In this assignment, you will again implement the Strategy Design Pattern, except you will use Python instead of Java. Recall that you applied the Strategy pattern to provide robots with different strategies for movement and for sensing. 

One key concept to take away from this exercise is that functions are _first class objects_. This means that they are no different from variables. In Java, you saw the use of _lambda functions_ in the JUnit assignment (e.g. `()->assertEquals(...)`), which are a way that functions can be passed as an argument. There are also various _wrappers_ in Java to help facilitate using functions in the same way you use variables. 

In Python, there is no need for special constructs or wrappers or even lambda functions (although those are available in Python). Functions can be assigned to a variable and passed as an argument. The use of `( )` is a signal to the interpreter that the object in question has type function.

Here is an example:

```
def one(a):
	print('in one',a)

def two(a):
	print('in two',a)

def test(fn):
    print('working with function',fn)
	fn(10)

test(one)
test(two)
```

Give it a try!

And if you are curious about using lambda functions, try this:

```
test(lambda a: print('lambda',a))
```

We will be using the Strategy pattern implemented with functions in our next AI technique _Genetic Algorithms_. Similar to Simulated Annealing, this is an approach that randomly searches a solution space to solve a problem. Different strategies can be used to both represent the problem and to search the space.

<hr>

#### Strategy Pattern Reimagined

With your partner, use this concept of functions as variables to create a Python Robot class that uses different strategies for movement and sensing. Each Strategy in the Python version will be a function stored as an instance variable in the Robot class.

There are 3 move strategies: wheeled, omni, and fixed. In Java, if these were hard-coded they would look like this:

```
OMNI
double radians = heading * Math.PI/180.0;
location.x = location.x + (int)(distance * Math.cos(radians));
location.y = location.y + (int)(distance * Math.sin(radians));
}

WHEELED
double radians = heading * Math.PI/180.0;
location.x = location.x + (int)((double)distance*7/8 * Math.cos(radians));
location.y = location.y + (int)((double)distance*7/8 * Math.sin(radians));

FIXED (no change in location because the robot is unable to move)
```

Each sensing strategy should return a distance and angle to a sensed obstacle. If there are no obstacles sensed, return `None,None`.

There are 3 sensing strategies: camera, IR, and touch. In Java, if IR was hard-coded, it would look like this (note that this is a little different than our Java version):

```
// Randomly generate a reading of an obstacle in the environment
// It can be as close as 2 or beyond the max (thus not visible)
int[] obstacle = {null, null};
int distance = rand.nextInt(50*2) + 3;
if (distance > 50) {
	return obstacle;
} else {
	obstacle[0] = distance;
	obstacle[1] = rand.nextInt(30) - 15; // 0 degrees is straight-ahead
    }
}
```

The _camera sensor_ would be very similar to the IR, except it would have a distance reading between 1 and 300. And the angle would be in the range from -50 to +50 degrees. The touch sensor might look like this:

```
// Obstacle is known only when touch sensor in physical contact with obstacle.
// Randomly generate this signal (1 in 10 chance that there is an obstacle)
int[] obstacle = {null,null}
int spinTheWheel = rand.nextInt(10);
if (spinTheWheel != 1) {
      return obstacle; // nothing sensend
    } else {
      obstacle[0] = 0;	// no distance between robot and obstacle 
      obstacle[1] = 0;	// obstacle is straight ahead
      return obstacle
    }
}
```

<hr>


#### Creating the Robot class

With your partner(s), decide if one or both of you will be doing the programming. Regardless, talk with each other about the assignment and make sure you both understand the approach.

Create a file in which to define the Python Robot class. The class should have instance variables that hold a name, a position, which is stored as x and y, a movement strategy, and a sensing strategy. **In the constructor, define the name, the movement strategy, and the sensing strategy as the parameters.** Set the initial location to 0,0. 

**Create a method to describe the robot**. It prints the name of the robot and the strategies used (by printing the function associated with that strategy).

As before, the movement "strategy" will return the change in the x and y position, and then those changes are applied to the current position of the robot.

The move method in the Robot might look like this:

```
def move(self, int heading, int distance):

    dx, dy = move_strategy(heading,distance)
    self.x += dx 
    self.y += dy
    print(f'Moved to [{self.x},{self.y}]')
}
```

Similarly, there were different strategies for sensing. The sense method in the Robot might look like this:

```
def sense(self):
	distance, angle = sense_strategy()
	# REACT to an obstacle ...
```

One key addition to this version is for the robot to (pretend to) react to any sensed objects. For the "REACT" above, do the following:
- if there is an object at 0 distance, print("go backwards").
- if there is an object between 0 and 90 degrees (relative to the robot), print("turn left").
- if there is an object between -1 and -90 degrees, print("turn right").
- if no object is detected, print("as is").


#### Creating Strategies and Testing

Create a file for the movement and sensing strategies. In this file, define a function for each of the 3 movement strategies and define a function for each of the 3 sensing strategies (i.e. define 6 functions). Use the descriptions above to define each. A movement strategy function should have a heading and distance parameter, and return a change in x and y. A sensing strategy function has no parameters, and return a distance and angle. Remember that you can return 2 things from a python function.

Create a file to put it all together. In this file, import that strategies file and the robot class file. Define a collection of robots with various movement and sensing strategies. Here is some code you might use to test your robots:

```
moves = [ [random.randint(1,180), random.randint(1,10)] for i in range(10) ]

print()
robot1.descibe()
for m in moves:
	robot1.move(m[0],m[1])
	robot1.sense()

print()
robot2.describe()	
for m in moves:
	robot2.move(m[0],m[1])
	robot2.sense()
```

Keep these lessons in mind for our next session on Genetic Algorithms!



