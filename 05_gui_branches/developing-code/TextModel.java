import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Font;

public class TextModel extends JLabel {
	
	private final String symbol = "\u2603";
	
	private final int W_TEXT = 400;
	private final int H_TEXT = 400; 
	
	public TextModel(int fontSize) {
		super("Symbol");
		setFont(new Font("",Font.PLAIN,fontSize));
		setText(symbol);
	}
	
	public void setInFrame(int column, int row) {
		setBounds(column, row, W_TEXT, H_TEXT);
	}
	
	public void setSize(int size) {
		setFont(new Font("",Font.PLAIN,size));
	}
}