import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {

	SliderPanel[] panels = new SliderPanel[6];
	/*
	0 // upper left
	1 // upper right
	2 // middle left
	3 // middle right
	4 // lower left
	5 // lower right
	*/
	
	/** Simulation starts when this button is clicked */
	JButton startButton;
	
	public ControlPanel() {
	
		setLayout(null);
	
	    setBounds(
			Layout.CONTROL_PANEL_X, Layout.CONTROL_PANEL_Y,
			Layout.CONTROL_PANEL_W, Layout.CONTROL_PANEL_H
		);
		setBorder(BorderFactory.createLineBorder(Color.black));

		
		// ROW 1 Sliders (left and right side)
		panels[0] = new SliderPanel(
			Layout.SLIDER_PANEL_LEFT, Layout.SLIDER_PANEL_ROW1
		);
		add(panels[0]);
		
		
		panels[1] = new SliderPanel(
			Layout.SLIDER_PANEL_RIGHT, Layout.SLIDER_PANEL_ROW1
		);
		add(panels[1]);
		
		// ROW 2 Sliders (left and right side)
		panels[2] = new SliderPanel(
			Layout.SLIDER_PANEL_LEFT, Layout.SLIDER_PANEL_ROW2
		);
		add(panels[2]);
		
		
		panels[3] = new SliderPanel(
			Layout.SLIDER_PANEL_RIGHT, Layout.SLIDER_PANEL_ROW2
		);
		add(panels[3]);
		
		// ROW 3 Sliders (left and right side)
		panels[4] = new SliderPanel(
			Layout.SLIDER_PANEL_LEFT, Layout.SLIDER_PANEL_ROW3
		);
		add(panels[4]);
		
		
		panels[5] = new SliderPanel(
			Layout.SLIDER_PANEL_RIGHT, Layout.SLIDER_PANEL_ROW3
		);
		add(panels[5]);
		
		startButton = new JButton("Start");
		startButton.setBounds(
			Layout.START_X, Layout.START_Y, Layout.START_W, Layout.START_H
		);
		startButton.addActionListener(buttonListener);
		add(startButton);

		setVisible(true);
	}
	
	/** Action associated with pushing the start button */
	// this is both defined and instantiated in a single statement
	ActionListener buttonListener = new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent ae) {
			// update the corresponding value in the message board
			MessageBoard.update(Message.PAUSED,false);
		}
	}; // end sliderListener

} // end class