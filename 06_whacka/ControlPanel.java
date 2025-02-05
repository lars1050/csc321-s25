import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlPanel extends JPanel {

	private final int W_PANEL = 600;
	private final int H_PANEL = 200;

	private final JButton go = new JButton("Go");

	private final JLabel labelForPlayClock = new JLabel("Time Remaining");
	protected final JLabel playClockDisplay = new JLabel("0");

	private GameClockControl playClock;
	
	private GameViewingPanel gameView;

	public ControlPanel(Integer row, GameClockControl clock, GameViewingPanel gameView) {

		this.playClock = clock;

		setBounds(10,row,W_PANEL,H_PANEL);

		setLayout(null);

		// place the play clock label and value (col,row,width,height)
		labelForPlayClock.setBounds( 20, 50, 150, 30);
		this.add(labelForPlayClock);
		playClockDisplay.setBounds(150, 50, 80, 30);
		this.add(playClockDisplay);

		// Control the display of the button (so it is a solid color)
		go.setOpaque(true);
		go.setContentAreaFilled(true);
		go.setBorderPainted(false);
		go.setFocusPainted(false);
		go.setBackground(Color.GREEN);

		// position (40,100) and size 120x30
		go.setBounds(40, 100, 120, 30);
		// actionlistener defined below
		go.addActionListener(goControl);
		// add to this GUI JPanel
		this.add(go);

		setVisible(true);

	} // end ControlPanel()

	public void gameOver() {
		go.setBackground(Color.GREEN);
	}

	public void updateTimeDisplay() {
		playClockDisplay.setText(playClock.secondsRemaining().toString());
	}

	/** Control function for the GO button */
	// this both defines the class and declares an instance
	ActionListener goControl = new ActionListener() {

		/**
		* Performs the actions for each of the JButtons
		* @param ae The event which occurred, identifying which button was pushed.
		*/
		@Override
		public void actionPerformed(ActionEvent ae) {
			// ActionListener assigned to only 1 button,
			// so actionEvent must be that the go button was clicked
			// ignore it if in the middle of a game
			if (!playClock.isPlayActive()) {
				//System.out.println("It is a go!");
				go.setBackground(Color.GRAY);
				go.setForeground(new Color(59,59,59));
				playClock.setPlayActive();
			}
		}
	}; // end goControl

} // end class ControlPanel
