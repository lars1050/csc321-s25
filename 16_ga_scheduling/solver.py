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

'''

from make_students import make_students

import student
import ga

student_count = 20
courses = ['A','B','C','D','E']

# the first time you run this, keep this line
# after that, comment it out -- you only need to make the file once
make_students(student_count,courses)

f = open('students.csv')
student_info = f.readlines()
f.close()

students = []
for line in student_info:
    # make into a list
    lister = line[:-1].split(',')
    for i in range(2,len(lister)):
        lister[i] = int(lister[i])

    students.append(student.Student(lister))

#for s in students:
#    print(s)

ga.solve(students,courses)
