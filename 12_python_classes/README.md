### Assignment 11 Using Python Classes

DUE: Tuesday, end-of-day

In this exercise, you will get practice using and creating Python classes. The code provided is very similar to the disease model that you just completed. There is an environment (i.e. the _model_) in which robots move around with a risk of falling in a pit with a chance to find gold. There is a graphics display (i.e. the _view_) that uses Turtle graphics to create a display window depicting the environment. And it is all created and managed by the simulation (i.e. the _control_), which all together is a model-view-controller (or MVC) design pattern. 

The following files contain Python classes for the simulation.

- _environment.py_ defines an area in which robots, pits, and gold exists.
- _robot.py_ entity with a location and direction of movement.
- _pit.py_ stationary object in environment which robots fall into 
- _display.py_ defines a turtle graphics window to display the environment.

 The main driver for the code is _simulation.py_.

First, take some time to look through the code to understand what each class does and how the simulation works. Again, this is very similar to the disease model that you just completed.

A few slides to get you thinking about how OOP concepts are implemented in Python: 


The required modifications include:

- in robot.py at line #26, set the delta list to random values for delta[0] and delta[1].
- in robot.py at line #46 and #53, check if the robot has gone off the edge of the environment and adjust appropriately to bounce off the walls
- create a new class Gold in a file gold.py. Model it after pit.py. You decide the size, shape, and color of the gold.
- in environment.py, define a function _add\_random_gold. Place exactly 1 pile/piece/bag of gold to the environment. The gold is an instantiation of your new Gold class.
- in environment.py, add a member variable _gold_.
- in environment.py, add a function _found\_gold()_ that returns a boolean. Model it after _in\_pit()_, except you only need to check if the robot is overlapping the gold.
- in display.py, incorporate the drawing of the gold.
- in simulation.py, incorporate gold into the environment.
- in robot.py, add a member variable _found\_gold_ = False. Model this after "alive" and set it appropriately if/when the gold is found.

Work with a partner to complete the assignment. You and your partner decide how to work together. You and your partner decide who is going to work on which aspect.

There is a subgroup assignment12 in which to place your work.

Please make sure your collaborators.py file is correct.

- https://www.w3schools.com/python/python_classes.asp
- https://docs.python.org/3/tutorial/classes.html
- https://www.dataquest.io/blog/using-classes-in-python/
- https://www.learnpython.org/en/Classes_and_Objects

