### Working with Threads

Threads are essentially functions that run "simultaneously" within a single process. The threads share the CPU, each taking turns to execute. They share memory (meaning they can refer to the same variables), unlike when you run two different applications simultaneously. 

In this assignment, you will practice creating and executing threads in Java. Additionally, you will learn about a mutex (mutual exclusion) that is needed when threads share memory to ensure that they do not interfere with each other.

#### Single Iteration Thread

First, let's create 2 different threads that each call a function 1 time.

1. Create the class called TaskOnceA.java in a file of that name: 

```Java
public void run() {

    System.out.println("Starting the execution of TaskA");
    for (long i = 0; i < 100000; i++) {
        if (i % 1000 == 0) {
            System.out.print("A ");
        }
    }
    System.out.println("\nEnding the execution of TaskA");
}
```


2. Create the class called TaskOnceB.java in a file of that name: 

```Java
public void run() {

    System.out.println("Starting the execution of TaskB");
    for (long i = 0; i < 200000; i++) {
        if (i % 2000 == 0) {
            System.out.print("B ");
        }
    }
    System.out.println("\nEnding the execution of TaskB");
}
```

2. Create a Main class file and run this code in main().

```
TaskOnceA taskA = new TaskOnceA();
TaskOnceB taskB = new TaskOnceB();

taskA.run();
taskB.run();
```

3. Have both TaskOnceA and TaskOnceB extend `Thread` (e.g. `public class TaskOnceA extends Thread`).

    Run the code (but there will be no difference in behavior).

    Change the call from run() to start().

```Java
taskA.start();
taskB.start();
```

 > What do you see now? **Take a moment to absorb what you are seeing and to understand it.**

 4. Change the calls to this:

```Java
taskA.start();
try {
    taskA.join();
} catch (Exception e) {

}
taskB.start();
```

> And now what do you see? **Take a moment to absorb what you are seeing and to understand it.**

6. Play around with the code a bit to understand how it is working. Change the timing (i.e. number of iterations). Add a TaskOnceC if you like. Take out the .join and see what happens.

<hr>
<hr>

#### Infinite Threads with Runnable

Threads are often most useful when they are running indefinitely. You have already experience threads withe the Java graphics, in which the window stays open and active until you close it. To make a thread run "infinitely", you often create an infinite while loop that is disrupted through some other mechanism.

**If you need to kill a process, type control-c in the shell in which you are running your application.**

> You can comment all of the above out to have a clean output on the shell.

1. Incorporate the `DisplayTask.java` file.

Notice that the class extends JComponent, which prevents the extension of Thread. Instead, it `implements Runnable`.

2. Add this to the main method and run it.

```Java
DisplayTask displayTaskA = new DisplayTask(400,400,"Display A",1000);
DisplayTask displayTaskB = new DisplayTask(400,400,"Display B",2000);

Thread displayA = new Thread(displayTaskA);
Thread displayB = new Thread(displayTaskB);

displayA.start();
displayB.start();
```

> Notice how the thread is created. A task object is instantiated, as before when extending Thread, but then a new Thread is made and the _Runnable_ object is passed to the thread. 

    Take a moment to look at the displays and think about what is going on.

3. Create a way to interact with one of the displays. In the main method after everything is started, add this ...

```Java
Scanner scanner = new Scanner(System.in);
String userInput;
while (true) {
    userInput = scanner.nextLine();
    displayTaskA.displayText(userInput);
}
```

    Type in the shell and see the results in the display window. Sometimes the first one doesn't work (not sure why).

4. It is not great to catch a generic Exception. One should generally catch the specific exception that is thrown. Google which exception is thrown by Thread.sleep and change the catch to catch that one.

    Run the code and make sure it works.

<hr>
<hr>

#### Classic Producer Consumer Synchronization

The producer-consumer scenario consists of 2 threads, each accessing a buffer of information. The producer is placing data into the buffer, and the consumer is reading from the buffer. If the consumer is interrupted half-way through reading the buffer and the consumer writes new data, the consumer gets half of one message and half of the other.

In this example, there are 2 threads -- one writing to a mailbox and one reading from the mailbox. This also demonstrates a common way for threads to pass messages.

> You can comment out all of the above to concentrate just on this part of the exercise.

1. Incorporate the file `Messenger.java`.

> Take a minute to look at the class. Look at the read and write. This is a shared mailbox that one task can write to and another can read from.

2. In a new file, create a new class TaskReader that extends Thread. Like this:

```Java
public class TaskReader extends Thread {
	
	// shared memory with the TaskWriter
    Messenger mailbox;

	// keep track of how many iterations have been executed
    long counter = 0;

    public TaskReader(Messenger box) {
        mailbox = box;
    }

    public void run() {
    	// forever execute (use ctrl-c to exit)
        while(true) {
            System.out.println("Reading iteration "+counter+" ");
            String[] msg = new String[50];
            mailbox.read(msg); 
            int i = 0;
            while (i<msg.length && msg[i] != null) {
	            System.out.print(msg[i]+" ");
	            i++;
            }
            System.out.println();
            counter++;
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            } 
        }
    }
}
```

3. In a new file, create the new class TaskWriter like this:

```Java
public class TaskWriter extends Thread {

    long counter = 0;

    Messenger mailbox;

    public TaskWriter(Messenger box) {
        mailbox = box;
    }

    public void run() {
        while (true) {
            
            System.out.println("Writing iteration "+counter+" ");
            mailbox.write();
            ++counter;
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}
```

4. In main, instantiate a Messenger, and a Reader and Writer task. Call `.start()` on each.

```Java
Messenger mailbox = new Messenger();
	
TaskReader readTask = new TaskReader(mailbox);
TaskWriter writeTask = new TaskWriter(mailbox);
		
writeTask.start();
readTask.start();
```

> Look closely at the read messages. What is wrong with that? **Try to understand what is happening and why.**

<hr>

You need a mutex (mutual exclusion)!

In the Messenger file:

1. `import java.util.concurrent.locks.*;`
1. `private ReentrantLock mutex = new ReentrantLock();`
1. In the read method, add a `try-finally` block around the method body. 
1. The first liine of the try should be `mutex.lock();`, followed by the entire body of the method. 
1. In the finally, add the 1 line `mutex.unlock();`.
1. Repeat for the write.

> Run the code and see the difference! Look at the ordering of the output and **try to get a sense of what is happening and why.**

All done!



