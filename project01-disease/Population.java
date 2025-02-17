/*
 * Population 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Models a collection of circles roaming about impacting other circles.
 * @author Amy Larson (with Erik Steinmetz)
 */
public class Population {

	/** Population consists of collection of Person(s) */
    private ArrayList<Person> persons = new ArrayList<>();
    
    /** Size of population of all status */
    private int populationSize = 500;

    /** Pauses simulation then people do not move */
    private boolean paused = false;
    
    /** Count of population in each status (in enum Status) */
    HashMap<Status,Integer> statusCounts = new HashMap<>();
    
    Random random = new Random();

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

		// populate each of the four areas equally
    	for (int area=0; area<4; area++) {
    		// make all the new persons
			for (int i=0; i<populationSize/4; i++) {
				// Boundaries define the area in which they can move
				Person person = new Person(Layout.BOUNDARIES[area],this);
				// add to the list (data structure)
				persons.add(person);
				// add to the Graphics panel
				panel.add(person);
				// adjust the count in the HashMap
				statusCounts.put(person.status(), 
					statusCounts.get(person.status()) + 1);
			}
		} // end for area
		
    } // end populate()

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
			// determine if person might change status of other
			// this can occur only if person is contagious and other is healthy
			if ( Status.HEALTHY_VACCINATED==person.status() || 
				 Status.HEALTHY_NOT_VACCINATED==person.status() ||
				 Status.HEALTHY_RECOVERED==person.status()) {
					continue;
			}
			for (Person other: persons) {
				// do not compare anyone to themselves
				if (person.equals(other)) {
					continue;
				}
				// if already infected, status cannot change
				if (Status.SYMPTOMATIC==other.status() ||
					Status.ASYMPTOMATIC==other.status()) {
					continue;
				}
				// calculate the distance to the center of each person.
				// if closer than 2*radius, they are overlapping
				// use Pythagoreans theorem
				int deltaX = person.getCenterX() - other.getCenterX();
				int deltaY = person.getCenterY() - other.getCenterY();
				double distance = Math.pow((deltaX*deltaX + deltaY*deltaY),0.5);
				if (distance < Person.SIZE()) {
					// they are overlapping, thus other is exposed to person
					person.exposed(other);
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
