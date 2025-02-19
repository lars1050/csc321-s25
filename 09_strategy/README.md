### 09 Strategy Pattern

Due: Sunday, February 23 end-of-day with a 24 hour grace period

In this assignment, you will redesign and reimplement the collection of robots to follow the Strategy Pattern. The setup is that the robot is part of a simulation in which the robot moves within a grid of a fixed size. Each type of robot has a mechanism for moving and a sensor for sensing obstacles ahead. There is the super class Robot (in the provided code, it is named RobotBad) and specialized subclasses with different combinations of locomotion and sensors. The type of locomotion is reflected in the method `move()`. The type of sensor is reflected in the method `sense()`. Subclasses override these methods when necessary. 

Currently, for locomotion, a robot can be omni-direction or wheeled. Omni-directional (sometimes referred to as holonomic) means it can turn in place. The wheeled robots use differential drive, which means that it turns by turning the wheels at different rates which makes the robot move in an arc. This movement is implemented in the code in this way:

```
public void move(int heading, int distance) {
    System.out.printf("(Wheels) Arcing to %d degrees for %d units.%n",heading, distance);

    // Differential drive means the robot will arc as it rotates and will not get quite as far
    double radians = heading * Math.PI/180.0;
    int x = getLocation().x + (int)((double)distance*7/8 * Math.cos(radians));
    int y = getLocation().y + (int)((double)distance*7/8 * Math.sin(radians));

    // Update to the new location
    setLocation(new Point(x,y));
    System.out.println("Moved to "+getLocation());
}
```

```
public void move(int heading, int distance) {
    System.out.printf("(Omni) Heading %d degrees for %d units.%n",heading, distance);

    // Calculate the new location based on the requested movement
    double radians = heading * Math.PI/180.0;
    location.x = location.x + (int)(distance * Math.cos(radians));
    location.y = location.y + (int)(distance * Math.sin(radians));
    System.out.println("Moved to "+location);
}
```

Currently, for sensing, a robot can have an infrared (IR) sensor, a camera, or a touch sensor. The IR and camera can detect obstacles in the distance ahead of the robot, but do not have the same range (cameras can detect obstacles that are much farther away). A touch sensor indicates that it is in contact (or not) with an obstacle, so it cannot "see" anything at a distance. Sensing is implemented like this in the code:

```
public void sense() {
    // Randomly generate a reading of an obstacle in the environment
    // It can be as close as 2 or beyond the max (thus not visible)
    int distance = rand.nextInt(50*2) + 3;
    if (distance > 50) {
      System.out.println("(IR) No obstacles ahead");
    } else {
      System.out.printf("(IR) Obstacle %d units ahead.%n",distance);
    }
}
```

```
public void sense() {
    // Randomly generate a reading of an obstacle in the environment
    // It can be as close as 1 or beyond the max (thus not visible)
    int distance = rand.nextInt(300*2) + 1;
    if (distance > 300) {
      System.out.println("(Camera) No obstacles ahead");
    } else {
      System.out.printf("(Camera) Obstacle %d units ahead.%n",distance);
    }
}
```

```
public void sense() {
    // Obstacle is known only when tsensor in physical contact with obstacle.
    // Randomly generate this signal (1 in 10 chance that there is an obstacle)
    int spinTheWheel = rand.nextInt(10);
    if (spinTheWheel == 1) {
      System.out.println("(Touch) Hitting obstacle right now. STOP!");
    } else {
      System.out.println("(Touch) Not in contact with obstacle.");
    }
}
```

<hr>

### Getting Started

One of you make the repo in assignment09. The repo name is username-repo-09. Move the folder over from github. Make the collaborators.txt and .gitignore.

WORK TOGETHER ON THIS ONE MACHINE FOR THE FIRST PART. This is called pair programming -- a common practice.

The person not typing is guiding the development.

#### Using Bad Design

1. Familiarize yourself with the code, then make a new RobotBad subclass that is omni-directional and uses a touch sensor (`class OmniTouchBad`). Be sure to instantiate an OmniTouchBad robot and test it in Main to ensure it is working -- the code is in main, but it is commented out.

To create a robot with different behavior, override the default behavior, as needed. The default RobotBad uses omni-directional movement and an IR sensor.

> Note: You might notice yourself copying and pasting code to create this new subclass. Copying-and-pasting code should always be a red flag indicating you might need a redesign.

