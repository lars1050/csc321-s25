import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

import java.util.Random;

/** Circle for drawing in a JFrame
 *
 * @author Amy Larson
 */
public class Person extends JPanel {

	/** diameter of the circle */
	private static final int SIZE = 15;
	
	private static Random random = new Random();

	/** Boundaries within people can move. They will bounce off the boundary */	
	private static final int LEFT_BOUNDARY = SIZE;
	private static final int RIGHT_BOUNDARY = Layout.POPULATION_PANEL_W-SIZE;
	private static final int TOP_BOUNDARY = SIZE;
	private static final int BOTTOM_BOUNDARY = Layout.POPULATION_PANEL_H-SIZE;
	
	/** Health status of the person. From enum Status */
	private Status status = Status.HEALTHY_VACCINATED;
	
	/** Position (column) relative to the origin of the population panel */
	private int locationX = 0;
	
	/** Position (row) relative to the origin of the population panel */
	private int locationY = 0;
	
	/** Movement along the x-axis at each time step */
	private int deltaX = 0;
	
	/** Movement along the y-axis at each time step */
	private int deltaY = 0;

	/** Default constructor */
    public Person() {

        setLayout(null);
        
        // Range for randomly placing new persons
        int rangeX = RIGHT_BOUNDARY - LEFT_BOUNDARY - 20;
        int rangeY = BOTTOM_BOUNDARY - TOP_BOUNDARY - 20;
        locationX = random.nextInt(rangeX) + LEFT_BOUNDARY + 20;
        locationY = random.nextInt(rangeY) + TOP_BOUNDARY + 20;

		// randomly place each person
    	setBounds(locationX, locationY, SIZE, SIZE);
		//System.out.println("created with bounds: " + getBounds()); 
		
		// randomly select rate of movement per time step
		deltaX = random.nextInt(6) - 3;		// range -3 to 3
		deltaY = random.nextInt(6) - 3;
		
		setVisible(true);
    }
    
    /** Move person based on their deltas along X and Y. */
    public void move() {
    
    	// change in each direction
    	locationX += deltaX;
    	locationY += deltaY;
    	
    	// check if x (column) out of bounds. bounce off boundary
    	if (locationX < LEFT_BOUNDARY) {
    		locationX = LEFT_BOUNDARY + SIZE;
    		deltaX = -deltaX;
    	} else if (locationX > RIGHT_BOUNDARY) {
    		locationX = RIGHT_BOUNDARY - SIZE;
    		deltaX = -deltaX;
    	}
    	// check if y (row) is out of bounds
    	if (locationY < TOP_BOUNDARY) {
    		locationY = TOP_BOUNDARY + SIZE;
    		deltaY = -deltaY;
    	} else if (locationY > BOTTOM_BOUNDARY) {
    		locationY = BOTTOM_BOUNDARY - SIZE;
    		deltaY = -deltaY;
    	}
    	setLocation(locationX,locationY);
    }
    
    public void overlapped() {
    	status = Status.NOT_ALIVE;
    }
    
    public int getCenterX() {
    	return (locationX + SIZE)/2;
    }
    public int getCenterY() {
    	return (locationY + SIZE)/2;
    }
    public static int SIZE() {
    	return SIZE;
    }
    
    public Status status() {
    	return status;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(status.color);
        g.fillOval(0, 0, SIZE, SIZE);
    }
}