### Practicing Team Development and Technical Communication

#### Due Monday, February 10, end-of-day with 24 hour grace period

In this assignment, you will be working in a team of 3 people to develop the Whack-a-Button game. This is similar to Whack-A-Mole, except in this version, the user has to "whack" a button when it displays a certain color.

The learning objectives are for students to be able to:
- Create and resolve issues on gitlab.
- Create user documentation with markdown.
- Create and compile automated documentation with javadocs.
- Use git branching to modify code.
- Effectively communicate with teammates to develop the application.

<hr>

The code base is fully functional and you can play the game to see how it works. A UML diagram has been provided to help you understand how all the pieces fit together. Take 5 minutes to look at the UML and the code base to orient to the organization of the code.

Below is the list of the "issues" to be resolved for this assignment. Most of you will be working in a team of 3. If you only have 2 people in your group, then you can ignore the last slider under Feature Enhancements and the Javadocs for the GameButton.

**Feature Enhancements**

## Each of the sliders should be modelled after the 05\_gui\_branches ColorSlider.java file (which extends a JPanel). Copy this class and customize it for this game.

The constructor should have a parameter for the object that will be communicated to about the change. For example, the ColorChangeSpeedSlider needs to communicate with the playClock. Each slider should have a label so that the user knows what the slider is changing.

- Create `class ColorChangeSpeedSlider` in a file ColorChangeSpeedSlider.java. This slider will be placed in the ControlPanel to control the timing of the color changes (from 300 to 1500 ms). This will control the GameClockControl.speedMS instance variable. 

- Add the ColorChangeSpeedSlider to the ControlPanel.

- Create `class PlayTimeSlider` in a file PlayTimeSlider.java. This slider will be placed in the ControlPanel to control the total time to play one round in seconds (from 10 to 60). This will control the GameClockControl.playTimeSeconds instance variable.

- Add the PlayTimeSlider to the ControlPanel.

- Create `class ProbabilitySlider` in a file ProbabilitySlider.java. This slider will be placed in the ControlPanel to control the probability that a cue will appear when the button color changes (from 0.2 to 1.0). This will control the GameViewingPanel.cueProbability instance variable.

- Add the ProbabilitySlider to the ControlPanel.


**Javadocs Documentation**

- Complete the javadocs for ControlPanel.java
- Complete the javadocs for GameViewingPanel.java
- Complete the javadocs for GameButton.java


**User Documentation**

- Create instructions on how to play the game in how-to-play.md

<hr>

### Getting Set-Up

Pull the github repo.

**Organize the gitlab repo.** Decide who will make the gitlab repo. Create it under the subgroup assignment06. Name the repo username-repo-06. Create the collaborators.txt file. Copy the github 06\_whacka folder into the repo. Create your .gitignore file.

**Ignore Javadocs.** You will be generating javadocs, but you do not want to push the results to the repo. The javadocs will be generated inside a docs folder, so your .gitignore might look like this ...

```
*.class

.DS_Store

docs
*.html
*.css
```

Everyone clone the repo.

**Create the issues.** On gitlab, create an issue for each of the feature enhancements and javadocs listed above. Make sure you are inside your repo when you create the issue. Assign team members to each issue using gitlab (right sidebar). Each member should have 1 feature enhancement and 1 file in which javadocs should be completed. 


### Making Changes

One of the key skills that you will be practicing with this assignment is working on branches. It is important that each of the items above are developed on a separate branch, then merged into main.

You should make the branch at the time you are going to start on it. It is a good practice to pull from the main branch first, then create the branch so that you are working with the most recent code base.

Use good naming practices for each branch. The name should indicate if it is related to a feature enhancement, refactoring, bug fix, maintenance, or documentation, for example. And use informative comments that highlight the key changes to the code since the last time you committed changes. 

When you are working on the slider class, do the following:

1. Make the issue.

2. Make ONE branch (you can even use gitlab's issue tool to do that for you). 

3. Create your new class, pushing to the repo (on your branch) as you go so as not to lose any work.

4. Once complete (and it compiles), make a final push to your branch.

5. Create a merge request with the main branch.

6. Communicate with your team that you are going to merge with main, then complete the merge. 

Now you are ready to incorporate the class into the ControlPanel.

1. On the main branch, PULL to ensure you have the most recent code base.

2. Make a new branch to add the slider to the ControlPanel.

3. Finish the functionality and confirm it is working!

4. Push to your branch.

5. Create a merge request.

6. Communicate with your team that you are going to merge with main, then complete the merge.

**Discuss the process.** Make a plan for each of the sliders and make sure that you are not working on the same file at the same time. Also, decide on the layout of the sliders within the ControlPanel. And don't forget to discuss the changes to the files to complete the Javadocs.

_The JFrame creates the graphics window and stays open until you close it. A JPanel is like a frame that can be set inside the JFrame. The location of the JPanel (i.e. the column and row values for setBounds) is relative to the JFrame. The spefied location of any object inside the JPanel is relative to that panel (not the graphics window). Keep in mind that location (0,0) is the top left corner of the frame (or panel)._


### Communication and Documentation

The other key skill for this assignment is communication in all its forms. You will be verbally communicating with your team, communicating your tasks through issues on gitlab, communicating technical information through Javadocs documentation, and communicating to users about how to play the game.

For *javadocs*, please complete the documentation for all instance variables and methods. Use @param and @return as appropriate (that means if a method has a parameter and/or the return type is not void). Javadocs should be compiled into a separate docs folder. To generate your javadocs and review the contents, follow this process for creating your javadocs for the first time:

1. Inside the 06 folder, create a folder `docs`.
2. `cd docs` to move into the new folder.
3. At the command prompt, `javadoc ../*.java` to autogenerate javadocs for all java files.

If you cannot compile your javadocs with the above command and you are on a Windows machine, you will probably need to add it to your path. See the main readme page in https://github.com/lars1050/csc321-s25 for details.

**IMPORTANT: make sure you have set your .gitignore to ignore the documentation generated through javadocs compilation.**


### User instructions

The last requirement is to write instructions for the user (as in the person playing the game, not the one using the code). It must be written using markdown (a text file with an `.md` extension). When you open it in gitlab, it will be formatted based on your markdown tags. Most code editors have a preview option for markdown so that you can see how it will turn out. There will be a brief introduction to markdown during Friday's class.

It is up to the team about how to divide the labor (if at all) on this last requirement.











