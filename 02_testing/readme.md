### Testing with Shell Scripts

A shell script is a program that you can write to interact with your operating system and file system. It uses a programming language that is very specialized. It is an extremely powerful tool, but it has a steep learning curve. 

The script in this folder is similar to the one that is being used to grade the assignments. In this exercise, you will run the script and test if your assignment02 is set up correctly.

1. Move the file test02.sh into your csc321 folder (outside the repo).

2. If you are on a Windows machine, open your Git Bash (the shell that was installed when you installed git). It can run the shell scripts as they are written.

3. If you are on a Mac, open a terminal.

4. In the shell, navigate to the csc321 folder.

5. Execute the script with the follow command:

```
./test02.sh
```

You might have issues with permissions (it will tell you this when you try to run it). You can check by listing with the "-l" flag (that is the letter l, not the number 1.)

```
ls -l
```

If it is listed without any "x" in the rwx permissions (example below), permissions have to be changed. You can do that through Explorer/Finder or at the command line (raise your hand to get some help).

```
-rw-r--r-- 1 larso 197609 1137 Jan 30 20:43 test02.sh
```

When it runs, it should locate your repo, do a git pull to confirm it is up-to-date, run the code, and ouptput all team members (that were read from the file). If you do not see any output, something is wrong with the name of your folder. If you do not see all team members, something is wrong with your collaborators.txt file.

Please fix your folder and files, as appropriate, and add, commit, and push to the repo.

Please fix any similar mistakes in your assignment 03 and 04.
