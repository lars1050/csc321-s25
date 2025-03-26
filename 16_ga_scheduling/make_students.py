import random

'''
This creates a csv file with random students.
Each row in the file is a student.
Each student has a last name, first name, followed by a series of rankings of courses.
'''

firsts = ["Amy", "Erik", "Pavel", "Matt", "Abdi", "Sadaq", "Miguel", "Jocelyn",
          "Adnan", "Luis", "Emily", "Drew", "Everett", "Ayden", "Walta", "Joshua",
          "Keiran", "Elias", "Faiaz", "Sergio", "Ivan", "Max", "Mohamed", "Awal",
          "Chelsey", "Johnny", "Pao", "Jaron", "Liban", "Taha", "Tenley", "Josh",
          "Xeng", "Gabriel", "Asli", "Hodan", "Jamila", "Amaal", "Ari", "Quinn",
          "Mohamud", "Derek", "Dori", "Guleid", "Yuva", "Rudwan", "Aisha", "Hamsa",
          "Ethan", "Talib", "Kwadwo", "Melissa", "Jake", "Chris", "Skyler", "Zach",
          "Liban", "Fatima", "Kodjo", "Corey", "Kebba", "Hannah", "Eric", "Jeffrey",
          "Esmeralda", "Leah", "Halah", "Krystal", "Rahma", "Romeo", "Ivie", "Andy",
          "Karen", "Elisha", "Khadro", "Adna", "Sundus", "Mohamed", "Ivan",
          "Timothy", "Vinny", "Mayali", "Betelehem", "Ermais", "Matt", "Collin",
          "Tommy", "Moua", "Long", "Miriam", "Keenan", "Sumayyah", "Nathan",
          "Matthew", "Angel", "Vivika", "Thor", "Brandon", "Andy", "Erica",
          "Bailey", "Ariana", "Linus", "Elliott", "Vincent", "Josh", "Sean",
          "Katelynn", "Saryn", "Bjorn", "Doua", "Amina", "Muna", "Xera", "Khaalid",
          "Mitchell", "Zakaria", "Leban", "Chris", "Khalid", "Ryan", "Alinase",
          "Brian", "Anna", "Zak", "Nikita", "Luke", "Ridwan", "Najma", "Brooklyn",
          "Ella", "Ceazar", "Mackenzie", "Stephanie", "Myles", "Christopher",
          "Kevin", "Jason", "Justin", "Odin", "Katie", "Jacob", "Lucy", "Vincent",
          "Najma", "Ly" ]
    
lasts = [ "Larson", "Steinmetz", "Atukorala","Pattanayak", "Haines", "Doree",
          "Belik", "Zobitz", "Sorensen", "Voyles", "Flint", "Chen", "Chafee",
          "Crowe", "Averbeck", "Klassin", "Brandl", "Mohamud", "Ahmed", "Xiong",
          "Memeti", "Lee", "Ng", "Nguyen", "Abdi", "Czech", "Vang", "OKeefe",
          "Atto", "Leal", "Hersi", "Mohammad", "Abukar", "Mckinnon", "Osman",
          "Yang", "Yusuf", "Edow", "Kempenich", "Adan", "Ali", "Hagen", "Torres",
          "Warns", "Beeby", "Gottimukala", "Alvarado","Boyer", "Sati", "Wadhawan",
          "Vo", "Ramales", "Owusu","Carrillo","Hopper","Lovelace","Ellis", "Bryan",
          "Fatty", "Abdullahi", "Abukar", "Adem", "Ahmed", "Bashige", "Belayneh",
          "Bigwood", "Clark", "Davidson", "Maxmud", "Mccarl", "Mensah", "Mohamed",
          "Moktar", "Ochoa Martinez", "Saw Tamalar", "Tran", "Xiong", "Yusuf" ]

def make_students(count,courses,fname='students.csv'):
    '''
    Create a csv file with "count" students.
    Each student will have a randomly generated name
    and randomly generated rankings for courses.
    The row is last,first,pref A, pref B, ... , pref E
    '''
    f = open(fname,'w')
    # create a list [1 2 3 4 5]
    rankings = [i+1 for i in range(len(courses))]
    for i in range(count):
        student = random.choice(lasts)+','+random.choice(firsts)+','
        # shuffle the rankings (at [0] is rank for A, [1] for B, ...)
        random.shuffle(rankings)
        # make the csv string with all info for student
        student += ','.join([str(r) for r in rankings]) + '\n'
        f.write(student)
    f.close()
    


