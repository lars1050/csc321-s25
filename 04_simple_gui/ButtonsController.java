import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
Java Graphics components to demonstrate how buttons can be used to modify a variable. It includes an integer value, 2 buttons (+/-) to change the value, and a label to display the value.
*/
public class ButtonsController {

	/** The Java graphics frame/window in which the controls will be placed */
	JFrame frame;
	
	/** The value being "controlled" */
	Integer buttonValue = 50;
	
	/** +/- buttons for control */
	protected final JLabel buttonLabel = new JLabel(buttonValue.toString());
	protected final JButton plus = new JButton("+");
	protected final JButton minus = new JButton("-");
	
	/**
	* Constructor.
	* @param frame in which buttons controller components will display.
	*/
	public ButtonsController(JFrame frame) {
		this.frame = frame;
	}
	
	/**
	* Configures the graphics components and places in the frame.
	* @param column (location) within the graphics window for left edge.
	* @param row (location) within the graphics window for top edge.
	*/
	public void setInFrame(int column, int row) {
	
		// Control the display of the button (so it is a solid color)
		minus.setOpaque(true);
		minus.setContentAreaFilled(true);
		minus.setBorderPainted(false);
		minus.setFocusPainted(false);
		minus.setBackground(Color.YELLOW);

		// set location and size within which the object is displayed
		minus.setBounds(column, row, 80, 80);
		minus.setFont(new Font("Verdana", Font.PLAIN, 36));
		// buttonListener defines what to do if the button is clicked
		minus.addActionListener(buttonListener);
		frame.getContentPane().add(minus);
		
		// Control the display of the button (so it is a solid color)
		plus.setOpaque(true);
		plus.setContentAreaFilled(true);
		plus.setBorderPainted(false);
		plus.setFocusPainted(false);
		plus.setBackground(Color.YELLOW);

		// set location and size within which the object is displayed
		plus.setBounds(column+100, row, 80, 80);
		plus.setFont(new Font("Verdana", Font.PLAIN, 36));
		// buttonlistener defined below
		plus.addActionListener(buttonListener);
		frame.getContentPane().add(plus);
		
		// set size and placement of text
		buttonLabel.setFont(new Font("Verdana", Font.PLAIN, 36));
		buttonLabel.setBounds(column, row+100, 100, 100);
        frame.getContentPane().add(buttonLabel);
        	
	} // end setInFrame
	
	// ____ GETTERS ____
	public JButton plus() {
		return plus;
	}
	
	public JButton minus() {
		return minus;
	}
	
	/** Defines the actions associated with clicking either the plus or minus button */
	// this both defines the class and declares an instance
	ActionListener buttonListener = new ActionListener() {

		/**
		* Performs the actions for each of the JButtons
		* @param ae The event (i.e. the button) that was clicked
		*/
		@Override
		public void actionPerformed(ActionEvent ae) {

			if (ae.getActionCommand().equals("+")) {
				//System.out.println("here in +");	 // for debuggin
				buttonValue++;
				buttonLabel.setText(buttonValue.toString());
				
			}  
		} // end actionPerformed
	}; // end buttonListener		

} // end class