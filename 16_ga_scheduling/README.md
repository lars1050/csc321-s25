### 16 Scheduling Classes with Genetic Algorithms

Worksheet is Due at the end of class on Friday, March 27

Team coding is due Wednesday, April 2 end-of-day with 24 hour grace period

A Genetic Algorithm is a search technique for solving a problem.
It explores a solution space by creating a population of individuals,
each being a potential solution to the problem. Typically, you think of the solution as a string of dna. It then calculates the fitness of each solution and uses that fitness to create the next generation.

The more fit an individual is, the more likely they will be selected as a
parent for the next generation. To make a new individual for the next
generation, 2 people are chosen at random. Those with a higher fitness score
are more likely to be selected. The solutions are recombined to make 2
new individuals. On occasion, one of the individuals is subject to a "mutation" -- a random modification to the individual solution.

In this problem, which is a classic scheduling problem, the goal is to enroll each student in 1 course. Ideally, each student would be enrolled in their preferred course (ie. the one ranked the highest), and every course would have the same number of students.

As with simulated annealing, the fitness function (or score) of a solution plays a key role in how well the learning system works. It is up to the designer to determine how to represent the problem and how to evaluate fitness.

```
population = create several individuals (i.e. potential solutions to problem)
best = most fit of the population

while not solved or evolved enough generations:
	
	determine the fitness of each potential solution
	
	best = max( best, most fit in current population)
	
	add the best to the current population
	
	# make the next generation
	for _ in half the size of the population
	
		parent1 = monte carlo selection from population
		parent2 = monte carlo selection from populaton
		
		# make offspring by mixing "dna"
		child1 = partial solution from parent1 + partial solution from parent2
		child2 = partial solution from parent2 + partial solution from parent1
		
		add child1 and child2 to a new population
	
	by some probabilty, randomly mutate some random individual 
```

<hr>

You will begin this work by completing the worksheet from Google drive with your team mates. Pull the code, which you will need to experiment with. 

Run the code by running solver.py. The first time you run it, a csv file of students will be made. After that, you can comment out `make_students()` as long as you want to keep the number of students the same.

At the moment, the code is hard coded in some places for the 5 courses "A" through "E", so you should not change that.

<hr>

### Working with Your Group

The goal will be to make it easier to experiment with the code. This will require using functions as first-class objects and refactoring the code. You will also add some data collection for your experiments.

You know what to do ... repo and collaborators.txt file.

```
As always, use issues and branches.
```

- Issue #1: refactor-fitness-function: Modify the ga code to include a fitness function variable. In the solve() function, instead of embedding the fitness calculation in the function, call this function variable. The fitness function will have 3 parameters, in this order: population, students, and courses. It returns the population fitness. Add this function to the solve() parameter list.

- Issue #2: feature-create-fitness-function: In a separate file, create a fitness function that can be called in the ga.solve() function. This function has 3 parameters, in this order: population, students, and courses. It returns the population fitness. Coordinate with issue #1 author to put these pieces together.

- Issue #3: refactor-generation-function: Modify the ga code to include a next generation function variable. In the solve() function, instead of hard-coding the call to next\_generation(), call this variable. 

- Issue #4: feature-create-generation-function: In a separate file, create a next generation function. The next generation function will have the same 2 parameters as it does now -- population and population fitness. Coordinate with issue #3 author to put these pieces together.

- Issue #5: feature-alternative-fitness: In a separate file, create a fitness function (different from the other one). Be sure to test it!

- Issue #6: feature-alternative-generation: In a separate file, create a next generation function (different from the other one). Be sure to test it!

- Issue #7: refactor-course-count: Currently, the number of courses are hard-coded in various places. Refactor the solver.py, ga.py, and student.py to be flexible in how many courses students can choose from. This touches every part of the code. **Do not take this on unless you can be responsible about communicating with your group so that you can do this at a time when it will not interfere with your teammate's ability to work on the code.**

- Issue #8: feature-data-collection: Add to the code the ability to track the progress of the learning. At the very least, record the best fitness and average fitness at each generation. You are welcome to add other aspects of interest to you.

- Issue #9: feature-plot-data: Determine how to incorporate matplotlib into the code. It should plot the data collected from issue #8. If someone has taken DST314, this should be pretty easy. You will have to install numpy for the matplotlib package. 


		
		
	




