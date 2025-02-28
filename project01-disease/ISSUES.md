For any code that you add to the application, please comment it and add the appropriate javadocs. Use good naming conventions.

<mark>If you are making a slider, feel free to change the access modifiers to `protected` for the member variables of the SliderPanel. Once you call the super constructor, the slider will be added to the panel. To modify the slider, refer to the methods for JSlider in the Java Oracle documentation. It may be that you want to create a new JSlider, in which case you will to `remove(slider)`, set slider = new JSlider, then `add(slider)` in the subclass you are creating.</mark>

<mark>FIX CODE ERROR in MessageBoard. Change `(Integer) days` to `(Integer) value` in switch statement.

### Tracking Status

The StatsPanel will report a variety of statistics about the population as the simulation advances. Information is shared between components through the MessageBoard. These issues are related to keeping the MessageBoard up-to-date.

Issue #1 and #2 can be developed on the branch **feature-share-stats**.

1. Population.java: In Population.java, create a method shareStats(). In that method, make a copy of the statusCounts and update that corresponding value in the MessageBoard by sending a message for STATS. You can make a clone as shown below. At the end of Population.populate(), call shareStats. 

```
	HashMap<Integer, String> cloned = (HashMap<Integer, String>) statusCounts.clone();
```



2. Population.java: Add a method Population.statusChanged(Status remove, Status add). Decrement the corresponding remove status (e.g. statusCount.put(remove) ...) and increment the corresponding add status. <del>At the end of Population.update(), call shareStats</del>. 

```
// "other" is being exposed to "person" who is currently sick
other.exposed(person)
```

<mark>The original code had person.exposed(other) but it should be as stated above!</mark>

Issue #3 can be developed (after 1 and 2 are resolved) on **feature-random-infection**.

3. Population.java: At the end of Population.populate(), randomly select 1 person from `persons` and change their status from healthy to SYMPTOMATIC. Call statusChanged to update the stats.

### Creating Statistics panel

The StatsPanel will report a variety of statistics about the population as the simulation advances. Information is shared between components through the MessageBoard. These issues are related to creating the graphics components in the StatsPanel.

Issues #5 and #6 can be developed on **feature-layout-stats**.

5. Layout.java: In Layout, add the x and y position of the labels for percent currently infected, percent recovered, percent not alive, as well as number of days. There should be both labels and values, for example "Currently Infected:" and "20%" would appear and be regularly updated in te StatsPanel.

6. StatsPanel.java: In the StatsPanel, create the JLabels for each of the 4 items.

Issues #7 and #8 can be developed on **feature-update-stats**.

7. StatsPanel.java: Create a method StatsPanel.update() that sets the values based on those in the MessageBoard. The relevant values are the HashMap stats and Integer days.

8. DiseaseGUI.java: In DiseaseGUI, insider the Timer, call the update method to refresh statistics on population.

### Transmission of Virus

The Slider can be created independent of the other issues. Issue 10 and 11 must be resolved in order.

As the population moves about, each person might encounter a person who is infected. The likelihood of that transmission can be controlled using one of the sliders. These issues are related to creating the slider and then using that value to determine if a person becomes infected.

Issue #9 can be developed on branch **feature-slider-transmission**.

9. ControlPanel.java: Create a SliderTransmission class that extends the SliderPanel. Set the Title and range (0 to 100) on the slider. The action listener should update the MessageBoard with a Message.TRANSMISSION. Add the SliderTransmission to panel location 0 in the ControlPanel.

Issue #10 can be developed on branch **feature-person-transmission**.

10. Person.java: Create a static variable transmissionProbability in Person. Initialize it to 10. Create a setter for this value. In the exposed() method in Person, use the transmissionProbability to determine if the person would get infected from the encounter. <del>If the _other_ person is contagious (ASYMPTOMATIC or SYMPTOMATIC), and _this_ person is HEALTHY (VACCINATED or NOT), then they have some probability of getting infected.</del> _Status was already checked in population, so it is not necessary to do that within the method._ Use randInt(100) < transmissionProbability to determine whether or not they would be infected. If infected, change the status to ASYMPTOMATIC and call population.statusChanged (assuming the issue to create statusChanged has been resolved).

