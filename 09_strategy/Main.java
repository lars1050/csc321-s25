public class Main {
  public static void main(String[] args) {

    System.out.println("^^^^^^^^  ROBOTS  ^^^^^^^");

    RobotBad rosie = new RobotBad("Rosie");

    OmniCameraBad eva = new OmniCameraBad("Eva");

    // OmniTouchBad roomba = new OmniTouchBad("Hoover");

    // WheelCameraBad walle  = new OmniIRBad("Wall-E");

    RobotBad[] robots = {rosie, eva /*, roomba, walle*/};
    for (RobotBad robot : robots) {
      System.out.println("----------------------------");
      robot.describe();
      robot.move(45,10);
      robot.sense();
    }
  }
}
