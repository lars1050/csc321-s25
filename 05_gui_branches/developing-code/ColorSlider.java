import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** 
Java Graphics components to demonstrate how a slider can be used. It includes an integer value, the slider to set the value, and a label to display the value.
*/
public class ColorSlider extends JPanel {

	// width and height of this panel
	private final int W_PANEL = 500;
	private final int H_PANEL = 50;

	/** Controller that manages all controller components. */
	ColorController controller;
	
	/** Reflects the current value on the slider */
	Integer sliderValue = 0;
	
	/** Slider to control value of the color */
	JSlider slider;
	
	/** The color being controlled (RGB) */
	JLabel colorLabel;
	
	/** Display of the value on the slider */
	JLabel valueLabel = new JLabel(sliderValue.toString());

	/**
	* Constructor.
	* @param frame in which play button controller components will display.
	*/
	public ColorSlider(ColorController controller, String label) {
	
		// components are placed within the window
		setLayout(null);
		
		this.controller = controller; 
		
		// Create all slider elements to control color (0 to 255)
		slider = new JSlider(JSlider.HORIZONTAL,0,255,0);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(false);
		slider.setPaintLabels(false);
		slider.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		// Displays R or G or B
		colorLabel = new JLabel(label);
		colorLabel.setText(label);

	}
	
	/**
	* Configures the graphics components and places in the panel.
	* @param column (location) within the panel.
	* @param row (location) within the panel.
	*/	
	public void setInFrame(int column, int row) {
	
		// location of this panel within the color controller panel
        setBounds(column, row, W_PANEL, H_PANEL);

		// Relative to this panel column and row
		slider.setBounds(50,10,300,50);
		
		// paired action for when slider is moved
        slider.addChangeListener(sliderListener);
        
        // Add component to current panel
        add(slider);
        
        // display of slider/variable value
        valueLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
        valueLabel.setBounds(400, 10, 100, 50);
        add(valueLabel);
        
        colorLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
        colorLabel.setBounds(10, 10, 100, 50);
        add(colorLabel);
        
	} // end setInFrame
	
	/** Action associated with a change in the slider value */
	// this is both defined and instantiated in a single statement
	ChangeListener sliderListener = new ChangeListener() {
	
		@Override
		public void stateChanged(ChangeEvent ce) {

			sliderValue = slider.getValue();
			valueLabel.setText(sliderValue.toString());
			
			// communicate to controller that a value has changed
			controller.colorChanged();
		}
	}; // end sliderListener
	
	public int sliderValue() {
		return sliderValue;
	}
	
} // end class