Issue #11 (after 10 is resolved) can be be developed on branch **feature-transmission-update**

11. Population.java: At each update in Population, call the setter for transmissionProbability in Person and update it with the corresponding value on the MessageBoard. 


### Duration of Virus

The Slider can be created independent of the other issues. The other issues should be resolved in order.

Once a person becomes infected, they will stay infectious for the `duration` (in days). Each time the Timer executes in DiseaseGUI, another hour has passed. When 24 hours have passed, another day has passed. The day that a person is infected is stored in dayInfected, then each subsequent update will check if enough days have passed so that the person is no longer infected.

Issue #12 can be developed on branch **feature-slider-duration**

12. ControlPanel.java: Create a SliderDuration class that extends the SliderPanel. Set the Title and range (1 to 10) days on the slider. The action listener should update the MessageBoard with a Message.DURATION. Add the SliderDuration to panel location 1 in the ControlPanel.

Issues #13 and #14 can be developed on a branch **feature-days-duration**

13. Person.java: Create private static variables `days` and `duration` in Person and create a setter. Initialize to 0 and 1, respectively. Create a setter for these values. 

14. Population.java: In Population.populate(), call the setter for duration in Person, passing the value from the MessageBoard. In Population.update(), call the setter for days in Person, passing the value from the MessageBoard.


Issue #15 can be developed on the branch **feature-duration-status**

15. Person.java: Create a private variable `dayInfected` in Person. Initialize it to 0. In exposed(), if the person gets infected, set dayInfected = MessageBoard.days(). In move(), if the person is infected, check if the local static variable `days`-dayInfected is >= `duration`. If so, then the person's status should be changed to HEALTHY\_RECOVERED. Call population.statusChanged (assuming the issue to create this method has been resolved).


### Incubation Period 

The Slider can be created independent of the other issues. The other issues should be resolved in order.

The period of time from when a person becomes exposed to a virus and when they become symptomatic is the incubation period. After infection, once the incubation period has passed, the person's status will change from asymptomatic to symptomatic. Typically, people tend to infect more people when they are asymptomatic because they do not know they are sick. Maybe we will take that into account in a future enhancement.

Issue #16 can be developed on branch **feature-slider-incubation*

16. ControlPanel.java: Create a SliderIncubation class that extends the SliderPanel. Set the Title and range (1 to 7) days on the slider. The action listener should update the MessageBoard with a Message.INCUBATION. Add the SliderIncubation to panel location 2 in the ControlPanel.

Issue #17 can be developed on branch **feature-incubation-status**

17. Person.java: Create a static variable incubationPeriod in Person. Create a setter for this value. Assuming dayInfected has been created, in exposed(), if a person becomes infected, change their status to ASYMPTOMATIC. In move, if days-daysInfected >= incubationPeriod, then change the status from ASYMPTOMATIC to SYMPTOMATIC and call population.statusChanged.

Issue #18 (after 17 is resolved) can be developed on branch **feature-incubation-update**

18. In Population.populate(), call the setter for incubationPeriod in Person, passing the value from the MessageBoard.

### Prevention Measures

The Slider can be created independent of the other issues. The other issues should be resolved in order.

Prevention level refers to the measures taken to reduce transmission rates. This relates to vaccination, masking, distancing, and isolation. As prevention is increased, the probability of transmission decreases.

Issue #19 can be developed on branch **feature-slider-prevention**

19. ControlPanel.java: Create a SliderPrevention class that extends the SliderPanel. Set the Title and range (0 to 3), meaning weak to strong on the slider. The action listener should update the MessageBoard with a Message.PREVENTION. Add the SliderPrevention to panel location 3 in the ControlPanel.

Issue #20 can be developed on branch **feature-prevention-vaccinated**

