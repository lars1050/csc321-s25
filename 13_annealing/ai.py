import random
import math
import copy

# THANKS claude.ai for helping me write this code!

class Ai:
    '''
    In this example, the computer will learn to match a pattern using simulated annealing.
    Simulated annealing is a technique that starts with a random solution and then
    randomly changes that solution, finding those changes that lead it closer
    to the solution.
    '''

    # initialize the parameters that control how long to run the AI and
    # how much to allow it to randomly wander around
    temperature = 100
    temp_min = 0.01
    cooling_rate = 0.95
    max_iterations = 1000
    attempts = 100          # attempts for each temperature setting

    def __init__(self,context):
        # get the starter solution and its cost.
        # this is both the current and best (thus far)
        self.current = context.starter
        self.current_cost = context.cost(self.current)
        self.best_solution = self.current.copy()
        self.best_cost = self.current_cost
        self.context = context

    def solve_problem(self):

        print('Start with ',self.current,'. Cost is ',self.current_cost)

        # tracking how many solutions have been attempted
        iteration = 0
        solution_count = 0
        
        # if completely cooled or attempted max iterations, done
        while Ai.temperature > Ai.temp_min and iteration < Ai.max_iterations:

            # attempts at this temperature
            for _ in range(Ai.attempts):
                
                # Generate a neighbor solution
                neighbor = self.context.generate_neighbor(self.current)
                neighbor_cost = self.context.cost(neighbor)
                cost_difference = neighbor_cost - self.current_cost
                
                # Decide whether to accept the neighbor
                if cost_difference <= 0:  # Accept better solutions
                    self.current = copy.deepcopy(neighbor)
                    self.current_cost = neighbor_cost
                    
                    # Update best solution if necessary
                    if neighbor_cost < self.best_cost:
                        self.best_solution = copy.deepcopy(neighbor)
                        self.best_cost = neighbor_cost
                        print('Better: ',self.best_solution,'. Score is ',self.best_cost)
                    solution_count += 1

                else:
                    # Accept worse solutions with a probability
                    acceptance_probability = math.exp(-cost_difference / Ai.temperature)
                    if random.random() < acceptance_probability:
                        self.current = copy.deepcopy(neighbor)
                        self.current_cost = neighbor_cost
                        solution_count += 1

            # Cool the temperature
            Ai.temperature *= Ai.cooling_rate
            
            # If we've found a perfect solution, we can stop
            if self.best_cost == 0:
                print(f'Perfect solution found in {solution_count} iterations.')
                return self.best_solution

            iteration += 1

        # did not find perfect solution. return the best so far
        return self.best_solution



            

    

    
