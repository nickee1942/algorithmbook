package edu.gwu.algorithms.dandc.overlappingrectangles;

/**
 * Created by yichenzhou on 10/2/16.
 */

public class IntervalTree {
    private Interval root;
    public int count = 0;
    public class Interval {
        private double leftValue;
        private double rightValue;
        private Interval left, right;
        private double maxEndPoint = rightValue;

        public Interval(double leftValue, double rightValue) {
            this.leftValue = leftValue;
            this.rightValue = rightValue;
        }
    }

    public int size() {
        return count;
    }

    /***
     * @param interval1, each interval already in the interval tree
     * @param interval2, the new interval to test intersection
     */
    public boolean isIntersect(Interval interval1, Interval interval2) {
        // A < C < B
        if ((interval1.leftValue < interval2.leftValue) && (interval2.leftValue < interval1.rightValue)) {
            return true;
        }
        // A < D < B
        else if ((interval1.leftValue < interval2.rightValue) && (interval2.rightValue < interval1.rightValue)) {
            return true;
        }
        // A < C && D < B
        else if ((interval2.leftValue < interval1.leftValue) && (interval2.rightValue > interval1.rightValue)) {
            return true;
        } else return false;
    }

    /***
     *  Insert an interval, which contains leftValue and rightValue, to Interval Tree
     */

    public void put(double leftValue, double rightValue) {
        root = put(root, leftValue, rightValue);
        count++;
    }

    private Interval put(Interval x, double leftValue, double rightValue) {
        if (x == null) return new Interval(leftValue, rightValue);
        double cmp = leftValue - x.leftValue;
        if (rightValue > x.rightValue) {
            x.maxEndPoint = rightValue;
        }
        if (cmp < 0) {
            x.left = put(x.left, leftValue, rightValue);
        } else if (cmp > 0) {
            x.right = put(x.right, leftValue, rightValue);
        } else {
            x.leftValue = leftValue;
            x.rightValue = rightValue;
        }
        return x;
    }

    /***
     *  Search an interval, which contains leftValue and rightValue, in the Interval Tree.
     */
    public Boolean search(double leftValue, double rightValue) {
        Interval neo = new Interval(leftValue, rightValue);
        if (search(root, neo) == null) {
            return false;
        } else {
            Interval intersected = search(root, neo);
            return true;
        }
    }

    private Interval search(Interval x, Interval neo) {
        if (x == null) return null;
        if (isIntersect(x, neo)) return x;
        else if (x.left == null) return search(x.right, neo);
        else if (x.left.maxEndPoint < neo.leftValue) return search(x.right, neo);
        else return search(x.left, neo);
    }

}
