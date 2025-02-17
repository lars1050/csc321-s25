public enum Message {
	PAUSED,			// simulation is paused or started
	DAYS,			// days passed in simulation
	TRANSMISSION,	// probability of transmission when exposed to virus
	DURATION,		// duration of illness (in days)
	INCUBATION,		// time from exposure to symptoms (in days)
	PREVENTION,		// weak to strong measures to prevent transmission
	MOVEMENT,		// low to high movement of the population
	MORBIDITY,		// probability of dying from the virus
	STATS			// count of persons for each Status
}