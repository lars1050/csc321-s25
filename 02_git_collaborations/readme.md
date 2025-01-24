## Git 02: Working with Others on a Repo

The expectation is that you are in class working on this with a partner. If you are not in class, then you will likely not receive full credit. You may communicate with Dr. Larson regarding your absence and discuss options.

DUE: Sunday, January 26 at 11:59 pm with a 24 hour grace period.

If you have not already done so, one of you must complete 01\_git\_setup before moving on to this assignment.

### Download the Assignment Content

1. Open a terminal, power shell, or git bash window.
1. Navigate to the class-repo folder (using cd).
1. At the command prompt: `git pull`


### Create the Team 

Among your partner(s), one of you decide who is going to create the assignment in their repo. That one person ...

1. Navigate to your gitlab repo folder (with your username).
1. Copy the contents of 02\_git\_collaborations into this folder.
1. Add your partner(s) as collaborator(s) -- go to Manage-Members on Gitlab.

#### Teammate(s) Get the Repo

Be sure that you have access to your teammate's repo. 

1. At the command prompt, navigate to your csc321 folder. Clone your teammate's repo.
1. cd into their repo.
1. In whatever way makes sense to you, record collaborators in a new text file inside the 02\_git\_collaborations folder.
	- Create a file collaborators.txt
	- list each collaborator as username,lastname,firstname (1 per line, no spaces, and a linefeed after the last line please).
1. Add these changes to the repo.

```
git add *
git commit -m "adding file of collaborators"
git push
```

1. The OTHER person(s) navigate to inside the directory of the repo and pull to add the new assignment to your local repo.

```
git pull
```

And now everyone should have the starter code for the exercise that includes the classes Account, Checking, Savings, and Retirement and the Main for testing the code. The Account and Checking class have been completed for you. 

One of you complete the code for Savings and the other for Retirement, following the directions below.

#### Complete Savings

Look at the class Checking and how the constructor is implemented. Do the same for Savings, except:
- the initial account number for the Savings accounts is 200100
- the constructor signature is `public Savings(double rate)`. Set the interest rate (in Account) by calling the setter.
- create a default constructor (i.e. one with no parameters) that calls the constructor you just created, passing it a default interest rate of .005.

Override the withdrawal method, which is similar to that in Checking. Print "Insufficient funds for withdrawal" if the amount is greater than balance, otherwise withdraw that amount. No fee will be charged.

*The proper procedure is to compile and test your code prior to adding to the repo. However, we are not following the process of Test-Driven-Development with initial stubs for all anticipated method. The code cannot be compiled until the Retirement class is complete.*

Add to the repo.

```
git add *
git commit -m "completed class Savings"
git push
```

#### Complete Retirement

The OTHER person who is writing Retirement, *BEFORE YOU START ...*

```
git pull
```

The Retirement account constructor is similar to that of Savings, except the initial account number is 300100.

Also create a default constructor using a default interest rate of 0.03.

Override the withdrawal method. For any amount, print "Withdrawal not permitted on retirement accounts." No fee will be charged.

*COMPILE your code and run Main to check that it is working. Compare your results to those in exptected_output.txt. If you see error statements and you are not getting 100% correct, something is not meeting the requirements.*

Add to the repo.

```
git add *
git commit -m "completed class Retirement"
git push
```

Have the other(s) pull the repo so everyone's code is the same.

This concludes 02.

If you did not complete this during class, please communicate with your team and determine who is going to finish it. It is due Sunday end-of-day with a grace period until Monday end-of-day.


