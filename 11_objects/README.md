## Assignment 11 Objects, Arrays, and Arguments

In this series of activities, you will trace code to better understand objects, and you will represent information using different structures.

### Memory Exercise

Start by writing your answers on **a piece of paper**. Trace the code in MemoryExercise.java without running it. As you trace the code, use circles and pointers as demonstrated in class. Cross out variables that are no longer in scope.

**Try to label your drawing to mark the various time points in the code.**

At each line with the comment "Write VALUE of ...", write the expected value of each structure. 

Once you have completed the expected value for EVERY line, run the code in a Java visualizer (https://cscircles.cemc.uwaterloo.ca/java_visualize/) to check it against your trace.

<hr>

### Array Demonstration 

In this exercise, modify the code. Use the provided data structures to represent a collection of pets in different ways.

1. Add "jojo" the snake to each of these 3 structures:
```
		String[] petNamesArray = new String[5];
		PetNamesList petNamesList = new PetNamesList();
		PetList pets = new PetList();
```

Run the code to see the contents of each structure.

2. Create a new PetNamesList object using the non-default constructor. Create a data structure to pass to the PetNamesList constructor. In the structure being passed as an argument, put jojo, fluffy, and lemon.

3. Create another new PetNamesList object using the non-default constructor. Pass it the same data structure you used as an argument in #2.

**Print the contents of the new PetNamesList and the argument. Run the code to see the results.**
		
4. Create a new PetList object using the non-default constructor. Create a data structure to pass to the PetList constructor. In the structure being passed as an argument, put jojo (snake), fluffy (turtle), lemon (fish).

**Print the contents of the new PetList object and the argument. Runt the code to see the results.**
		
5. Using the SETTERS, add a 4th pet bubbles (bird) to the instances of PetNamesList and PetList from 2 and 4 (not #3).

**Print the 2 PetNamesLists and the PetList from #2, #3, and #4. Also print the 2 arguments passed to these constructors.**
		
6. Add pet spot (dog) to the data structure that was passed as an argument to the constructor from #2 above.

**Print the 2 PetNamesLists objects from #2 and #3 above.**

7. 	Fix the code so that the structure passed into PetNamesList is distinct from the object being referenced with the member variable _pets_.

Run the code and see how things have changed.





