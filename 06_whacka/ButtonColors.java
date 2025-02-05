import java.awt.Color;
import java.util.Random;

public class ButtonColors {

	// colors used for the whack-a-buttons
	static final Color ONE = new Color(128,14,19); // my red
	static final Color TWO = new Color(0,75,35); // my green
	static final Color THREE = new Color(1,79,134); // my blue
	static final Color CUE_COLOR = new Color(255,109,0); // orange
	static final Color NEUTRAL = new Color(253,240,253); // light lavendar

	static final Color SUCCESS = new Color(0,0,0); // BLACK
	static final Color FAIL = new Color(255,255,255); // WHITE

	// all permutations of RBG for coloring the 3 buttons.
	// The game randomly chooses a permutation at each color change.
	public static Color[][] colorPermutations = {
		{ONE,TWO,THREE},
		{ONE,THREE,TWO},
		{TWO,ONE,THREE},
		{TWO,THREE,ONE},
		{THREE,ONE,TWO},
		{THREE,TWO,ONE}
	};

	public static final Random random = new Random();

	public static Color[] getRandomOrder() {
		return colorPermutations[random.nextInt(6)];
	}
}
