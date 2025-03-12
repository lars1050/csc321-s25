## Assignment 14: Learning to Navigate Using Simulated Annealing

DUE: AFTER spring break on Tuesday, March 25 end-of-day with 24 hour grace period.

> PLEASE ASK ME if you get stuck. I realize this is challenging because you are learning new Python syntax and machine learning at the same time. I am happy to explain more, help you debug, or brainstorm solutions!

In this assignment, you will complete this program in which a robot learns to navigate a world using simulated annealing. The grid world in which the robot lives contains deadly pits and a bag of gold. The objective is to get the robot to the gold in the fewest number of moves.

The included files are: 
- solver.py: the main driver of the program
- ai.py: a generic framework for simulated annealing
- environment.py: a grid world with a robot, pits, and gold
- location.py: a basic data structure for holding row and col
- display.py: a turtle graphics visualization of the grid world

#### The AI Set-Up

A solution for this problem is a series of robot moves, starting at the robots randomly generated start location. There are as many possible moves as there are empty grid spaces in the world. The robot can move North-South-East-West, provided it does not go off the edge of the world. If it falls off the world or lands on a pit, it will die. It "wins" if it lands on gold. Once the robot dies or wins, it stops moving (even if there are more moves in the solution).

> The objective is to minimize the number of moves that it takes to get from its random starting location to the gold.

This string of moves is randomly modified to explore other potential solutions. As the temperature cools, it is less likely to explore worse solutions. The AI tracks what is the best solution thus far and returns it after max iterations (or the temperature has reached its minimum).

#### How the Code Works

> It is important to have a reasonable understanding of how the code works. Please spend time tracing the flow-of-control so that you can more easily debug it and refactor it.

The solver creates the grid world, specifying how large of a grid to make and what percent of the world is covered in deadly pits (well, I used a volcano emoji, but still deadly). The larger the world and the higher the percent of pits, the more difficult the learning task becomes. The solver initializes the AI and the display, then asks the AI to solve the problem. The best solution is returned, and the solver animates the solution.

The AI is as it was in the last assignment. It is a general framework that can take any problem that has a starting solution, a cost function, and a neighbor generator (_if we were using Java, we would define a Problem interface_).

The environment creates the grid world (in the RobotWorld class), the robot, the pits, and the gold. It has a cost and neighbor function for the AI. And it manages the movement of the robot.

The display uses Turtle graphics to visualize the world.

#### Your Task

Somebody make a repo named username-repo-14 with the 14\_robot\_gold folder in assignment14 subgroup on gitlab. Add the collaborators.txt file with both your names. A .gitignore is not necessary, but you can add one to ignore `__pychache__` if you like.

With your partner, complete the following. For each, create an issue and a branch.

1. (BOTH) Discuss and determine a cost function for the problem. Consider the following:
	- The lower the cost, the fewer moves have to be made to capture the gold.
	- If the robot dies, the cost should be very, very high.
	- The quicker the robot dies, the more costly it should be. You can add to the cost of dying an additional cost based on the number of moves until death, such as size^2/moves. Note that this decreases as the number of moves (until death) increases.
	
2. (Member A) Implement the cost function. It might not work as anticipated, so give some careful thought to the problem and modify it as needed.

> The robot keeps learning even after it has found gold. The goal is to find the shortest path to gold, and you really can't know if you have found the shortest path.

3. (BOTH) Each of you create a different approach (strategy) for generating a neighboring solution. Keep in mind that you probably only want to change the values that impacted the cost of the solution, meaning only up until the robot dies or finds gold. You can try changing 1 move at a time or several. You can change by swapping or setting a move to a new randomly selected one (from MOVE\_CHOICES).

4. (Member B) Each time there is a new "best" solution, track the number of iterations that it took to get that solution. Print that information in the solver in some way that a user can understand it.

5. (BOTH) Find something in the code to _refactor_. This means reorganize or reimplement some part of the code. It does not have to be a big change. Perhaps it is writing a small helper function, renaming variables, reorganizing the code order, etc. However, the refactoring should be for a good reason! Code always needs a second look and a reworking. In the issue, state WHY you are factoring or what you hope to improve about the code in the refactoring process.

> Please look throug at least one of these resources to better understand code refactoring.

- https://www.techtarget.com/searchapparchitecture/definition/refactoring
- https://www.ulam.io/blog/why-refactoring-code-important#
- https://en.wikipedia.org/wiki/Code_refactoring
- https://medium.com/marktech/going-the-extra-mile-on-leetcode-refactoring-53116697f89a

