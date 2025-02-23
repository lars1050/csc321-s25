public class Circle {
    /** Column coordinate of circle location in graphics */
    private int x;

    /** Row coordinate of circle location in graphics */
    private int y;

    /** Radius of circle in pixels */
    private int radius;

    /** Constructor
     * @param x Column coordinate of circle location
     * @param y Row coordinate of circle location
     * @param radius In pixel units
     */
    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    /** Default constructor. Creates circle at origin. */
    public Circle() {
        this(0,0,1);
    }

    @Override
    public String toString() {
        return String.format("[(%d,%d),%d]",x,y,radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }
        if (obj==null) {
            return false;
        }
        if (!(obj instanceof Circle)) {
            return false;
        }
        Circle c = (Circle) obj;
        return x==c.x && y==c.y && radius==c.radius;
    }

    /** Circumference in pixel units
     * @return calculated circumference
     */
    public double circumference() {
        return 2.0*Math.PI*radius;
    } 

    /** Area in pixel units
     * @return calculated area
     */
    public double area() {
        return Math.PI*radius*radius;
    }

    /** Determines if 2 circles are touching or overlapping
     * @param other Circle to test against this Circle
     * @return true if touching or overlapping, false otherwise
     */
    public boolean overlaps(Circle other) {
        return false;
    }

    /** Determine angle in degrees between circle centers. 90 is along positive y-axis.
     * @param other Circle to compare to this
     * @return angle in degrees between 0 and 359. Angle is oriented from this to other circle.
     */
    public int angleBetween(Circle other) {
        return 0;
    }

    // Getters and Setters
    public int getX() { 
        return x;
    }
    public int getY() {
        return y;
    }
    public int getRadius() {
        return radius;
    }
}