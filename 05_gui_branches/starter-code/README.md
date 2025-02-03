### GUI Branch Exercise

In this exercise, you will learn how branches can be used to aid the development process. It allows each person to work on a feature enhancement, bug fix, refactoring, etc. without impacting the code that is currently functional on the main branch. _main is what it is literally called. This is the default name whenever you create a new repo._ The general rule in team development is that the main branch is always functional.

This is an individual exercise. Assessment is based on your presence in class and engaging with the assignment. The skills you learn here will be necessary for the first group project.

Pro Git chapter on branching: https://git-scm.com/book/en/v2/Git-Branching-Branches-in-a-Nutshell

### Getting Set Up

1. Pull from Github. There will be 2 new folders:

	- starter-code
	- developing-code

2. Create a new repository on gitlab. Please create it under your personal space (not in an Augsburg group). 

3. Navigate in your shell to your csc321 folder and clone the repo on your local machine. `cd` into the repo folder.

4. Copy the code from the *starter-code* folder into your new repo. You should have Main.java, SimpleGUIApp.java, and the readme.md in the repo. Then,

```
git add *
git commit -m "starter code for branching exercise"
git push
```

5. Make a .gitignore file to ignore all `.class` files.

```
git add .gitignore
git commit -m "adding a gitignore"
git push
```

The files in the `developing-code` folder will be copied one file at a time, as directed below.

### Creating Branches 

A branch is a mechanism of version control applications that allows for developers to essentially make a copy of the current state of the code. The key is that you only see 1 version on your local machine at any given time. That way, code can be thoroughly tested before being incorporated into the main branch.

1. Create 2 branches for each "feature," which corresponds to GUI component that will be added to the SimpleGUIApp.

```
	git branch feature-color-controller
	git branch feature-font-controller 
```

2. View your results with `git log --oneline --decorate`.

3. Change your local _perspective_ to the one branch by checking it out. 

```
	git checkout feature-color-controller
```

4. Look around with an `ls` and a `git status`.

5. Copy the file CircleModel.java from the developing-code folder and confirm it compiles. _We are pretending that you spent time developing this class and it is now complete_.

6. Add, commit, and push the changes. Notice that we are adding this 1 file specifically, rather than using the `*` for add. Another rule to follow is to only work on 1 file at a time and regularly commit your changes, which makes it easier to revert back to a previous version if something goes wrong.

```
	git add CircleModel.java
	git commit -m "completed new class CircleModel"
	git push 
```

	At this point, you will likely get a message that you need to use a longer command for the push. This only occurs the first time you push a branch. 

7. Use the command displayed to complete the push.


### Understanding Branches

1. Look at your repo on gitlab. Notice the pulldown menu with main in the upper left. Pull that down and you should now see the feature-color-controller branch. Select that branch and look at the contents.

2. Open your finder/explorer and have the contents of the repo folder visible next to your shell window.

3. Switch branches.

```
	git checkout feature-font-controller
```

4. Look at your local version of the repo!

5. Copy the file TextModel.java from the developing-code folder. Again, we are pretending that you (as a different member of the team) have been working on this class and it is now finished.

6. Add, commit, and push. You will again be prompted to use the longer command for the push. Follow the directions.

```
	git add TextModel.java 
	git commit -m "completed new class TextModel"
	git push 
```
	
7. Review your branches on gitlab.

8. Change back to the main branch with `git checkout main`. Look at the contents of your local repo!

9. Change back to the feature branch for color with `git checkout feature-color-controller`. Look at the contents of your local repo! You did not have to checkout main before checking out the color-controller, but this way you can see how your local repo is changing between branches.

10. Copy the file ColorSlider.java from the 2nd folder.

11. Change back to the main branch `git checkout main`.

12. Change back again to feature-color-controller. Add, commit, and push to add the ColorSlider class.


### Finish the Color Controller Feature 

1. Copy the ColorController.java file into the repo. Add, commit, and push the changes.

2. Open the SimpleGUIApp in your editor and add the following code:

Above the constructor (~ line #13), copy and paste these lines of code:

```
	// Components for controlling the color of an object
	final private int CC_COLLUMN = 50;
	final private int CC_ROW = 10;
	private ColorController colorController;
```

Above the setVisible(true) towards the bottom of the file add this code:

```
		// Add the color controller panel
		colorController = new ColorController();
		colorController.setInFrame(CC_COLLUMN, CC_ROW);
		getContentPane().add(colorController);
```

3. Confirm it compiles and executes!

4. Add, commit, and push.

5. Close your editor.


### Hotfix on main

The term `hotfix` refers to a change that you make on the main branch to do a quick change to fix a significant bug that needs to be addressed right away. Let's make a small change and pretend that is the case.

1. Checkout the main branch with `git checkout main`. 

2. Modify the window text in SimpleGuiApp to whatever you want. This is the text passed to the super constructor.

3. Add, commit, and push the changes.

4. Explore what you have done ...

```
	git log
	git log --all
	git log --oneline --decorate --graph --all
```

5. Close your editor.


### Incorporate ColorController 

1. Merge your colorController branch into main. We will incorporate this branch using the command line. We will use a merge request through gitlab for the other.

```
	git merge feature-color-controller
```

It is likely that your editor will open at this time and ask you to comment on why you are merging. Add some text and save the file.

```
	git status 
	git push
```

_I forgot to document this part of the process. I think you just need a push after the merge (without an add and commit). git status will provide details on what to do next._


### Finish FontController feature

1. Checkout the branch with `git checkout feature-font-controller`

2. Copy FontController.java into the repo and add, commit, and push.

3. Modify the SimpleGUIApp.java file.

Above the constructor (~ line #13), copy and paste these lines of code:

```
	// Components for controlling the size of an emoji
	private FontController fontController;
	final private int FC_COLUMN = 50;
	final private int FC_ROW = 10;
```

Above the setVisible(true) towards the bottom of the file add this code:

```
		// Add the font size controller panel
		fontController = new FontController();
		fontController.setInFrame(FC_COLUMN, FC_ROW);
		getContentPane().add(fontController);
```

4. Confirm it compiles and executes. Add, commit, and push.

5. Close your editor.


### Incorporate All Changes

1. Go to gitlab and look at the branches. Then choose history in the upper right. Find the blue *Create Merge Request* button in the upper right and click.

2. Follow the directions to complete the request to merge the feature-font-controller branch. You do not need a code review to accept.

3. *UNCLICK* the delete branch button. It is typical to delete a branch once it is done so it isn't cluttering the repo, but we only have 3 branches so it is good to keep the history for this exercise.

4. Accept the merge request.

_Again, I forgot to take notes. I think you have to fix the code because the SimpleGUIApp was being edited by both files. Hopefully, what you need to do is clear. I believe the merge request completes the commit and push process._

5. Checkout the main branch and **pull** to confirm all the changes have been incorporated into your local repo. Look at the contents of the repo and confirm it is working.

6. Since both components were placed at row 10 in the frame, only 1 of them is showing. In the SimpleGUIApp, make this change from 10 to 400 for the placement of the font controller component:

```
	final private int FC_ROW = 400;
```

7. Confirm it compiles and executes showing both components. Add, commit, and push your changes.

Phew. You are done!