20. Population.java: In Population.populate(), read the prevention value from the message board. If the value is 0, all persons should be initialized with status HEALTHY\_NOT\_VACCINATED. For the others, randomly set the status of each person to HEALTHY\_VACCINATED with a probability based on the level of prevention: (1) 30% probability, (2) 60% probability, (3) 80% probability. 

Issue #21 can be developed on branch **feature-prevention-update**

21. Person.java and Population.java: Create a static variable preventionLevel in Person and its getter. Initialize to 0. In Population.update(), call the setter for preventionLevel and pass the value from the messageBoard. 

Issue #22 can be developed on branch **feature-prevention-status**

22. Person.java: In Person.exposed(), change the probability of transmission based on the level of prevention. If 0, make no change. If level 1, reduce the transmission probability by 25% (i.e. transmissionProbability = transmissionProbability\*.25). If level 2, reduce by 50%. If level 3, reduce by 75%. That rate is used to determine if the person has been infected with this exposure.

### Population Movement

The Slider can be created independent of the other issues. The other issues should be resolved in order.

There are 2 ways that the level of movement impact the simulation. First, as the movement level increases, so does the percent of the population that moves at every time step. Second, as the movement level increases, the number of persons who cross over into another area increases. There are 4 distinct areas in which subpopulations move, which can be thought of as different cities or different countries.

Issue #23 can be developed on branch **feature-slider-movement**

23. ControlPanel.java: Create a SliderMovement class that extends the SliderPanel. Set the Title and range (1 to 4), meaning low to high on the slider. The action listener should update the MessageBoard with a Message.MOVEMENT. Add the SliderMovement to panel location 4 in the ControlPanel.

Issue #24 can be developed on branch **feature-movement-person**

24. In Population.populate(), after instantiating each person, set the deltaX and deltaY according to the MOVEMENT value in the MessageBoard. If it is 1, with 75% probability, set deltaX and deltaY to 0 (i.e. ~75% of the population will not move). If the movement level is 2, with 50% probability, set deltaX and deltaY to 0. If level is 3, with 25% probability, set deltaX and deltaY to 0. If level is 4, with 10% probability, set deltaX and deltaY to 0.

Issue #25 can be developed on branch **feature-movement-areas**

25. In Population.update() before doing anything else, based on the value of MOVEMENT in the MessageBoard, determine how many persons should be moved to another area (there are 4 distinct areas that a person might be moving in, which is determined by their BoundingBox). A person is moved by changing their border, which are defined in Layout.BOUNDARIES. If movement level is 1, randomly select 4 people and move them to a randomly selected area (using the Person.borders setter). If level is 2, move 8 random people. If level is 3, move 12 random people. And if level is 4, move 20 random people.

### Morbidity Rates

The morbidity rate determines if a person survives the illness. After being infected and at the end of the duration of the illness, a person might become NOT\_ALIVE with some probability, otherwise they become recovered. 

Issue #26 can be developed on branch **feature-slider-morbidity**

26. Create a SliderMorbidity class that extends the SliderPanel. Set the Title and range (0 to 100) of percent. The action listener should update the MessageBoard with a Message.MORBIDITY. Add the SliderMorbidity to panel location 5 in the ControlPanel.

Issue #27 can be developed on branch **feature-morbidity-status**

27. In Person, create a static variable morbidityRate and initialize to 0. In Population.update(), call the setter with the current value from the MessageBoard. In Person.move(), if a person is infected and has reached the end of their illness, change their status to  NOT\_ALIVE with the morbidityRate probability. If someone is not alive, they cannot move, so change deltaX and deltaY to 0. And if not NOT\_ALIVE, then status should be changed to HEALTHY\_RECOVERED. Call population.statusChanged to report the change.

Issue #28  can be developed on branch **fix-ignore-status-notalive**

28. In Population.checkForEncounters(), check for status NOT_ALIVE and ignore any NOT_ALIVE as either the "person" or the "other".

### Control Panel Play / Pause

Issue #29 can be developed on branch **feature-play-button**

29. Create a Play/Pause button in the control panel. The action listener communicates the status of the play button.




