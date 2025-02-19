/** Typical 2d Point Class with x- and y-coordinates.
 *
 * @author amylarson
 */
public class Point {

    public int x;
    public int y;

    public Point() {
        x = 0;
        y = 0;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "["+x+","+y+"]";
    }

    public int x() { return x; }
    public void x(int val) { x=val; }

    public int y() { return y; }
    public void y(int val) { y=val; }
}
