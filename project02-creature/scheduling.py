import math
import random
from make_students import make_students_file

courses = ['A','B','C','D','E']
student_count = 25

class Student:

    def __init__(self,data):
        # last,first,pref A,B,C,D,E
        self.last = data[0]
        self.first = data[1]
        self.preferences = {}
        index = 2
        for course in range(ord("A"),ord("E")+1):
            self.preferences[chr(course)] = data[index]
            index += 1

    def __str__(self):
        out_string = self.get_name()+' '
        for k,v in self.preferences.items():
            out_string += f'{k}:{v} '
        return out_string

    def get_preference(self,course):
        return self.preferences[course]

    def get_name(self):
        return self.last+","+self.first



class Problem:

    def __init__(self,file_exists=False):
        if not file_exists:
            make_students_file(student_count,courses)
        
        self.students = self.read_student_file()
        self.count = 0
        self.courses = courses
        self.ideal_enrollment = len(self.students)/len(courses)


    def get_individual(self):

        return [ random.choice(self.courses) for i in range(len(self.students))]
    

    def evaluate_fitness(self,enrollments):
        '''
        enrollments is a list of assignments of student to course.
        for example, if there are 5 students
            and enrollments = [ 'A', 'C', 'A', 'B', 'A' ]
        then fitness is based on
        - how much student[0] likes 'A'.
        - how much student[1] likes 'B'.
        etc.
        In other words, fitness += student[i].get_preference(enrollments[i])
        '''

        fitness = 0
        # sum the ratings from each student based on their enrollment
        # each element of individual 
        for i in range(len(enrollments)):
            student = self.students[i]
            fitness += student.get_preference(enrollments[i])
        for c in self.courses:
            fitness += min(0,self.ideal_enrollment-enrollments.count(c))*2
            
        return fitness
        

    def mutate(self,individual):
        individual[random.randrange(0,len(individual))] = random.choice(self.courses)

    def print_roster(self,schedule):
        rosters = { "A":[], "B":[], "C":[], "D":[], "E":[] }
        for i in range(len(schedule)):
            rosters[schedule[i]].append(self.students[i])

        for k,v in rosters.items():
            print(k)
            for s in v:
                print(s)

    def read_student_file(self):

        f = open('students.csv')
        student_info = f.readlines()
        f.close()

        students = []
        for line in student_info:
            # make student on that line into a list
            lister = line[:-1].split(',')
            
            # most need to be cast to an int
            for i in range(2,len(lister)):
                lister[i] = int(lister[i])

            students.append(Student(lister))

        return students







