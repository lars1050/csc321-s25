import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;

/**
* Primary display for some GUI components.
* @author Amy Larson
*/
public class SimpleGUIApp extends JFrame {

	// Define the size of the graphics window
	final private int W_WIDTH = 1200;
	final private int W_HEIGHT = 800;
	
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

		// make it all appear
		setVisible(true);
	}

} // end class SimulationGUI
