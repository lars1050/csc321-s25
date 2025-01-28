### Assignment 04 Basic GUI Control Components

#### Due Sunday, Feb 2 end-of-day with 24 hour grace period

In this assignment, you and your teammate(s) will modify a collection of components in a graphics window that use event-driven programming to "control" a variable value. These 2d graphics are created using Java's Swing framework for creating GUIs (Graphical User Interfaces). Event-driven means that functions are _evoked_ or _called_ when a user interacts with the GUI. The Graphics system is watching for user interactions and calls the appropriate method either using an interrupt or a thread that _polls_ (i.e. continuously looks for events). For example, a button has a _click_ event and a slider has a _change_ event. You define the methods or _actions_ that are associated with those events, which Java calls an ActionListener or ChangeListener.

There is some documentation from Oracle about how to use these components: https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html

### Getting Started

In your shell, navigate to the csc321 Github class repo and pull the repo to get this assignment.

Have one team member create a gitlab repo in the **assignment04** group. The name of the repo should be *\<username\>-repo-04*.

This same person should clone this gitlab repo into their local csc321 folder, then copy the assignment from the class repo. Add, commit, and push the changes up to the server.

Everyone else clone the repo in their local csc321 folder. 

Someone add the collaborators.txt file and list your username,lastname,firstname (1 line per teammate, no spaces, and a linefeed after the last line).

Someone add a .gitignore file that contains at least the following. You are welcome to add other lines to the .gitignore if needed.

```
	*.class
	.DS_Store
```

Execute the code (calling Main) to see the components.

_This exercise is also practice for working in a team. There should be commits from everyone on the team. Practice writing good commit comments and keeping your repos up-to-date._

### Feature Enhancements

> REMEMBER: It is very important that you pull the repo before you start any changes. This way you will start with any changes that your teammate(s) made, which will reduce the risk of creating a merge conflict. If things get really messed up, you can change the name of the repo folder and reclone the repo. And you can always revert back to a previous version that has been committed to your repo -- just ask if you need to do that.

Fix the below issues to add functionality and/or change the appearance in the graphics window. Decide who will work on which issues. You are both responsible for getting the project up and running. Then you are each responsible for completing your assigned issues. It is important that you are communicating regularly so that you don't create merge conflicts.

Create a file `issues.txt`. In that file list out who is assigned to which issue. Please provide the username and student name in the file. *IMPORTANTLY*, report on the status of each issue at the time the assignment is due -- it is either not started, in progress, or complete. The filename is important but the format of the information inside the file does not matter.

Once you complete the code, it is VERY IMPORATANT that you test it and confirm it is functional before you add, commit, and push it to the server.

The expectation is that when the assignment is due, the code in the repo can be compiled and executed without error.

- Issue #1: The slider needs more space. Change its width to 400 and change the tick marks to be every 10 units, rather than 5.

- Issue #2: The font of the label for the play button is too big. Change it to 24. Also, make it a different color.

- Issue #3: The textbox (in SimpleGUIApp) needs a label to display the acceptable range for the user input. Add the text label ABOVE the textbox that states "Enter a value between 0 and 100."

- Issue #4: Add functionality to the minus button in the ActionListener in ButtonsController. The plus button is complete and can be used as a model for minus.

- Issue #5: Complete the functionality for the play button in the ActionListener in PlayController. Within the else-block, mirror the statements in the if-block, except that it should display the PAUSE icon, change the instructions to the user, and change the playActive state.

- Issue #6: Add functionality to the submit button ActionListener in SimpleGUIApp. Ignore the entry if the value in the textbox is not in range. Otherwise, set the variable textboxValue and change the label to reflect the new value.

- Issue #7: Add functionality to the slider ChangeListener in SliderController. Set the variable sliderValue to the value on the slider and change the label to reflect this value.

### Refactoring

> Refactor means to modify the code but not the behavior. This might be needed to improve readability, organization, efficiency, security, etc.

The design for the text box is different from the other components. It demonstrates that you always have options about how to design your code. By  separating the GUI component code from the main GUI class, code changes for the component will not impact other parts of the code. Notice that this is an example of _composition_ in which the GUI is composed of other objects. 

Refactor the text box so that it follows the design of the other components. Do this in 2 steps:

- Issue #8: Create the class TextboxController in a new file. Do not change anything in any other file. Make sure it compiles. Add, commit, and push it up to the server.

- Issue #9: After #8 is complete, replace the textbox functionality in SimpleGUIApp and use the new class instead. Add, commit, and push it up to the server.
















