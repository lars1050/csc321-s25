### 16 Scheduling Classes with Genetic Algorithms

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
		
		
	




