# CSC321 Software Design and Development (Spring 2025)

This is the repository of code for CSC351 Software Design and Development. The majority of assignments
will be posted here. In this course, you
will be developing best coding practices such as using a repository and a style guide.

It is important that you ready your personal machine for the semester. You will need to install
- git (https://git-scm.com/)
- Code Editor: BBEdit, notepad++, Sublime, etc.

We will also be programming in Java and Python.

<hr>

## Command Line

Most people interact with the software on their computer through the icons: either applications on your desktop
or folders and files in your Finder. However, many computer scientists interact through a _terminal_ or
_command window_ or _shell_ (all terms you might hear to essentially mean the same thing). 
`terminal` is both a general term to mean a window in which you type commands and the official name of the application for Macs. This is also referred to as a `shell` and there are different languages that can be used to interpret
the commands that you type. `Bash shell` (https://en.wikipedia.org/wiki/Bash_(Unix_shell)) is common for Mac and Linux. 

> _Linux_ and/or _Unix_ (https://en.wikipedia.org/wiki/Linux, https://en.wikipedia.org/wiki/Unix) 
is another operating system commonly used for networking sytems, robotics, embedded systems 
and other systems that interact closely with hardware. It is often the preferred OS of programmers. Mac's come packaged with 
what is essentially a Linux shell, although Mac calls this environment `Darwin` -- something you occasionally see referenced.

Windows has typically referred to the terminal as the _command window_ and it uses slightly different commands (e.g. `dir` instead of `ls`). Now in Windows, 
there is the `power shell` that functions almost identically to a Linux shell. *It is recommended that you use the power shell.*

For this class, we will not be using any _IDE_ (integrated development environment), such as NetBeans. 
Programmers generally use a mix of IDEs and code editors. You should acquire both skills, and it is important that you
know how to use the command line for compilation and execution.

Here are the most useful and most used shell commands:

|    COMMAND        |     DESCRIPTION      |
| --------------|:-----------------------------------------------|
| `ls` | list all files in the current directory |
| `ls ..` | list all files in the parent directory
| `ls lab01` | list all files in the directory _lab01_ (or whatever directory you list that is within the current directory) |
| `ls -a` | list all files in the current directory, including those that start with a `.`, such as `.git`
| `ls -l` | list all files in the current directory with all information, such as time of creation, size,  permissions, etc. |
| `cd ..` | change the current directory to the parent directory |
| `cd lab01` | change the current directory to _lab01_ (or whatever directory you list) |
| `cd ../lab02` | change the current directory to _lab02_ which is inside the parent directory |
| `cd ~` | change the current directory to your _home_ directory |
| `pwd` | show the current path |
| `mv readme.md ..` | move the file _readme.md_ to the parent directory |
| `cp readme.md ../lab02/.` | copy the file _readme.md_ and place in the folder _lab02_, which is inside the parent directory |
| `rm mainOld.txt` | remove the file _mainOld.txt_ from the current directory |
| `..` | in general refers to the parent directory |
| `.` | in general refers to the current directory |
|    |   |

> Mac and Linux use `/` slashes to dilineate folders, but Windows uses `\`. Try the other slash if things are not working!

At any time while you are typing a command, you can hit `tab` and it will attempt to auto-complete your command.
For example, if you were trying to navigate to csc341F22, you can type `cd csc341` then `tab` and it will finish the
folder name for you.

Also, you can use your arrow keys to scroll through all previous commands that you typed. This comes in 
handy when you are compiling your Java code. It would look like this ...

```
javac *.java
java Main
```

... you make changes to a file and you `up-arrow` 2 times to compile, `return`. `up-arrow` 2 times and `return` to run.

<hr>

## Git

Git is a code repository application that works similarly to Google Drive, except it is designed specifically for coding.
One major difference between using Google drive and Git is that there is a copy of the files maintained both
locally on your machine and on a remote server in the cloud. You can use different services for storing in the cloud, 
such as GitHub, Gitlab, and BitBucket. For this class, we will use GitHub and Gitlab.

Git offers a lot of functionality for the purpose of developing software as part of a team. Primarily for this class, GitHub will be used to 
post assignments and Gitlab will be used for you to collaborate with your peers on projects. You will _pull_ down the repo each time an assignment is posted, which will grab only what has changed and put it into your git directory.

> "Pro Git", found here https://git-scm.com/book/en/v2, is a great and easy read to learn more about Git.

To get things started, you have to _clone_ the repo. So once you have git installed locally, navigate to the directory
in which you want to place the repository. When you clone the repo, it will create a directory/folder at the location where you issued the command. 
The folder will have the same name as the repo. 

> NOTE: Be thoughtful about your file management. It is not a good idea to put everything on your desktop. It is not
a good idea to have multiple copies of files all over your machine.

Please make a single folder for CSC321 and place all your work in this folder. This should NOT be in your downloads folder.

1. Open a terminal.
2. Navigate to the directory in which you want to place the repo.
3. Type `git clone https://github.com/lars1050/csc321-s25`
4. `ls` and you should see the new folder. You can also go to your Finder and see it there.

You can change the name of the folder without impacting the repository.

**You do not want to modify the repo, as this will cause problems when you try to pull the next assignment.**

Instead, create a new working directory, and copy the assignment into your working directory.

The next time an assignment is posted, navigate to the repo directory and "pull" the repo.

1. Open a terminal.
2. Navigate to the repo so that you are inside the `csc321-s25` folder.
3. Type `git pull`

Typically, one uses a repo to both pull from a repo and _push_ to a repo to contribute changes. For group
projects, this gives everyone easy access to all the code and incorporate other's work into their own.
As an individual programmer, it provides a way to work on code from different machines, and importantly,
creates a back-up and a log of all code changes (which can easily be undone or branched to a different version).
You cannot push to the course repo because you do not have permission (only the pulling is public).

<hr>

# Javadocs

If you are on a Mac, once you install Java you will be able to compile your javadoc comments into html pages.

If you are on a Windows machine, you have to add the Java bin directory to your path. You do this in the following way:

1. Go to your Explorer. Look inside your Program Files folder and find Java/java-jdk-xx/bin (where xx represents the version number of your install).
2. Copy the path of the bin folder (from C: to bin)
3. In Windows search, search for Environmental Variables and choose to edit.
4. In the pop-up window, choose advanced options.
5. In the bottom window (if you can, otherwise the top window), select PATH.
6. Edit the path by choosing NEW.
7. At the empty line at the bottom, paste the path to the bin folder
8. Save your changes and open a new command window.

You should now be able to type `javadoc --version` and the OS will recognize the command.





