import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Font;

public class CircleModel extends JPanel {

	int column = 0;
	int row = 0;
	
	private int radius = 100;
	
	private Color color = new Color(0,0,0);
	
	public CircleModel() {
		setSize(radius*2, radius*2);
		setOpaque(false);

		//setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
	}
	
	public void setColor(Color color) {
		this.color = color;
		repaint();
	}
	
	public void setInFrame(int col, int row) {
		this.column = col;
		this.row = row;	
		setBounds(column, row, 300, 300);
	}
	
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		g.setColor(color);
		g.fillOval(0,0,radius*2, radius*2);
	}
}