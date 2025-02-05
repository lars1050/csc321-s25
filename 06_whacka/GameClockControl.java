import java.awt.Color;

import java.time.temporal.*;
import java.time.LocalTime;

import java.util.Random;


/**
Controls the timing of the whack-a-button game.

This game presents 3 buttons that are randomly colored. At each update of the button colors, one of the buttons might be colored the cue color (with some probability). If the user selects the button with the cue color before it changes to the next color, they earn a point.

The player has a fixed time on the play clock to play.
 */
public class GameClockControl {

	/** Rate at which buttons change color */
	private Integer speedMS = 700;

	/** When actively playing, time left on the play clock */
	private Integer secondsRemaining = 0;

	/** Default time on the play clock */
	private Integer playTimeSeconds = 15;

	/** When active, used to time the change of colors */
	private LocalTime timerColorChange = LocalTime.now();

	/** When active, used to mark point in for time next color update */
	private int nextColorUpdateMS = 0;

	/** When active, used to determine when to update the play clock */
	private LocalTime timerUpdateTime = LocalTime.now();

	/** When active, used to mark point in time for next play clock update */
	private int nextTimerUpdateMS = 1000;

	private Random random = new Random();

	private GameViewingPanel gameViewingPanel;
	private ControlPanel controlPanel;

	private volatile boolean isPlayActive = false;

	/**
	* Constructor for establishing new game
	*/
	public GameClockControl() {
	}

	/**
	* Decrements the play clock and updates its display
	* @param seconds the number of seconds to decrement the clock
	*/
	public void tickDownSeconds(int seconds) {
		secondsRemaining -= seconds;
		if (secondsRemaining < 0) {
			secondsRemaining = 0;
			gameOver();
		}
		controlPanel.updateTimeDisplay();
	}

	/**
	* Initializes the start of a new game.
	*/
	public void resetGame() {
		// System.out.println("Getting Ready to play");

		// establish color change clock and set timer for next color change

		timerColorChange = LocalTime.now();
		nextColorUpdateMS = 0;	// at first play iteration

		// establish play clock and set timer for next update of play clock
		timerUpdateTime = LocalTime.now();
		secondsRemaining = playTimeSeconds;
		nextTimerUpdateMS = 1000;	// play clock updated every second

		// reset the display of the timer
		controlPanel.updateTimeDisplay();
		
		gameViewingPanel.startGame();
	}

	public void gameOver() {

		isPlayActive = false;
		gameViewingPanel.gameOver();
		controlPanel.gameOver();
	}

	/**
	* When game is active, repeatedly called to update clock and score.
	*/
	public void iteration() {

		if (isPlayActive) {

			// check if it is time to update the timer
			if (timerUpdateTime.until(LocalTime.now(), ChronoUnit.MILLIS) >= nextTimerUpdateMS) {
				// System.out.println("Trying to update clock");
				// decrement the play clock, set up for next update
				tickDownSeconds(1);
				nextTimerUpdateMS += 1000;
			}

			// check if it is time to change color of buttons
			if (timerColorChange.until(LocalTime.now(), ChronoUnit.MILLIS) >= nextColorUpdateMS) {
				gameViewingPanel.changeColors();

				// establish time for next color change
				nextColorUpdateMS += speedMS;
			} // end if changing color
		} // if playActive
	} // end play()

	// ______________    SETTERS and GETTERS ________________

	public void setPlayActive() {
		resetGame();
		isPlayActive = true;
	}

	public void setPlayInactive() {
		isPlayActive = false;
	}

	public boolean isPlayActive() {
		return isPlayActive;
	}

	public void setGameViewingPanel(GameViewingPanel viewPanel) {
			this.gameViewingPanel = viewPanel;
	}

	public void setControlPanel(ControlPanel controlPanel) {
			this.controlPanel = controlPanel;
	}

	public Integer speedMS() {
		return speedMS;
	}
	
	public void speedMS(Integer ms) {
		speedMS = ms;
	}
	
	public Integer playTimeSeconds() {
		return playTimeSeconds;
	}
	
	public void playTimeSeconds(Integer seconds) {
		playTimeSeconds = seconds;
	}

	public Integer secondsRemaining() {
		return secondsRemaining;
	}
}
