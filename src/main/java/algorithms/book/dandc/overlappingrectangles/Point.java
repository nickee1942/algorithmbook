package algorithms.book.dandc.overlappingrectangles;

/**
 * Created by yichenzhou on 10/5/16.
 */

public class Point {
    private double x;
    private double y;
    public Point(double pointX, double pointY) {
        this.x = pointX;
        this.y = pointY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
