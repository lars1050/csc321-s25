### Machine Learning with Simulated Annealing

This is an in-class exercise only. You will be working in a small group, but each of you will have your own version on your computer. This way, you can experiment with the cost function and defining what a "neighbor" is.

<hr>

There are many machine learning techniques that attempt to solve optimization problems -- meaning problems that have a _best_ solution. If you think of a space that contains a bunch of solutions, these techniques work by randomly exploring that space, keeping track of the best solution thus far. At each step, the current "solution" is scored to determine how good of a solution it is. If the AI thinks it should keep looking, it might look at a neighboring solution or maybe it will randomly move to a place that is very far from its current location.

In simulated annealing, the idea is to look at close _neighbors_ to see if they offer a better solution (_neighbors_ are solutions that differ only slightly). If a neighbor is a better solution, then the AI moves to that solution. If not, it still might move to that solution, depending on both how long it has been looking and how bad the solution is. At first, the AI is encouraged to wander (even towards bad solutions). However, the more it explores, the less likely this becomes. The measure of how long it has run is called the _temperature_, because annealing is a process of slowly cooling a metal. Similarly, the temperature slowly cools for simulated annealing, making movement to bad neighbors less likely.

FYI: When an AI follows a path down to a better solution (because it costs less), it is called _gradient descent_. Many machine learning techniques are based on this idea, such as simulated annealing, genetic algorithms, and artificial neural networks.

## Sorting Numbers

You have been provided with some code to use simulated annealing (_SA_) to sort numbers. The SA code is mostly complete for you. It contains:

- solver.py: the main method for creating the problem and ai to solve it
- ai.py: the simulated annealing algorithm that can be applied to any context
- sorting.py: the problem set-up for sorting randomly ordered numbers

The primary piece that is missing is the cost function in sorting.py. The first thing to try is to score the solution by adding up how many pairs of numbers in the list are out of order, meaning the first is greater than the second. For example {1,3,2,4} has a score/cost of 1 because 3,2 is out of order (i.e. 3>2).

1. Create a cost function based on pairwise ordering.

Run this several times and see what are some of the "best" solutions that the AI has produced. Try increasing the numbers in the list and see what happens.

2. Create a cost function based on the numbers not matching the expected value. For example {4,2,3,1,5} would have a score/cost of 2 because 4 and 1 are out of order.

## Making a Smiley Face

Create another problem for the AI. Have it try to match a smiley face pattern. Create the problem in a file smiley.py that has `class Smiley`. It should have these class variables:

```
goal = [['O',' ','O'],
        [' ','-',' '],
        [' ','V',' ']]

characters = [' ','O','-','V']

row_count = 3
col_count = 3
```

And include a print function:
```
def print(self,pic):
    for row in pic:
        for char in row:
            print(char,end='')
        print()
```

To create an initial solution (saved as self.starter), create a new matrix of the same size as goal and fill it with random selections from characters (i.e. `random.choice(self.characters)`).

The class will also need the cost() and generate\_neighbor() functions. You can decide how to calculate the cost and create a neighbor.

> IMPORTANT: when you copy a matrix in Python through an assignment statement, be sure to `import copy` and make a deep copy (e.g. `best = copy.deepcopy(neighbor)`).

- https://www.mathworks.com/help/gads/how-simulated-annealing-works.html

            

