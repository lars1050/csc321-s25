import javax.swing.JFrame;

/**
* Primary display for the Game
* Components for the display are created within the JFrame.
* Some of these components are shared with the Game
* @author Amy Larson
*/
public class WhackaApplication extends JFrame {

	private final int W_FRAME = 600;
	private final int H_FRAME = 600;

	// splitting the frame into 2 panels for game viewing and game controls
	private final int GAME_ROW = 10;
	private final int CONTROL_ROW = 210;

	/** Controls the play clock and the timing of the color changes */
	private GameClockControl playClock;

	private ControlPanel controlPanel;
	private GameViewingPanel gameView;

	/**
	* Creates a Game application
	* and the components to display in the graphics window.
	*/
	public WhackaApplication() {

		// Initialize the graphics window
		super("Whack-a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(W_FRAME,H_FRAME);
		// You control the layout, not the graphics app
		getContentPane().setLayout(null);

		// Controls the pace of the game and when to change colors
		playClock = new GameClockControl();

		// Create the GUI panel that contains the game buttons. Place in window.
		gameView = new GameViewingPanel(GAME_ROW);
		getContentPane().add(gameView);

		// Create the GUI panel that contains game controls. Place in window.
		controlPanel = new ControlPanel(CONTROL_ROW, playClock, gameView);
		getContentPane().add(controlPanel);

		// Inform the playClock about the GUIs, so it can communicate info
		playClock.setGameViewingPanel(gameView);
		playClock.setControlPanel(controlPanel);

		// make it all appear
		setVisible(true);

		// we are in a thread, but we want to continuously monitor the game
		// we kill the game by closing the window
		while (true) {
			playClock.iteration();
		}
	} // end WhackaApplication()
} // end class WhackaApplication
