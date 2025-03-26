class Student:

    def __init__(self,data):
        '''
        Create a student object based on a list of information.
        List is in the order: last,first,prefA,B,C,D,E
        The prefA,B,... is the student ranking for that course.
        The higher the ranking, the more they prefer that course.
        '''
        self.last = data[0]
        self.first = data[1]

        # create a dictionary that holds the preference/rank for each course
        self.preferences = {}
        index = 2
        for course in range(ord("A"),ord("E")+1):
            self.preferences[chr(course)] = data[index]
            index += 1

    def __str__(self):
        # pretty print function
        out_string = self.get_name()+' '
        for k,v in self.preferences.items():
            out_string += f'{k}:{v} '
        return out_string

    def get_preference(self,course):
        return self.preferences[course]

    def get_name(self):
        return self.last+","+self.first

    
            
