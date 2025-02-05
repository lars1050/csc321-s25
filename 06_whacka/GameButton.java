import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;

public class GameButton extends JButton {

	/** default size of each button */
	private static Integer buttonSize = 100;

	/** Row placement for all all buttons - corresponds to top of button */
	private static Integer row = 100;	// y-coordinate
	
	/** Current color of the button */
	Color color = ButtonColors.NEUTRAL;

	/** The game view (that tracks the score) */
	GameViewingPanel gameView = null;

	//ImageIcon originalIcon = new ImageIcon("mole.png");
	//ImageIcon resizedIcon;

	/**
	* Constructor
	* @param frame graphics window in which it will be displayed.
	* @param game in which the button will be used
	* @param order display order of the button (left-most is ordered 0)
	* @param column position within the frame (left-most edge)
	*/
	public GameButton(GameViewingPanel view, Integer column ) {

		super();
		this.gameView = view;

		// Initialize display features so button appears with solid color
		setOpaque(true);
		setContentAreaFilled(true);
		setBorderPainted(false);
		setFocusPainted(false);

		// place the button and define the function called when clicked
		setBounds(column, row, buttonSize, buttonSize);
		addActionListener(buttonAction);
		setColor(ButtonColors.NEUTRAL);
	}

	/**
	* Set color for both text (foreground) and background
	* @param c color of text and button
	*/
	public void setColor(Color c) {
		//System.out.println("In the button to change");
		setIcon(null);
		color = c;
		setBackground(c);
		setForeground(c);
	}

	/**
	* Set color of button as cue (which player is trying to whack)
	*/
	public void setAsCue() {
		setColor(ButtonColors.CUE_COLOR);
	}

	/**
	* Function that is called when this button is clicked.
	* If the button is colored with the cueColor, the player scores and
	* the game is notified.
	*/
	// This is both a class definition and instantiation
	ActionListener buttonAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent ae) {
			// This actionListener is exclusively for this button,
			// so the only actionEvent would be that this button is clicked.
			
			if (color == ButtonColors.NEUTRAL) {
				// game is not active and click should be ignored
				return;
			}
			
			if (color == ButtonColors.CUE_COLOR) {
				// indicate a successful whack
				setColor(ButtonColors.SUCCESS);
				gameView.reportGotOne();
			} else {
				// indicates not successful in whacking
				setColor(ButtonColors.FAIL);
			}
		}
	};

	// ________________ SETTERS and GETTERS ____________________

	/** Setter for the row placement of all buttons. */
	public static void setRow(Integer row) {
		row = row;
	}

	/** Setter for the size (square) of all buttons. */
	public static void setButtonSize(Integer size) {
		buttonSize = size;
	}
}
