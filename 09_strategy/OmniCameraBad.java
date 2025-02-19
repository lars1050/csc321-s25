/** Omni-Directional Robot that uses a Camera */
public class OmniCameraBad extends RobotBad {

	public OmniCameraBad(String name) {
		super(name);
	}
	
	@Override
	public void sense() {
		// Randomly generate a reading of an obstacle in the environment
		// It can be as close as 1 or beyond the max (thus not visible)
		int distance = rand.nextInt(300*2) + 1;
		if (distance > 300) {
		  System.out.println("(Camera) No obstacles ahead");
		} else {
		  System.out.printf("(Camera) Obstacle %d units ahead.%n",distance);
		}
	}
}
