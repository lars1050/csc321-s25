
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Font;


public class ColorController extends JPanel {

	private final int W_PANEL = 1000;
	private final int H_PANEL = 500;

	private ColorSlider redSlider;
	private ColorSlider greenSlider;
	private ColorSlider blueSlider;
	
	private CircleModel circle;
	
	public ColorController() {
		super();
		setLayout(null);
	}
	
	public void setInFrame(int column, int row) {
	
		// this column and row is relative to the frame
		setBounds(column, row, W_PANEL, H_PANEL);
		
		redSlider = new ColorSlider(this,"R");
		redSlider.setInFrame(10,10);
		this.add(redSlider); 
		
		//redSlider.setInFrame(column, row);
		
		greenSlider = new ColorSlider(this,"G");
		greenSlider.setInFrame(10,row+50);
		this.add(greenSlider);
		
		blueSlider = new ColorSlider(this,"B");
		blueSlider.setInFrame(10,row+100);
		this.add(blueSlider);
		
		circle = new CircleModel();
		circle.setInFrame(W_PANEL-250,row+20);
		this.add(circle);

	}
	
	public void colorChanged() {
	
		Color c = new Color(redSlider.sliderValue(), greenSlider.sliderValue(), blueSlider.sliderValue());
		
		circle.setColor(c);
	
	}


	// collection of color sliders
	// object that changes ColorController
	
	
	// need message passing from slider listeners

}