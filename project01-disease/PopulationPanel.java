import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class PopulationPanel extends JPanel {
	
	Population population = new Population();
	
	public PopulationPanel() {
	
		setLayout(null);
		
		setBounds(
			Layout.POPULATION_PANEL_X, Layout.POPULATION_PANEL_Y,
			Layout.POPULATION_PANEL_W, Layout.POPULATION_PANEL_H
			);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		// Create bounding boxes for top areas (top,bottom,left,right)
		Layout.BOUNDARIES[0] = new BoundingBox(
			10, Layout.POPULATION_PANEL_H/2-10,
			10, Layout.POPULATION_PANEL_W/2-10
		);
		Layout.BOUNDARIES[1] = new BoundingBox(
			10, Layout.POPULATION_PANEL_H/2-10,
			10+Layout.POPULATION_PANEL_W/2, Layout.POPULATION_PANEL_W-10
		);
		Layout.BOUNDARIES[2] = new BoundingBox(
			10+Layout.POPULATION_PANEL_H/2, Layout.POPULATION_PANEL_H-10,
			10, Layout.POPULATION_PANEL_W/2-10
		);
		Layout.BOUNDARIES[3] = new BoundingBox(
			10+Layout.POPULATION_PANEL_H/2, Layout.POPULATION_PANEL_H-10,
			10+Layout.POPULATION_PANEL_W/2, Layout.POPULATION_PANEL_W-10
		);
		

		//System.out.println("constructor PopulationPanel bounds: " + getBounds());  
        
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