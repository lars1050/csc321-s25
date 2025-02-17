import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class ControlPanel extends JPanel {
	
	SliderPanel panelA;
	SliderPanel panelB;
	SliderPanel panelC;
	SliderPanel panelD;
	SliderPanel panelE;
	SliderPanel panelF;

	public ControlPanel() {
	
		setLayout(null);
	
	    setBounds(
			Layout.CONTROL_PANEL_X, Layout.CONTROL_PANEL_Y,
			Layout.CONTROL_PANEL_W, Layout.CONTROL_PANEL_H
		);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		// ROW 1 Sliders (left and right side)
		panelA = new SliderPanel(
			Layout.SLIDER_PANEL_LEFT, Layout.SLIDER_PANEL_ROW1
		);
		add(panelA);
		
		
		panelB = new SliderPanel(
			Layout.SLIDER_PANEL_RIGHT, Layout.SLIDER_PANEL_ROW1
		);
		add(panelB);
		
		// ROW 2 Sliders (left and right side)
		panelC = new SliderPanel(
			Layout.SLIDER_PANEL_LEFT, Layout.SLIDER_PANEL_ROW2
		);
		add(panelC);
		
		
		panelD = new SliderPanel(
			Layout.SLIDER_PANEL_RIGHT, Layout.SLIDER_PANEL_ROW2
		);
		add(panelD);
		
		// ROW 3 Sliders (left and right side)
		panelE = new SliderPanel(
			Layout.SLIDER_PANEL_LEFT, Layout.SLIDER_PANEL_ROW3
		);
		add(panelE);
		
		
		panelF = new SliderPanel(
			Layout.SLIDER_PANEL_RIGHT, Layout.SLIDER_PANEL_ROW3
		);
		add(panelF);
		

		setVisible(true);
	}

} // end class