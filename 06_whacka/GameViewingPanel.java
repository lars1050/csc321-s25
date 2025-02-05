import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;

/*
This game presents 3 buttons that are randomly colored. At each update of the button colors, one of the buttons might be colored the cue color (with some probability). If the user selects the button with the cue color before it changes to the next color, they earn a point.
*/
public class GameViewingPanel extends JPanel {

	/** Width of the panel within the frame */
	private final int W_PANEL = 600;
	
	/** Height of the panel within the frame */
	private final int H_PANEL = 300;
	
	/** Row placement of the play clock within the panel */
	private final int CLOCK_ROW = 10;

	/** Row placement of all buttons relative to the top of the panel */
	private final int BUTTON_ROW = 80;
	
	/** Column placement of all buttons within the panel */
	private final int BUTTON_COLUMN = 100;
	
	/** Default size of all square buttons */
	private final int BUTTON_SIZE = 100; 
	
	private final JLabel labelForScore = new JLabel("Score");
	
	private final JLabel scoreValueDisplay = new JLabel("0");
	
	/** Default font for the display elements.*/
	private final Font fontForScore = new Font("Verdana", Font.PLAIN, 24);
	

	private GameButton[] buttons = new GameButton[3];
	
	private Integer score = 0;
	
	/** Probability of a cue appearing at a color change */
	private double cueProbability = 0.50; // 50%

	// No need to document this
	private Random random = new Random();

	public GameViewingPanel(Integer row) {

		setBounds(10,row,W_PANEL,H_PANEL);

		setLayout(null);
		
		// Place the score label and score value
		labelForScore.setBounds(BUTTON_COLUMN,CLOCK_ROW,100,30);
		labelForScore.setFont(fontForScore);
		this.add(labelForScore);
		scoreValueDisplay.setBounds(BUTTON_COLUMN+110, CLOCK_ROW, 80, 30);
		scoreValueDisplay.setFont(fontForScore);
		this.add(scoreValueDisplay);

		// Create game buttons and set their location.
		// ColorButton sets its own actionListener
		GameButton.setRow(BUTTON_ROW);
		GameButton.setButtonSize(BUTTON_SIZE);

		// Create the buttons in the game.
		Integer col = 10;
		for (int i=0; i<3; i++){
			// button 0 at starting column. calculating subsequent positions.
			col = BUTTON_COLUMN + BUTTON_SIZE*i + 10*i;
			buttons[i] = new GameButton(this,col);
			
			// add to viewing panel
			this.add(buttons[i]);
		};

		setVisible(true);

	} // end GamePanel()
	
	public void reportGotOne() {
		score++;
		scoreValueDisplay.setText(score.toString());
	}
	
	public void startGame() {
		score = 0;
		scoreValueDisplay.setText(score.toString());
	}

	public void gameOver() {
		for (int i=0; i<3; i++) {
			buttons[i].setColor(ButtonColors.NEUTRAL);
		}
	}

	public void changeColors() {

		Color[] ordering = ButtonColors.getRandomOrder();
		buttons[0].setColor(ordering[0]);
		buttons[1].setColor(ordering[1]);
		buttons[2].setColor(ordering[2]);

		// probability of displaying the cue
		// if the 10 possible random numbers, 5 (50%) are <5
		if (random.nextInt(100)<(cueProbability*100)) {	
			// choose 1 of the 3 buttons to be the cue color
			buttons[random.nextInt(3)].setAsCue();
		}
	} // end changeColors
	
	/** Change cue appearance probability */
	public void cueProbability(double probability) {
		if (probability > 0 && probability < 1.0) {
			cueProbability = probability;
		}
	}

} // end class GamePanel
