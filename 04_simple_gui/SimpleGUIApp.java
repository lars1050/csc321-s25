import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* Primary display for the Game
* Components for the display are created within the JFrame.
* Some of these components are shared with the Game
* @author Amy Larson
*/
public class SimpleGUIApp extends JFrame {

	// Define the size of the graphics window
	final private int W_WIDTH = 1000;
	final private int W_HEIGHT = 800;
	
	// Define the locations of the components within the frame
	final private int leftColumn = 50;
	final private int rightColumn = 600;
	final private int topRow = 100;
	final private int bottomRow = 400;
	
	SliderController slider;
	PlayController playController;
	ButtonsController buttons;
	
	/** text box for user-defined control */
	Integer textboxValue = 0;
	protected final JTextField textbox = new JTextField(textboxValue);
	protected final JButton textSubmitButton = new JButton("submit");
	protected final JLabel textboxLabel = new JLabel(textboxValue.toString());


	/**
	* Creates a Simulation GUI application.
	* Sets the components and their positions in the gui.
	*/
	public SimpleGUIApp() {

		// Initialize the graphics window
		super("Simple GUI Components");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(W_WIDTH,W_HEIGHT);
		// You control the layout, not the graphics app
		getContentPane().setLayout(null);
		
		slider = new SliderController(this);
		slider.setInFrame(leftColumn, topRow);
		
		buttons = new ButtonsController(this);
		buttons.setInFrame(rightColumn, topRow);
		
		// Set up play/pause button
  		
  		playController = new PlayController(this);
		playController.setInFrame(rightColumn, bottomRow);

		// __________________________________________________________
		// __________________________________________________________
		// An alternative design for a control component.
		// Rather than a new class, the components are part of the frame
		
		// Set up text box for user to enter value Lower Left
		textbox.setBounds(leftColumn,bottomRow,100,100);		
		textbox.setFont(new Font("Verdana", Font.PLAIN, 36));
		getContentPane().add(textbox);
		
		textSubmitButton.setBounds(leftColumn+150,bottomRow,100,100);
		textSubmitButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		// Control the display of the button (so it is a solid filled color)
		textSubmitButton.setOpaque(true);
		textSubmitButton.setContentAreaFilled(true);
		textSubmitButton.setBorderPainted(false);
		textSubmitButton.setFocusPainted(false);
		textSubmitButton.setBackground(new Color(187,133,136));		
		textSubmitButton.addActionListener(submitListener);
		getContentPane().add(textSubmitButton);
		
		textboxLabel.setFont(new Font("Verdana", Font.PLAIN, 36));
		textboxLabel.setBounds(leftColumn, bottomRow+110, 100, 100);
        getContentPane().add(textboxLabel);
		// __________________________________________________________
		// __________________________________________________________

		
		// make it all appear
		setVisible(true);
	}

	/** Control function for the text box */
	// this both defines the class and declares an instance
	ActionListener submitListener = new ActionListener() {

		/**
		* Performs the actions for each of the JButtons
		* @param ae The event which occurred, identifying which button was pushed.
		*/
		@Override
		public void actionPerformed(ActionEvent ae) {
			System.out.println("Clicked on submit.");

			if (textbox.getText().isEmpty()) {
				return;
			}
		}
	}; // end submitListener
} // end class SimulationGUI
