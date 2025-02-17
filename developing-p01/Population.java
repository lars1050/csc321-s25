/*
 * Population 
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Models a collection of circles roaming about impacting other circles.
 * @author Amy Larson (with Erik Steinmetz)
 */
public class Population {

	/** Population consists of collection of Person(s) */
    private ArrayList<Person> persons = new ArrayList<>();
    
    /** Size of population of all status */
    private int populationSize = 20;

    /** Pauses simulation then people do not move */
    private boolean paused = true;
    
    /** Count of population in each status (in enum Status) */
    HashMap<Status,Integer> statusCounts = new HashMap<>();

    /** Default constructor. */
    public Population() {
    
    	/** Start with 0 persons with each health status */
		for (Status s : Status.values()) {
			System.out.println(s);
			statusCounts.put(s,0);
		}
    }
    
    /** Create the population
    * @param panel Place all in this JPanel
    */
    public void populate(PopulationPanel panel) {
    
    	for (int i=0; i<populationSize; i++) {
			Person person = new Person();
			// add to the data structure
			persons.add(person);
			// add to the Graphics panel
			panel.add(person);
			// adjust the count in the HashMap
			statusCounts.put(person.status(), 
				statusCounts.get(person.status()) + 1);
		}
    }

	/** Execute a time step so that everyone moves accordingly */
	public void update() {
	
		for (Person person : persons) {
			person.move();
		}
		// Determine if anyone has crossed paths with another
		// potentially changing their status from healthy to asymptomatic
		checkForEncounters();
	}
	
	/** Determine if any of the persons are crossing paths. */
	public void checkForEncounters() {
		for (Person person : persons) {
			for (Person other: persons) {
				// do not compare anyone to themselves
				if (person.equals(other)) {
					continue;
				}
				// calculate the distance to the center of each person.
				// if closer than 2*radius, they are overlapping
				// use Pythagoreans theorem
				int deltaX = person.getCenterX() - other.getCenterX();
				int deltaY = person.getCenterY() - other.getCenterY();
				double distance = Math.pow((deltaX*deltaX + deltaY*deltaY),0.5);
				if (distance < Person.SIZE()) {
					// they are overlapping
					// TODO: Determine if encounter is consequential
					//   this means 1 person is healthy and the other is not.
					person.overlapped();
					other.overlapped();
				}
			}
		}
	
	} // end checkforEncounters

    /** Pause the simulation - people no longer move. */
    public void pause() {
        paused = true;
    }

    /** Continue the simulation */
    public void play() {
        System.out.println("Playing now");
        paused = false;
    }


    public ArrayList<Person> getPeople() {
        return persons;
    }

}