2. Make a new RobotBad subclass that is wheeled and uses a camera (`class WheelCameraBad`). Test that it is working.

There are 2 types of movement and 3 types of sensing. If you had to make a new class for every possible combination, you would be making 6 distinct classes. What's worse is that if you wanted one of the movements or the sensors to be implemented differently, you would have to modify that in each of the classes it is used. 

The other person can now clone the repo.

#### Setting Up the Repo with Issues

On gitlab, prepare the issues. Please use the provided branch name for the issue name and include the description. On gitlab, assign each to Member A or Member B (you decide who is A and who is B). More details on the requirements for these issues is provided below.

1. add-movement-strategy. Create the strategies for movement including the super class and one for wheeled movement and one for omni-directional movement. Assign to Member A.

2. add-sensing-strategy. Create the strategies for sensing including the super class and one for IR, for camera, and one for touch sensing. Assign to Member B.

3. new-robot-class. Create a new Robot class that makes use of the movement and sensing strategies. The first 2 issues must be resolved before completing this. Assign to Member A.

4. new-omnitouch-subclass. Use the new Robot class and create a subclass that is omni-directional with a touch sensor. Assign to Member B.

5. new-wheelcamera-subclass. Use the new Robot class and create a subclass that has wheels and uses a camera. Assign to Member A.

6. new-wheeled-subclass. Create a subclass of Robot to make a wheeled robot with reconfigurable sensing. Assign to Member B.

7. new-reconfigurable-subclass. Create a subclass of Robot to make a robot with reconfigurable movement and sensing. Assign to Member A.

8. add-movement-strategy-fixed. Create a new strategy for movement that is fixed. Assign to Member B.

<hr>

### Implementing Good Design

_Please leave the provided code as is and create new classes. The one exception is Main, which you can edit as discussed in the requirements below._

For each of the issues below, develop the code in a branch with the specified title. When complete, merge with the main branch.

1. (issue #1) Create the collection of classes to implement the movement strategy. This should include a wheel and omni-directional. Use the names MoveBehavior, MoveWheeled, MoveOmni.

1. (issue #2) Create the collection of classes to implement the sensing strategy. This should include an IR, camera, and touch strategy. Use the names SenseBehavior, SenseIR, SenseCamera, and SenseTouch.

1. (issue #3) Once you have completed both issue#1 and issue#2, create a new Robot class to make use of the strategies. 

Here is some code from _Head First Design Patterns_ that implements the Duck example. Your robot classes will be essentially the same in structure.

```Java
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public abstract void display();

    public void fly() {
        flyBehavior.fly();
    }
    public void quack() {
        quackBehavior.quack();
    }
}

// One example of a behavior
public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I use my wings to fly!");
    }
}

// A Subclass
public class Mallard extends Duck {
    
    public Mallard() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
}
```

1. (issue #4 and issue #5) Again create subclasses with the same functionality as before, except use the Strategy Pattern. Call them OmniTouch and WheelCamera. The constructor should have a String parameter fot the name of the robot. As before, in main(), create robots of these types and test that they are working.

1. (issue #6) Create the Robot subclass Wheeled and initialize with the wheeled strategy for movement. Additionally, create a constructor with the sensing strategy as a parameter (i.e. `public Wheeled(String name, SenseBehavior strategy)`). In main, test that it is working.

1. (issue #7) Finally, create a `class Reconfigurable` and initialize with both a MoveBehavior and a SenseBehavior (i.e. `public Reconfigurable(String name, SenseBehaivor sensing, MoveBehavior moving)`);

1. (issue #7) Add setters for the sensing and moving strategies using the signature `setMoveBehavior(MoveBehavior moving)` and `setSenseBehavior(SenseBehavior sensing)`.

1. (issue #7) Instantiate a `Reconfigurable` that is wheeled and uses IR. Test it in Main to make sure it is all working.

1. (issue #7) Reconfigure the robot you just made by setting the movement to omni and the sensing to touch (i.e. use the setters). Test that it works.

1. (issue #8) Often industrial robots are fixed and cannot move (except for their arms). Make a new MoveStrategy called `MoveFixed`. In the move function, print something like "Fixed. No change in position." Make another reconfigurable robot that uses a camera and is fixed.

I think you get the point now!




