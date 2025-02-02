import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
Java Graphics components to demonstrate how buttons can be used to modify a variable. It includes an integer value, 2 buttons (+/-) to change the value, and a label to display the value.
*/
public class FontController extends JPanel {

	private final int W_PANEL = 1000;
	private final int H_PANEL = 500;
	
	private final int BUTTON_COL = 50;
	private final int BUTTON_ROW = 100;
	private final int BUTTON_SIZE = 100;
	
	private final Font DEFAULT_FONT = new Font("Verdana", Font.PLAIN, 36);
	
	private final int W_TEXT = 400;
	
	/** The value being modified by the buttons */
	private Integer value = 75;
	
	/** The text being "controlled" based on the value */
	private TextModel textModel;
	
	/** +/- buttons for control of the font size of the textModel */
	private final JLabel valueLabel = new JLabel(value.toString());
	private final JButton plus = new JButton("+");
	private final JButton minus = new JButton("-");
	
	/**
	* Constructor.
	* @param frame in which buttons controller components will display.
	*/
	public FontController() {
		setLayout(null);
		textModel = new TextModel(value);
	}
		
	/**
	* Configures the graphics components and places in the frame.
	* @param column (location) within the graphics window for left edge.
	* @param row (location) within the graphics window for top edge.
	*/
	public void setInFrame(int column, int row) {
	
		// this column and row is relative to the frame
		setBounds(column, row, W_PANEL, H_PANEL);
		
		// this column and row is relative to this panel
		textModel.setInFrame(BUTTON_COL*2+W_TEXT, BUTTON_ROW-150);
		this.add(textModel);
			
		formatButton(minus, BUTTON_COL, BUTTON_ROW);
		// buttonListener defines what to do if the button is clicked
		minus.addActionListener(buttonListener);
		this.add(minus);
		
		formatButton(plus, BUTTON_COL+BUTTON_SIZE+10, BUTTON_ROW);
		// buttonListener defines what to do if the button is clicked
		plus.addActionListener(buttonListener);
		this.add(plus);
				
		// set size and placement of text
		valueLabel.setFont(DEFAULT_FONT);
		valueLabel.setBounds(BUTTON_COL, BUTTON_ROW+BUTTON_SIZE+10, 100, 100);
        this.add(valueLabel);

        	
	} // end setInFrame
	
	public void formatButton(JButton button, int column, int row) {
		// Control the display of the button (so it is a solid color)
		button.setOpaque(true);
		button.setContentAreaFilled(true);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setBackground(Color.YELLOW);

		// set location and size within which the object is displayed
		button.setBounds(column, row, BUTTON_SIZE, BUTTON_SIZE);
		button.setFont(DEFAULT_FONT);
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
				value+=5;
				
			} else if (ae.getActionCommand().equals("-")) {
				value-=5;
			}
			valueLabel.setText(value.toString());
			textModel.setSize(value);
			 
		} // end actionPerformed
	}; // end buttonListener		

} // end class