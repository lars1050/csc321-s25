import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;
import java.util.*;


public class StatsPanel extends JPanel {

	JLabel heading;

	public StatsPanel() {
			
		setBounds( //0,50,100,100);
			Layout.STATS_PANEL_X, Layout.STATS_PANEL_Y,
			Layout.STATS_PANEL_W, Layout.STATS_PANEL_H
		);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		heading = new JLabel("Heading");
		heading.setText("Health Statistics of Population");
		heading.setBounds(Layout.STATS_PANEL_X/2-100,15,300,50);
		add(heading);
		
		setVisible(true);
	}
}