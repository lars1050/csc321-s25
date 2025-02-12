### The Observer Pattern

#### Due Monday, February 17

In this assignment, you will learn how to use the design pattern Observer to facilitate communication between the _Subject_ and the _Observer_. Each observer can choose to subscribe and unsubscribe to receive data (the feed) from the subject. 

There are 4 observer/subject pairs for an image, headline, stock market, and weather feed. Each of these inherits from either `interface Observer` or `interface Subject`. This design is easily extensible without making any modifications to the existing observers and subjects.

There are a lot of classes to keep track of! Your first task is to make a UML diagram to better understand how the pieces fit together. You can draw by hand or with a tool. It will be submitted via hard copy.

### Getting Started

One of you make a repo in subgroup assignment 8.

- Make a .gitignore.
- Make a collaborators.txt file
- Copy over the 08 files from the github class repo.

### Deliverables

1. Draw a UML Diagram the represents this application. You do not have to include and of the classes Weather\*.java or Images\*.java.
   
1. Add `public void subscribe(boolean checked)` to the `Observer` interface. This will be used by `FrontPage` to inform the Observer when the corresponding checkbox is checked (pass true) or unchecked (pass false). You will need to change all the Observers, because this is a change to the interface.

1. Complete WeatherSubscriber.java. Use StocksSubscriber.java as a guide on what to do.

1. Complete the action listener for the checkboxes in FrontPage. For now, do not subscribe to the feed in the constructor (for any of the Observers). Instead, only subscribe once the checkbox is checked. _We will work on unsubscribing after that, but do not worry about it for now._

You and your partner can determine how to divvy up the work and how to manage the repository. You do not have to use branches.

 





