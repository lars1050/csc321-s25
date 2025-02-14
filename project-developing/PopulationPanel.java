import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class PopulationPanel extends JPanel {

	//Person person;// = new Person();
	
	Population population = new Population();
	
	public PopulationPanel() {
	
		setLayout(null);
		
		setBounds(
			Layout.POPULATION_PANEL_X, Layout.POPULATION_PANEL_Y,
			Layout.POPULATION_PANEL_W, Layout.POPULATION_PANEL_H
			);
		setBorder(BorderFactory.createLineBorder(Color.black));
	
		//System.out.println("constructor PopulationPanel bounds: " + getBounds());  
		
		//person = new Person();
		//add(person);
		
        //System.out.println("Added person at: " + person.getBounds()); 
        
        populate();
        
		setVisible(true);
	}
	
	public void populate() {
		population.populate(this);
	}
	
	public void update() {
		population.update();
		repaint();
	}

}