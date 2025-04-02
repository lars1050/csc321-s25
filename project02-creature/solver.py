import swimmer
import ga

'''
Please do not change the signature of the Problem and GA constructors.
If you think it needs to be changed, please let Dr. Larson know.
'''

mutation_rate = .01
max_generations = 1000
population_size = 100

# function for selecting parents
selection_function = generalized_selection

# Create the "swimmer" problem.
# The problem is to learn a swimming stroke that maximizes forward motion.
problem =  swimmer.Problem()

# Create a genetic algorithm that can solve the problem
ai = ga.GA(
    mrate = mutation_rate,
    gens = max_generations,
    pop = population_size,
    fselect = selection_function
    )

best = ai.solve(problem)
