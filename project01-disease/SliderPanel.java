import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderPanel extends JPanel {

	private static final Font font = new Font("Verdana", Font.PLAIN, 12);

	/** Slider for controlling aspect of the model */
	private JSlider slider;
	
	/** Description of the slider */
	protected JLabel title;
	
	/** Describes the meaning of the leftmost value */
	private JLabel leftLabel;
	
	/** Describes the meaning of the rightmost value */
	private JLabel rightLabel;
	
	/** Displays the value of the slider */
	private JLabel valueLabel;
	
	/** The actual value of the slider */
	// probably do not need this since it is accessible via the slider
	private Integer sliderValue = 0;
	
	/** Constructor
	@param row Placement within the Graphics window
	@param column Placement withint the Graphics window
	*/
	public SliderPanel(int row, int column) {
	
		setLayout(null);
		
		setBounds(row, column, Layout.SLIDER_PANEL_W, Layout.SLIDER_PANEL_H);
		//setBorder(BorderFactory.createLineBorder(Color.black));
		
		// Set up the slider
		slider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		slider.setMajorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setFont(new Font("Verdana", Font.PLAIN, 12));
	
		
		// position is relative to the origin of this panel
		slider.setBounds(
			Layout.SLIDER_X, Layout.SLIDER_Y,
			Layout.SLIDER_W, Layout.SLIDER_H
		);

		//System.out.println("Slider: " + slider.getBounds());
		
		// action/function called when slider is moved
        slider.addChangeListener(sliderListener);
        // Add component to current panel
        add(slider);
        
        title = new JLabel("Title for Control");
        title.setBounds((Layout.SLIDER_PANEL_W)/2-50, 15, Layout.SLIDER_PANEL_W-10, 15);
        title.setFont(font);
        add(title);
                
        leftLabel = new JLabel("left label");
        leftLabel.setBounds(Layout.LABEL_LEFT_X,20,Layout.SLIDER_W,15);
        leftLabel.setFont(font);
        //add(leftLabel); // getting a little busy. maybe not this.
        
        rightLabel = new JLabel("right label");
        rightLabel.setBounds(Layout.LABEL_RIGHT_X,20,Layout.SLIDER_W,15);
        rightLabel.setFont(font);
        //add(rightLabel);  // getting a little busy. maybe not this.
        
        valueLabel = new JLabel("Value");
        // Center the label in the panel
        valueLabel.setBounds(
        	(Layout.SLIDER_PANEL_W)/2-5, Layout.SLIDER_PANEL_H - 15, 100, 15
        );
        valueLabel.setFont(font);
        add(valueLabel);
		
		setVisible(true);
	
	}
	
	/** Action associated with a change in the slider value */
	// this is both defined and instantiated in a single statement
	ChangeListener sliderListener = new ChangeListener() {
	
		@Override
		public void stateChanged(ChangeEvent ce) {

			sliderValue = slider.getValue();
			valueLabel.setText(sliderValue.toString());
			
			// need to update the "observers" of this slider
		}
	}; // end sliderListener
}