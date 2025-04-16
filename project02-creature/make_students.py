import random

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

def make_students_file(count,courses,fname='students.csv'):
    f = open(fname,'w')
    rankings = [i+1 for i in range(len(courses))]
    for i in range(count):
        student = random.choice(lasts)+','+random.choice(firsts)+','
        random.shuffle(rankings)
        student += ','.join([str(r) for r in rankings]) + '\n'
        f.write(student)
    f.close()
    


