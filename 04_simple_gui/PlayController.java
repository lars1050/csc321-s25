import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
Java Graphics components to demonstrate how to create a toggle button. It includes an active state variable, a button to change state between play and pause, and a label to display instructions.
*/
public class PlayController {

	/** The Java graphics frame/window in which the controls will be placed */
	JFrame frame;
	
	/** State of the system as either playing (true) or on pause (false) */
	boolean playActive = false;
	
	/** Instructions to user on how to change state */
	protected final JLabel playLabel = new JLabel("push to play");

	/** Button used to toggle between the states of play and pause */
	protected final JButton playButton = new JButton("play");
	
	
	// constants for the unicode for the play and pause icons
	private final String PAUSE = "\u23F8";
	private final String PLAY = "\u25BA";
	
	/**
	* Constructor.
	* @param frame in which play button controller components will display.
	*/
	public PlayController(JFrame frame) {
		this.frame = frame;
	}
	
	/**
	* Configures the graphics components and places in the frame.
	* @param column (location) within the graphics window for left edge.
	* @param row (location) within the graphics window for top edge.
	*/	
	public void setInFrame(int column, int row) {
  		// Set up play/pause button

		// Control the display of the button (so it is a solid filled color)
		playButton.setOpaque(true);
		playButton.setContentAreaFilled(true);
		playButton.setBorderPainted(false);
		playButton.setFocusPainted(false);
		playButton.setBackground(Color.GREEN);

		// set the location and size within which the object is displayed
		playButton.setBounds(column, row, 80, 80);
		playButton.setFont(new Font("Verdana", Font.PLAIN, 36));
		
		// default values -- start in pause mode
		playButton.setText(PLAY);
		playButton.setActionCommand("play");

		// define what to do when the button is clicked
		playButton.addActionListener(buttonListener);
		
		// add to the graphics frame/window
		frame.getContentPane().add(playButton);
		
		// set the location and size for the instructions
		playLabel.setFont(new Font("Verdana", Font.PLAIN, 42));
		playLabel.setBounds(column, row+110, 300, 100);
        frame.getContentPane().add(playLabel);	
	}
	
	// getter	
	public JButton playButton() {
		return playButton;
	}
	

	/** Control function for the Play button */
	// this both defines the class and declares an instance
	ActionListener buttonListener = new ActionListener() {

		/**
		* Defines the action associated with clicking the play button.
		* @param ae The event which occurred, identifying which button was pushed.
		*/
		@Override
		public void actionPerformed(ActionEvent ae) {

			//System.out.println("pushed the play button");
			if (playActive) {
				// pushed to pause. now waiting for play
				playButton.setText(PLAY);
				playLabel.setText("push to play");
				playActive = false;
			} else {				
				// pushed to play. now waiting for pause
			} // end if-else
		} // end actionPerformed
	}; // end buttonListener
} // end class
