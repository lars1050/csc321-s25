## Assignment 03: Merge Conflicts and .gitignore

Due: Tuesday, January 28 end-of-day with a 24-hour grace period.

Make sure to establish how you will communicate with each other outside of class (if you do not finish today).

In this assignment, you will work with a partner (or 2) to learn what happens and how to fix a merge conflict. Additionally, you will see how to remove files from your repo and how to ignore certain types of files in your repo.

You have been designated as:
- Team Member A : the repo owner
- Team Member B 
- optional Team Member C

Keep in mind that grading scripts are used to clone the repo, test your code, and record feedback. If you do not follow naming conventions or the directions precisely, the script will not be able to find your work. Read the directions carefully, please. This is the nature of programming -- it has to be exactly right.

Vocabulary Note: I often say "repo" which really has 2 locations/meanings. If I am referring to the web, this means the code repository that is stored on the web and has its own address (e.g. https://gitlab.com/augsburg/csc321_s25/assigment01/larsonam-repo-03). If I am referring to your machine (also called your local repo), this means the folder that contains the code that is stored in the repo (e.g. `/Users/amylarson/Git/csc321-s25/larsonam-repo-03`).

<hr>

### Get the Assignment from GITHUB

**All Team Members**

Everyone (in the shell) navigate to your class-repo folder and *pull* to get the new assignment. This is the completed version of assignment 02 with a few additions.

	```
	git pull
	```

**If you accidentally edited this repo and you are now getting errors when you try to pull -- no worries! Move the csc321-class-repo folder to your trash (use your explorer or finder) and re-clone it.**

It is recommended that you always view the directions for a lab on GitHub. It will be nicely formatted, and it will contain recent updates.

<hr>

### Establish the GITLAB Repo 

**Team Member A**

1. Go to the assignment03 group on gitlab: 
https://gitlab.com/augsburg/csc321_s25/assignment03

1. Create a new repo in the assignment03 Gitlab group: 

	a. It is suggested that the Description is "\<username\> Assignment 03 Git Merges". The description is what is displayed on the web, but it has no impact on the grading scripts. I would like to see your username somewhere in the descriptor as it makes searching easier.
	
	b. It is required that you name the repo ( _the slug_ ): "\<username\>-repo-03". For example, larsonam-repo-03. The grading script will be looking for this name exactly, so make sure it is right.
	
	- Please use your Augsburg username, not your gitlab username.
	- Everything is lowercase.
	- Notice it is dashes, not underscores.


1. Team Member A, in the shell navigate to the csc321 folder. Clone your new repo.

1. Navigate to inside the folder (e.g. `cd larsonam-repo-03`).

1. Copy the contents of the assignment from your Github class repo to your new gitlab repo.. 

	You can copy the contents via the command line or through your GUI file manager. It does not matter which you choose.

1. Add a plain text file collaborators.txt in the repo folder to include your team members. One person per line (e.g. larsonam,larson,amy), no spaces, and a linefeed after the last person. The username is the Augsburg username and it should be all lower case. The last and first name capitalization does not matter.

	Now, you should have 3 items in your repo:
	- larsonam-repo-03/collaborators.txt
	- larsonam-repo-03/03\_git\_merges
	- larsonam-repo-03/README.md

	The last item is the readme that gitlab created. Technically, there is also a hidden .git file in this directory.

1. Add, commit, and push.

	```
	git add *
	git commit -m "starting 03 git merges"
	git push
	```

### Team Gets Repo

**Team Member B and Team Member C**

In the shell, navigate to your csc321 folder and clone the repo of Team Member A.

Now everyone is starting from the same place.

<hr>

### Creating Merge Conflicts

One of the powerful features of _git_ is its ability to merge together the work from different sources. As long as each contributor is committing changes to different parts of the code, there is no problem. However, if the same file is edited at the same line but not the same value, it results in a _merge conflict_. Let's create a merge conflict.


**Team Member B:**

Make the following changes in your local repo. In the file `Account.java`, add a data structure to store all transactions for an account. You will use a basic array as your primary data structure.

Towards the top of the class definition, add

```
/** Recorded transactions for the account */
Transaction[] transactions = new Transaction[20];

/** Number of transactions recorded in the list */
int transactionCount = 0;
```

After the constructor, add

```
/**
* Record a completed transaction.
* @param type Transaction type to be recorded.
* @param amount total amount of the transaction (+ or -)
*/
public void record(double amount, Transaction.Type type) {
	transactions[transactionCount] = new Transaction(amount, type);
	transactionCount++;
}
```

Confirm it compiles. Add and commit to your local repo. Push to the server.

```
	git add *
	git commit -m "adding transactions array to account"
	git push
```

<hr>

**Team Member A (or Team Member C - you decide)**

__Do NOT pull before doing this work!__

Implement the same functionality in Account.java except use an ArrayList as your primary data structure.

At the top of the file, add

```
import java.util.ArrayList; 
```

Towards the top of the class definition, add

```
/** Recorded transactions for the account */
ArrayList<Transaction> transactions = new ArrayList<>();
```

After the constructor, add

```
/**
* Record a completed transaction.
* @param type Transaction type to be recorded.
* @param amount total amount of the transaction (+ or -)
*/
public void record(double amount, Transaction.Type type) {
	transactions.add(new Transaction(amount, type));
}
```

Confirm it compiles. Add and commit the changes to your local repo. Attempt to push to the server.

```
	git add *
	git commit -m "adding transactions ArrayList to account"
	git push
```

<hr>

You have now succesfully created a conflict (or at least I hope you did!). You should see a message like this:

```
 ! [rejected]        main -> main (fetch first)
error: failed to push some refs to ...
```

Now do a pull.

```
	git pull
```

You should see something like this ...

```
Auto-merging 03_git_merges/Account.java
CONFLICT (content): Merge conflict in 03_git_merges/Account.java
Automatic merge failed; fix conflicts and then commit the result.
```

#### Resolving Conflicts

**Team Member A (or whomever made the conflict)**

Look at `Account.java` in your editor and find the areas in which the conflict is highlighted. 

**EVERYONE LOOK TOGETHER.**

You will notice that your conflict is surrounded with text like this (for example):

```
<<<<<<< HEAD                                                                    
      int length = 2;                                                           
=======                                                                         
      int size = 2;                                                             
>>>>>>> 5436b807155c2b2adf171115b1fe74d94eb7f8aa 
```

In this conflict above, one person changed the variable name to _length_ and the other to _size_. The lines between _<<<<<<< HEAD_  and _======_ are the change in your local repo that you made, and the lines between _======_ and _>>>>> 543..._ are the ones pulled from the repo.

You want to accept the changes that are for using the ArrayList to store transactions.

If you are in an editor integrated with git, you might notice options related to accepting and viewing the changes. Choose to view the changes, then choose to **Accept Current Changes**. You will notice the extra text goes away.

If you are using an editor that is not integrated with git, you can still resolve this conflict by simply editing the file and removing the lines that were added to highlight the conflict.

Again, add, commit, and push.

```
	git add *
	git commit -m "resolving data structure conflict"
	git push
```

Everything should work this time!

**Team Member B and Team Member C**

Pull the repo. Notice that there are no conflicts and the repo now has the ArrayList implementation.

#### More Conflicts

Now you are going to again create a merge conflict. This time, play a different role so that everyone can practice resolving a conflict.

**Team Member A (or whomever needs the practice)**

In Account.java, add the following:

```
/**
* Display all transactions.
*/
public void displayTransactions() {
	for (int i=0; i<transactions.size(); i++) {
		System.out.println(transactions.get(i));
	}
}
```

Confirm it compiles. Add, commit, and push.

**Team Member C (or Team Member B if only 2 of you)**

In Account.java, add the following:

```
/**
* Display all transactions.
*/
public void displayTransactions() {
	for (Transaction t : transactions) {
		System.out.println(t);
	}
}
```

Confirm it compiles. Add and commit to your local repo. Attempt to push.

Resolve the conflict so that the final version of the code uses the enhanced for loop.

Then add, commit, and push.

**Team Member A (and Team Member B if there are 3 of you)**

Pull the changes.

<hr>

### Complete the Class 

ONE of you, make the following changes:

In Account in each of the methods to deposit, withdraw, charge a fee, and apply interest, call the record function as appropriate. For example,

- In deposit, `record(amount, Transaction.Type.DEPOSIT)`
- In withdrawal, `record(-amount, Transaction.Type.WITHDRAW)`
- In chargeFee, `record(-amount, Transaction.Type.FEE)`
- In applyInterest, 

```
    double earned = interestRate/12.0 * balance;
    balance += earned;
    record(earned, Transaction.Type.INTEREST);
```

Confirm it compiles and the output matches the provided sample output in expected\_output.txt. Add, commit, and push.

Everyone else, pull once the changes have been made. This concludes the aspect for coding the Accounts. The below requirements pertain to managing the repo.

<hr>
<hr>

### Configuring .gitignore

When sharing code, you typically only need to share the _source_ files (e.g. files that end in .java or .cpp or .py) -- not the executables (e.g. files that end in .class or .exe). And you should not share anything that can be generated locally from the shared files. For this reason, it does not make sense to push and pull any javadocs. 

Your system stores a lot of files as "hidden," meaning the name of the file starts with ".". For example, if you navigate to one of your repos in the shell and 

```
	ls -a
```

You will see a file .git. This will not appear in your GUI-based finder/explorer. 

If you want your repo to not track certain types of files, you can add a hidden file called ".gitignore" to the repo, and it will not record those changes. Typically, anything that can be generated locally should not be pushed to the repo, for example .class or source files, the .DS\_Store\_ directory on Macs, and any autogenerated javadocs. In the .gitignore file, you provide a pattern for file and directory names that should not be tracked.

You want only 1 person to make these changes. You choose.

Use your command line to create a .gitignore file to ignore all .class files.

```
	echo "*.class" > .gitignore 
```

"echo" is an OS command to print the string that follows. ">" is an OS command to direct the output to whatever is on the right side (in this case, the file .gitignore).

Do `ls -a` to make sure it is there. And to see the contents:

```
	cat .gitignore 
```

"cat" is an OS command to view the file that is provided as the argument to cat.

Remove the .class files from the repo. This is being extra cautious so that you do not accidentally delete something you do not want to. 

> You could use "rm" (remove) but BE CAREFUL with it! You will not be able to recover anything removed from your computer using this command, unless it was something saved to the repo. If you are nervous, you can always move a file/folder into the trash using your finder/explorer, from which it can be recovered (until you empty the trash).

First, create a "mytrash" directory/folder in your home directory then move the contents to that location.

```
	mkdir ~/mytrash
	mv *.class ~/mytrash 
```

If you like, you can use your finder/explorer to navigate to the mytrash folder and put everything in the system trash (or not). Push up the changes.

```
	git add *
	git commit -m "establishing gitignore"
	git push
```

If you look at gitlab, you will notice that the .class files are still there! This is because you have to explicitly remove it from the repo, not just your local directory/folder. Similar to `git add` to stage changes, `git rm` stages deletions from the repo: 

```
	git rm *.class
	git commit -m "removing executables"
	git push
```

Now these should be removed from your repo on gitlab.

Everybody else pull to incorporate the changes.

You should now be able to regenerate all the executables by compiling the code. Check `git status` and notice that these changes are no longer being tracked.

<hr>

### EXPLORING THE COMMITS

You do not need to submit anything for this assignment. I will be able to see the merge conflicts from each person and how they were merged. I will be able to see the removing of the executables. And the grading script will make sure the code is functional.

1. To see the history, go to gitlab and navigate to the repo. 

2. Choose history in the upper right. 

3. Explore some of those commits to see the changes. 

- Notice that code will be highlighted in green and red, for adding and removing code, respectively. You can choose to see the differences side-by-side too.

- Notice the -m messages appearing with each commit.

You have completed this assignment.
