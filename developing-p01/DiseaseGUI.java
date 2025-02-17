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

	PopulationPanel populationPanel;
	ControlPanel controlPanel = new ControlPanel();
	StatsPanel statsPanel = new StatsPanel();


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
        Timer timer = new Timer(20, e -> {
			populationPanel.update();
		});
		timer.start();        
    }
    
    public static void main(String[] args) {
    	DiseaseGUI gui = new DiseaseGUI();
    }
}


//System.out.println("PopulationPanel IN disease: " + populationPanel.getBounds());