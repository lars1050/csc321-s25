## Git Setup 01: Working with a Git Code Repository

We will be using both GitHub and Gitlab for managing code in this course. Code that is being distributed to the class will be posted on Github (like this code). Code that students work on and share with others will be stored on Gitlab.

### Checking git Installation

Open a terminal (mac) or power shell (Windows) OR gitbash shell (Windows). At the command prompt:

```
git --version
```

If the 'git' command is not recognized, git is not set-up. If you see a version, then you should be all set.

#### Install git

If you are a Mac user, git is already installed. HOWEVER, you have to activate xcode (i.e. mac's development environment) to activate git. The system usually prompts you to install xcode (it might have when you checked the version).  

If you are a Windows user, go here: https://git-scm.com/downloads/win

### Establish Accounts for git Cloud Services

When you create a user account, please use your Augsburg username. You do not need to create another account if you already have one under a different username.

1. Go here and sign up for an account: https://about.gitlab.com/
1. Go here and sign up for an account: https://github.com/about

### Github Repository for Assignment Distribution

To see what you will be cloning, go here: https://github.com/lars1050/csc321_s25

1. On your machine, navigate to a folder where you will be placing the github course repo. You will have several repos for this course. My recommendation is to make a folder for the course (not in your downloads folder, please!) to place all the repo folders. 

1. Clone the github repo with `git clone git@github.com:lars1050/csc321_s25.git`

1. RENAME the folder just created from `csc321_s25` to `csc321-class-repo`. This repository is a read only repo. You should not be editing anything in this repo.

```
mv csc321_s25 csc321-class-repo 
```

### Create Your Gitlab Account 

1. Navigate to this site: https://about.gitlab.com/
1. Choose sign-in from the upper left corner.
1. **Choose to sign-in with Google.**
1. **Choose your Augsburg Google account.**

_You can now accept an invitation to the group csc321\_s25/assignment01_


### Create Your Gitlab Course Repo

1. Navigate to this site: https://gitlab.com/augsburg/csc321_s25/assigment01
1. Create a new repo by selecting "Create New Project"
1. Create a new project by selecting "Create blank project"
	1. Project Name: /<username/> CSC321 Assignment01 Git Setup
	1. Project slug: /<username/>-01\_git\_setup (e.g. larsonam-01\_git\_setup)
		I.E.: your username DASH 01 UNDERSCORE git UNDERSCORE setup 
	1. "No deployment planned"
	1. Keep it "private"
	1. Make sure "initialize with a README" is checked

1. Clone the repo into you csc321 folder. Navigate to the folder in your terminal.

```
git clone https://gitlab.com/augsburg/csc321_s25/<YOUR USERNAME>
```

1. Copy the contents of 01\_git\_setup from the class repo to your repo.

```
cd <username>
cp ../csc321-class-repo/01_git_setup .
```

1. Add this content change to your repo. Commit the changes locally and push to the server.

```
git add *
git commit -m "adding content of git setup activity"
git push
```

Because this is your first push of the repo, you will have to define the origin. Follow the instructions in the terminal.

Go to your repo on the web (on gitlab) and view the changes.

	
### Share with Dr. Larson

1. At the site of the gitlab repo, find the Manage - Members settings. Add "larsonam" as a member of your repo.

### Create a collaborators.txt File

For each assignment after this one, you will be assigned a partner (or 2) and only 1 of you will be the creator of the repo. I will be asking you to always add a `collaborators.txt` file. For this assignment, create a new text file that has 2 lines:

```
larsonam, larson, amy
your username, last name, first name
```

Save the file. Then add, commit, and push.

```
git add *
git commit -m "adding collaborators file"
git push
```

Look at the gitlab site and confirm it has been added.
