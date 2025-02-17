import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;
//import java.util.*;

/**
 * The "VIEW" of Model-View-Controller
 * An instance of this gui contains a reference to the Controller and the Model.
 * @author Amy Larson
 */
public class DiseaseGUI extends JFrame {
	
	/** Viewing of the population simulation */
	PopulationPanel populationPanel;
	
	/** Components to control the simulation */
	ControlPanel controlPanel;
	
	/** Report of the various statistics about the population */
	StatsPanel statsPanel;
	
	/** Pause the simulation */
	private boolean paused = true;

	/** Number of hours transpired in this "day" */
	private Integer hours = 0;
	
	/** Number of "days" since the simulation started */
	private Integer days = 0;

	/** Constructor to create all aspects of the simulation */
    private DiseaseGUI() {

        // Initialize the graphics window
        super("Disease Model");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(Layout.WINDOW_W, Layout.WINDOW_H);
        
        // You control the layout
        this.getContentPane().setLayout(null);
        
		populationPanel = new PopulationPanel();
        getContentPane().add(populationPanel);

		controlPanel = new ControlPanel();
        getContentPane().add(controlPanel);
        
		statsPanel = new StatsPanel();
        getContentPane().add(statsPanel);
    
        setVisible(true);
        
        // controls the timing of the movement
        // Consider each tick of the timer to be 1 hour
        Timer timer = new Timer(20, e -> {
        	if (!MessageBoard.paused()) {
        		// causes each Person to move
				populationPanel.update();
				// Each timer execution is another "hour" in this day
				++hours;
				if (hours >= 24) {
					// reached the end of the day. mark the time
					++days;
					hours = 0;
					MessageBoard.update(Message.DAYS,days);
				}
			}
		});
		timer.start();        
    }
    
    public static void main(String[] args) {
    	DiseaseGUI gui = new DiseaseGUI();
    }
}


//System.out.println("PopulationPanel IN disease: " + populationPanel.getBounds());