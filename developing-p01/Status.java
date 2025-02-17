import java.awt.Color;

public enum Status {

	HEALTHY_VACCINATED(221,190,168),
	HEALTHY_NOT_VACCINATED(221,190,168),
	ASYMPTOMATIC(255,77,109), // and contagious
	SYMPTOMATIC(255,0,0), 
	NOT_ALIVE(0,0,0),
	HEALTHY_RECOVERED(183,228,199);
	
	final Color color;
	
	Status(int r, int g, int b) {
		color = new Color(r,g,b);
	}
}