### Project 02: Evolving a Creature to Swim

Due: Sunday, April 20 end-of-day with 24 hour grace period

In this project, you will work in a team to build an application that uses a genetic algorithm to evolve how a creature swims with the aim of maximizing forward motion. 

The "creature" is a body with 2 stick arms. The arms are joined on the side of the body and can rotate within a semi-sphere. The "shoulder" can rotate around the y-axis and the z-axis. Rotation around y causes up and down motion of the arm. Rotation around z causes forward and backward motion of the arm. Each of these rotations can be expressed as an angle. The position of the "end-effector" -- meaning the end of the arm, can be determined from the 2 angles that represent the rotation. This calculation is called "forward kinematics."

In more relatable terms, stiffen your elbow, stretch your arm out to the side (perpendicular to your body), point your finger, and flap your arms up and down like you are doing jumping jacks (that is rotation around the y-axis). Again with your arms out to the side, bring them together in front of you (that is rotation around the z-axis. Given 2 angles of rotation, you can determine the (x,y,z) position of the end of your finger relative to your shoulder. Now, imagine that same motion, but lying face down in a pool.

If you list a series of pairs of angles that the arms move through, this creates a series of positions of the end-effector (i.e. your finger) corresponding to those angles. Any change in the y-position can be interpreted as forward motion of the creature. And the faster the motion, the more forward progress it can make. Think of an oar pushing through the water to make the boat go forward. This is the power stroke. But now you have to get the arm back in position, which means you might cause some backward motion. This is the recovery stroke.

You are going to use a genetic algorithm to evolve the movement of the arm to hopefully create a power and recovery stroke to maximize forward motion. An individual starts as a series of 16 random angles (8 pairs) in the range -90 to +90. The first 2 angles correspond to the y-axis and z-axis rotation at the start. At the next time unit, the arms are rotated to get to the next 2 angles. And so on. At each transition from angles to angles, the change in y and the velocity of that motion is calculated to estimate forward motion. The fitness of the creature scales with its total forward motion across the entire stroke (i.e. the more it moves forward during its full stroke, the higher its fitness). Code has been provided that calculates forward motion given 2 pairs of angles.

A genetic algorithm can be applied to different problems. The algorithm does not change, only the problem (i.e. how an individual is defined and its fitness calculated). One of the key aspects of this assignment is to create a generic framework for GAs that can work on any type of problem. The simulated annealing assignment was set up in this way. This framework will be so generic, that you could solve the scheduling problem, swimming creature, and gold-seeking robot using the same GA code without modification. 

<hr>

### Project Implementation Outline

All code will be written in Python. The 2 primary components are:

1. A generalized framework for the genetic algorithm. Define a class called `GA` in the file `ga.py`. The constructor of the class has keyword arguments (kwargs) that set various aspects of the GA (e.g. rate of mutation).

2. The swimming creature problem. Define a class `Problem` in the file `swimmer.py`. It should contain the following methods:

	- get\_individual(): returns a randomly configured individual. In this case, a series of 16 random angles in the range of -90 to +90.
	
	- evaluate\_fitness(individual): returns the fitness of that individual.
	
	- optional: any other getters, setters, or functions that would be helpful in implementing the problem. 

The file Solver.py has been provided. You must use this file in your project to create the GA, the problem, and to solve the problem. It contains this code:

```
import swimmer
import ga

problem =  swimmer.Problem()
ai = ga.GA(mrate=.01,gens=1000,pop=100,fselect=generalized_selection)
ai.solve(problem)
```


The arguments to the GA constructor "tune" the genetic algorithm. These include the rate of mutation (mrate), maximum number of generations (gens), the population size (pop), and a function for parent selection (fselect). These are passed using _**kwargs_, which is a special way that Python passes named arguments. Each of these parameters should have default values (i.e. defined with some default value for whenever the user does not specify as an argument). Do a little research to figure out how to use kwargs.

### Experimenting with Learning 

As you did with the GA scheduling problem, you will set up this implementation so that you can experiment to see if you can impact the learning. As part of the experiment, **create the following functions**:

- A function that selects parents using Monte Carlo selection that picks from the entire population.

- A function that selects parents using Monte Carlo selection, but not including the bottom 10%. You can do this by sorting the population fitness, then setting the fitness of the first 10% to 0. Then they will have a 0% chance of being selected.

- A function that selects 1 parent using Monte Carlo selection from the entire population, and selects the other parent randomly from the top 10% of the population. The top 10% can be determined by sorting individuals in reverse (from max to min fitness), then randomly choosing amongst the top 10% (i.e. `random.randint(0,pop_size*.10)`).

These functions should be defined in a separate file called selection\_fns.py. Note that they are passed to the GA during construction.

As with the scheduling problem, **add plotting of the progress of learning**. Show how the average fitness and best fitness changed over time. 

Experiment with the GA. Try different population sizes, mutation rates, generations, and selection functions. See which can get the ga to converge on the highest fitness in the least amount of time.

An animation wil be provided. This will allow you to see the motion of the best individual.

<hr>

## Documentation

Create a README.md for this project. In the readme, 

- List each team member and their respective roles. 
- State which issues each team member **completed** or **attempted to complete**. 
- Specify how you communicated with each other and generally how often. 
- Describe your process for testing the code before its final submission.
- Add links to the tags that you made. Periodically, I will ask you to "tag" your repo, which means take a snapshot. This allows me to see how you progressed over time. The expectation is that you regularly work on the assignment. Do not wait until the last minute.

- Importantly, **write a paragraph about your experiments**. State what worked the best to solve this problem, and how you determined that.

<hr>

Each team member will submit a report to Moodle - due Wednesday, end-of-day. In your report, respond to the following questions or prompts. Each of your responses should be answered in a separate paragraph (or 2 if warranted).

- The role that you chose and some examples of what you did in that role.

- Reflect on your communication, contributions, and management. Describe something that you think you did well. Describe how you might improve in the next project.

- List each teammate, and for each teammate, identify something that you think they did well. Also identify something they could improve (i.e. provide constructive criticism that they could use for their next project). I will not share this information with your teammates. 


### Issues

It is the responsibility of the team to create the issues. Issues should be relatively small. Try to create issues that can be tested when complete. Once you have determined the issues, add them all to gitlab. Each issue should have a descriptive name and a sentence or two that describes what will be implemented. Identify the issues by end-of-class Friday. They will be reviewed to ensure they make sense for this project.

> You can assign issues as they are addressed.

> Be responsbile. Communicate. If you are a procrastinator, pay attention to the deadlines and limit your procrastination. It is not fair to your teammates to wait until the last minute. And you will be docked points for this behavior. For those of you who are non-procrastinators, please do not turn this into an individual project. 

Create a branch for each issue and merge to main when complete. Please do not delete branches. As issues are completed, mark them as closed. 

> NOTE: branch names are case sensitive. Keep everything lower case so you do not accidentally create 2 branches of the same name except with different capitalization.

Please use the gitlab "merge request" for merging branches with main. It is so much easier. And please be careful and thoughtful when merging. **So, don't rush when merging. Look at all the information on the screen and make sure it makes sense. If you are not sure, just ask a team member or Dr. Larson to watch as you complete it.** Most things are recoverable, but it is better to not have to do that. 

Keep in mind that your branch is YOUR branch. If you mess it up, you can start over. It only impacts others when it is merged with main. This is made easier if you make the issues relatively small. If you take on a more challenging issue, push often in case you have to revert back to a previous version.


### Roles 

Each of you should take on one of the following roles. I suggest that you choose one that matches your strengths.


- **Git Manager**. This person establishes the repo with the starter code. They make sure the .gitignore and collaborators.txt is correct. They keep an eye on the branches, and try to help others with git and with merging. They manage issues on gitlab. And they tag the repo.

- **Team Coordinator**. This person helps each team member pick their next issue(s) to tackle. This person knows generally what everyone is working on to try to avoid merge conflicts. They check in regularly to see where the problems are and to coordinate effort among team members to address problems. They are responsible for communicating to the team.

- **Code Manager**. This person keeps an eye on the main branch. The main branch should always be functional. This person should periodically run the main branch and make sure everything is looking and operating as expected. This person checks the code against issues to ensure things are correct and complete. They also keep an eye on the code and make sure it is organized and well documented.

### Getting Started

The Git Manager should create a repo. Please name the repo **username-repo-project02**. Clone the repo. Pull the github class repo and copy the code into the gitlab repo. Create a .gitignore. Push to gitlab.

Now everyone can clone the repo.

The Git Manager creates a collaborators.txt when they get a chance.

Communications: think about how you want to communicate.

Team Coordinator: review the issues with everyone and start to identify a place to start for each team member. Think about how the team will track who is working on which part. 

Git Issues Manager: decide how the team should manage the issues. Are you going to add them all to the repo or is each person going to add them as you go?

Code Manager: Think about how the team will conduct merges with the main branch. Discuss the process. Probably document that process.


<hr>

**ASSESSMENT**

You will be assessed on both your technical and teamwork accomplishments. In general:

- 4 pts: How well you carried out the Role that you chose.

- 4 pts: Being a good team player (as evidenced by your self-reporting and the reporting by your team mates).

- 3 pts: Completing the report at the end of the project. Please submit via MOODLE (link in week of Mar 03)

- 3 pts: Consistent contribution to the project. This means that I can see regular commits to the project.

- 2 pts: Good git management. This means that you were consistent in using branches and naming them correctly. You were careful and thoughtful when performing merges into main. If you are feeling shaky about merging with main, put in the merge request and ask if someone on your team can help you complete it.

- 10 pts: The code that you implemented. Please test your code.

- 4 pts: The overall quality of the project, which depends on how well the team worked together. This includes the functionality of the code, meeting all the implementation requirements, and completing the documentation.

Total of 30 points (weighted as 10% of your grade).






















