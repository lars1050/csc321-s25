import java.util.HashMap;

public class MessageBoard {

	/** Simulation is paused (not yet started) */
	private static Boolean paused = true;
	
	/** Days passed in simulation */
	private static Integer days = 0;
	
	/** Likelihood of being infected when exposed (percent) */
	private static Integer transmissionProbability = 50;
	
	/** Days from exposure to recovery (or death) */
	private static Integer duration = 5;
	
	/** Days from exposure to showing symptoms */
	private static Integer incubationPeriod = 2;
	
	/** Level of preventions being taken to decrease transmission */
	private static Integer preventionLevel = 0;
	
	/** Level of movement (1-4) in the population */
	private static Integer movement = 1;
	
	/** Likelihood of dying from the virus */
	private static Integer morbidityRate;
	
	/** count of person with each Status */
	private static HashMap<Status,Integer> stats;

	/** Update the corresponding value
	* @param Message indicates which variable to change.
	* @param value Changing to that value 
	*/
	public static void update(Message msg, Object value) {
		switch(msg) {
			case PAUSED:
				paused = (Boolean) value;
				break;
			case DAYS:
				days = (Integer) value;
				break;
			case STATS:
				@SuppressWarnings("unchecked")
				HashMap<Status,Integer> temp = (HashMap<Status,Integer>) value;
				stats = temp;
				break;
			case TRANSMISSION:
				transmissionProbability = (Integer) value;
				break;
			case DURATION:
				duration = (Integer) value;
				break;
			case INCUBATION:
				incubationPeriod = (Integer) value;
				break;
			case PREVENTION:
				preventionLevel = (Integer) value;
				break;
			case MOVEMENT:
				movement = (Integer) movement;
				break;
			case MORBIDITY:
				morbidityRate = (Integer) value;
				break;
			default:
				System.out.println("Error: Message "+msg+" not recognized.");
		}
	}
	
	// Getters for all variables
	
	public static Boolean paused() {
		return paused;
	}
	public static Integer days() {
		return days;
	}
	public static HashMap<Status,Integer> stats() {
		return stats;
	}
	public static Integer transmissionProbability() {
		return transmissionProbability;
	}
	public static Integer duration() {
		return duration;
	}
	public static Integer incubationPeriod() {
		return incubationPeriod;
	}
	public static Integer preventionlevel() {
		return preventionLevel;
	}
	public static Integer movement() {
		return movement;
	}
	public static Integer morbidityRate() {
		return morbidityRate;
	}
}
