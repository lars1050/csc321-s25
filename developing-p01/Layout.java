public class Layout {

	// size of the graphics window
	static final int WINDOW_W = 1700;
	static final int WINDOW_H = 1000;
	
	// size and location of the population View
	// occupies the right half of the graphics window
	static final int POPULATION_PANEL_W = WINDOW_W/2-10;
	static final int POPULATION_PANEL_H = WINDOW_H-10;
	static final int POPULATION_PANEL_X = WINDOW_W - POPULATION_PANEL_W;
	static final int POPULATION_PANEL_Y = 0;
	
	// size and location of the Statistics Panel
	// occupies the lower part of the left panel
	static final int STATS_PANEL_W = WINDOW_W/2;
	static final int STATS_PANEL_H = 300;
	static final int STATS_PANEL_X = 0;
	static final int STATS_PANEL_Y = WINDOW_H - STATS_PANEL_H;
	
	// size and location of the Control Panel
	// occupies the upper part of the left panel
	static final int CONTROL_PANEL_W = WINDOW_W/2;
	static final int CONTROL_PANEL_H = WINDOW_H - STATS_PANEL_H;
	static final int CONTROL_PANEL_X = 0;
	static final int CONTROL_PANEL_Y = 0;
	
	// SLIDER LOCATIONS PANEL and SLIDER size and location
	
	// size of a panel for a slider
	static final int SLIDER_PANEL_W = CONTROL_PANEL_W/2 - 10; // 5 each side
	static final int SLIDER_PANEL_H = 110;
	
	// location of slider PANEL within the control panel
	static final int SLIDER_PANEL_LEFT = 10;
	static final int SLIDER_PANEL_RIGHT = CONTROL_PANEL_W/2 + 10;
	
	// 3 rows for 3 slider PANELS in control panel
	static final int SLIDER_PANEL_ROW1 = 10;
	static final int SLIDER_PANEL_ROW2 = SLIDER_PANEL_ROW1 +SLIDER_PANEL_H +40;
	static final int SLIDER_PANEL_ROW3 = SLIDER_PANEL_ROW1 +SLIDER_PANEL_H*2 +80;
	
	// size of slider within a panel
	static final int SLIDER_W = SLIDER_PANEL_W - 150;
	static final int SLIDER_H = 50;
	
	// location of slider within the panel
	static final int SLIDER_X = (SLIDER_PANEL_W - SLIDER_W)/2;
	static final int SLIDER_Y = 30;
	
	// location of labels and value for slider 
	static final int LABEL_W = 100;
	static final int LABEL_LEFT_X = 30;
	static final int LABEL_RIGHT_X = SLIDER_PANEL_W - LABEL_W;

}