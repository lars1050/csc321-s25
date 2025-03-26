'''
A Genetic Algorithm is a search technique for solving a problem.
It explores a solution space by creating a population of "solutions".
It then calculates the fitness of each solution and uses that fitness
to create the next generation.

The more fit an individual is, the more likely they will be selected as a
parent for the next generation. To make a new individual for the next
generation, 2 people are chosen at random. Those with a higher fitness score
are more likely to be selected. The solutions are recombined to make 2
new individuals. On occasion, one of the individuals is subject to a "mutation" --
a random modification to the individual solution.

In this problem, which is a classic scheduling problem,
the goal is to enroll each student in 1 course.
Ideally, each student would be enrolled in their preferred course (ie. the one
ranked the highest), and every course would have the same number of students.

There is a list of students.
An "individual" is a list of courses from "A" to "E" the length of students.
Each course in an individual/solution corresponds to a student.

So ... individual[0]="B" means students[0] is enrolled in course "B"
students[0].get_preference("B") would tell you how the student ranks that course.
The higher the rank, the more they like it.
'''

import random

# number of individual solutions at each iteration
population_size = 100

# number of times the population will evolve
generations = 500

# probability of a mutation occuring
mutation_rate = 0.20


def solve(students,courses):
    '''
    Use a genetic algorithm to find the best scheduling of students in courses.
    @param students: list of Student objects
    @parm courses: list of courses students can enroll in.
    '''

    student_count = len(students)

    # ideally, every class would have the same number of students enrolled
    ideal_enrollment = student_count // len(courses)

    # perfect score would be each student gets their highest ranked course
    # AND there is the same number of students in every course
    # If there is equal enrollment, the score will be based on the ranking.
    # Any unevenness in enrollment will result in a lower score
    perfect_score = len(students)*len(courses)

    # generate an initial population
    population = []
    for _ in range(population_size):
        # randomly assign each student to a course
        # this is an individual/solution. Add it to the population
        population.append([ random.choice(courses) for i in range(student_count)])

    # track the best individual throughout the process
    best_fitness = None
    best_schedule = None

    for i in range(generations):
        if (i%500==0):
            # letting the user know how far along it is in evolution
            print(f'generation {i}')

        # calculate fitness of each "individual", meaning enrolled list
        # fitness at [0] corresponds to individual at population[0]
        population_fitness = []
        for i in range(len(population)):
            fitness = 0

            for j in range(len(population[i])):
                # fitness based on the preference/rank of the course
                # that this student was enrolled in
                fitness += students[j].get_preference(population[i][j])
            for c in courses:
                # trying to maximize fitness.
                # if a course is overenrolled, decrease fitness
                fitness += min(0,ideal_enrollment-population[i].count(c))
                #fitness += 0

            # fitness is an integer that corresponds to the quality of
            # the solution for individual at population[j]
            population_fitness.append(fitness)

        
        # determine most fit of this population.
        # determine if better than any previous generation
        best_in_pop = max(population_fitness)

        # if this is our first generation ...
        if best_fitness==None:
            print(f'initial best fitness: {best_in_pop}')

        # if this generation is better than any in the past ...
        if best_fitness==None or best_in_pop > best_fitness:
            print(f'improved to {best_in_pop}')
            best_fitness = best_in_pop
            index_of_best = population_fitness.index(best_in_pop)
            best_schedule = list(population[index_of_best])

        # always include the best of the best when creating the next gen
        population.insert(0,best_schedule)
        population_fitness.insert(0,best_fitness)

        # create next generation
        population = next_gen(population,population_fitness)

        # maybe a mutation
        if random.random() < mutation_rate:
            rand_student = random.randrange(0,len(students))
            rand_individual = random.randrange(0,len(population))
            random_value = random.choice(courses)
            population[rand_individual][rand_student] = random_value

    print('\n\n BEST ...')
    print(best_schedule)
    print(f'Fitness of this is {best_fitness}')
    print(f'Ideal fitness is {perfect_score}')

    # print the solution
    print_roster(best_schedule,students)

def print_roster(schedule,students):
    # create a dictionary to hold the list of students enrolled in each course
    rosters = { "A":[], "B":[], "C":[], "D":[], "E":[] }

    for i in range(len(schedule)):
        # add student[i] to the roster which they were assigned.
        # note that the position [i] in the schedule corresponds to the students[i]
        rosters[schedule[i]].append(students[i])

    # print the roster
    for k,v in rosters.items():
        print(f'\n___Course {k}___')
        for s in v:
            print(s)


def next_gen(pop,pop_fit):
    '''
    create the next generation based on the current population.
    Repeatedly choose parents, based on fitness, to create a child.
    '''
    
    next_generation = []

    # every set of parents creates 2 children, so do this popsize/2
    for i in range(population_size//2):

        # choose parents based on fitness, which influences likelihood of selection
        parent1 = pop[monte_carlo_selection(pop_fit)]
        parent2 = pop[monte_carlo_selection(pop_fit)]

        # randomly choose a point to mix up their "dna"
        divide_at = random.randrange(1,len(parent1))
        next_generation.append(parent1[:divide_at]+parent2[divide_at:])
        next_generation.append(parent2[:divide_at]+parent1[divide_at:])

    return next_generation
        

    
def monte_carlo_selection(weights):
    '''
    Modified from claude.ai
    monte carlo selection randomly selects from a list based on how
    much each is "weighted". The more it is weighted, the more likely
    it is to be selected.
    '''

    # First, "normalize" all the weights. If you sum them all up, they total 1.0
    total = sum(weights)
    normalized = [int(w/total*100+.5)/100 for w in weights]
        
    # Generate random number betwen 0 and 1
    r = random.random()
    
    # randomly select based on probability for each item
    # returns the index of the item to be selected
    selection_probability = 0
    for i in range(len(normalized)):
        selection_probability += normalized[i]
        if r <= selection_probability:
            return i
    # in case the weights do not perfectly total 1.0 (due to rounding error)
    return i

