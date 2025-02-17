import java.util.Random;


/** Helper class to manage the boundaries within a person can move */
public class BoundingBox {

	/** buffer between areas in the PopulationPanel */
	public static final int padding = 10;

	// the corresponding rows and columns for the box boundaries
	int top = 0;
	int bottom = 0;
	int left = 0;
	int right = 0;
	
	/** The range of column values from which to choose randomly */
	private int rangeX = 0;
	
	/** The range of row values from which to choose randomly */
	private int rangeY = 0;

	private Random random = new Random();
	
	/** Define the dimensions of the bounding box
	* @param top row within the populationPanel that is the top border
	* @param bottom row within the populationPanel that is the bottom border
	* @param left column with the populationPanel that is the left border
	* @param right column within the populationPanel that is the right border
	*/
	public BoundingBox(int top, int bottom, int left, int right) {
		this.top = top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		
		rangeX = right - left - padding*2;
		rangeY = bottom - top - padding*2;
	}
	
	@Override
	public String toString() {
		return "top="+top+". bottom="+bottom+". left="+left+". right="+right; 
	}
	
	public Integer getRandomX() {
		return random.nextInt(rangeX) + left + padding;
	}
	
	public Integer getRandomY() {
		return random.nextInt(rangeY) + top + padding;
	}
	
}