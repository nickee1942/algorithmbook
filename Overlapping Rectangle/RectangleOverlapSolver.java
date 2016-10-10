/**
 * Created by yichenzhou on 10/5/16.
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RectangleOverlapSolver {
    private int[] inputsScale;
    public RectangleOverlapSolver(int[] inputScale) {
        this.inputsScale = inputScale;
    }

    /***
     *  Execute toLoad() and toSolve()
     */
    public void toRun() {
        for (int i = 0; i < inputsScale.length; i++) {
            Rectangle[] rectangles = this.toLoad(inputsScale[i]);
            this.toSolve(rectangles);
        }
    }

    /***
     *  Load count numbers of rectangles into array
     */
    public Rectangle[] toLoad(int count) {
        Rectangle[] rectangles = new Rectangle[count];
        for (int i = 0; i < count; i++) {
            double topX = StdRandom.uniform(1, count);
            double topY = StdRandom.uniform(1, count);
            double bottomX = StdRandom.uniform(topX+1, 2 *count);
            double bottomY = StdRandom.uniform(0, topY);
            Point topLeft = new Point(topX, topY);
            Point bottomRight = new Point(bottomX, bottomY);
            rectangles[i] = new Rectangle(topLeft, bottomRight);
        }
        return rectangles;
    }

    /***
     *  Use Interval Tree to determine intersected rectangles in the array
     */
    public void toSolve(Rectangle[] loadedRectangles) {
        IntervalTree itX = new IntervalTree();
        IntervalTree itY = new IntervalTree();
        for (int i = 0; i < loadedRectangles.length; i++) {
            double leftValue = loadedRectangles[i].getTopLeft().getX();
            double rightValue = loadedRectangles[i].getBottomRight().getX();
            double topValue = loadedRectangles[i].getTopLeft().getY();
            double bottomValue = loadedRectangles[i].getBottomRight().getY();
            itX.put(leftValue, rightValue);
            itY.put(bottomValue, topValue);
        }
        StdOut.println(itX.size() + " pairs in the Interval Tree.");

        int intersectedCount = 0;
        long timer = 0;
        for (int i = 0; i < loadedRectangles.length; i++) {
            double leftValue = loadedRectangles[i].getTopLeft().getX();
            double rightValue = loadedRectangles[i].getBottomRight().getX();
            double topValue = loadedRectangles[i].getTopLeft().getY();
            double bottomValue = loadedRectangles[i].getBottomRight().getY();
            long beginTimer = System.nanoTime();
            if (itX.search(leftValue, rightValue) && itY.search(bottomValue, topValue)) {
                intersectedCount++;
            }
            long endTimer = System.nanoTime();
            timer += endTimer - beginTimer;
        }
        StdOut.println(intersectedCount + " pairs intersected rectangles.");
        StdOut.println("Time: " + timer);
        StdOut.println();
    }

}
