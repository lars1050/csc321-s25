import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Font;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** 
Java Graphics components to demonstrate how a slider can be used. It includes an integer value, the slider to set the value, and a label to display the value.
*/
public class SliderController {

	/** The Java graphics frame/window in which the controls will be placed */
	JFrame frame;
	
	/** Value being controlled by the slider and displayed with the label */
	Integer sliderValue = 50;

	/** Display of the slider (and variable) value */
	protected final JLabel sliderLabel = new JLabel(sliderValue.toString());
	
	/** Horizontal slider with defined range and initial value */
	protected final JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);

	/**
	* Constructor.
	* @param frame in which play button controller components will display.
	*/
	public SliderController(JFrame frame) {
		this.frame = frame;
	}
	
	/**
	* Configures the graphics components and places in the frame.
	* @param column (location) within the graphics window for left edge.
	* @param row (location) within the graphics window for top edge.
	*/	
	public void setInFrame(int column, int row) {
	
		// Set up slider in upper left corner
		slider.setFont(new Font("Verdana", Font.PLAIN, 16));		

		// show a tick and its value every 10 units
		slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

		// location and size within which the slider is displayed
        slider.setBounds(column, row, 250, 50);

		// paired action for when slider is moved
        slider.addChangeListener(sliderListener);
        
        frame.getContentPane().add(slider);
        
        // display of slider/variable value
        sliderLabel.setFont(new Font("Verdana", Font.PLAIN, 36));
        sliderLabel.setBounds(column, row+100, 100, 100);
        frame.getContentPane().add(sliderLabel);
	} // end setInFrame
	
	// getter
	public JSlider slider() {
		return slider;
	}
	
	/** Action associated with a change in the slider value */
	// this is both defined and instantiated in a single statement
	ChangeListener sliderListener = new ChangeListener() {
	
		@Override
		public void stateChanged(ChangeEvent ce) {
			// System.out.println("slider changed.");
		}
	}; // end sliderListener
	
} // end class