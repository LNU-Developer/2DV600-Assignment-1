
class RunPoint {
    public static void main(String args[]) {
        Point p1 = new Point();
        Point p2 = new Point(3, 4);
        System.out.println(p1.toString()); // ==> (0,0)
        System.out.println(p2.toString()); // ==> (3,4)
        if (p1.isEqualTo(p2)) // False!
            System.out.println("The two points are equal");
        double dist = p1.distanceTo(p2);
        System.out.println("Point Distance: " + dist);
        p2.move(5, -2); // ==> (8,2)
        p1.moveToXY(8, 2); // ==> (8,2)
        if (p1.isEqualTo(p2)) // True!
            System.out.println("The two points are equal");
    }
}

public class Point {
    int x = 0;
    int y = 0;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void moveToXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqualTo(Point p) {
        if (p.x == this.x && p.y == this.y)
            return true;
        else
            return false;
    }

    public double distanceTo(Point p) {
        return Math.sqrt((Math.pow(this.x - p.x, 2)) + Math.pow(this.y - p.y, 2));
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
