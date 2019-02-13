package edu.gwu.algorithms.dandc.mvcs;

import edu.gwu.algorithms.problems.MVCS;
import edu.gwu.algorithms.utils.Utils;

/** Solves MVCS problem using D&C, in n log n time. */
public class MVCS_DC implements MVCS {

    /** Finds the maximum value CS in a, given left and right indices, both inclusive. */
    public int findMax(int[] a, int leftIndex, int rightIndex) {

        // Base Cases
        if (leftIndex > rightIndex) {
            throw new IllegalArgumentException("Left can't be greater than right.");
        }
        if (leftIndex == rightIndex) {
            return a[leftIndex];
        }
        if (leftIndex == rightIndex - 1) {
            return Utils.max(a[leftIndex] + a[rightIndex], a[leftIndex], a[rightIndex]);
        }

        // Finds the mid point.
        int midPoint = (leftIndex + rightIndex) / 2;

        // Makes two recursive calls
        int leftMax = findMax(a, leftIndex, midPoint);
        int rightMax = findMax(a, midPoint + 1, rightIndex);
        int midMax = findMidMax(a, leftIndex, rightIndex, midPoint);
        return Utils.max(leftMax, rightMax, midMax);
    }

    /** Finds the "middle max", such that the midpoint and the point to the right of point point is always included.. */
    private int findMidMax(int[] a, int leftIndex, int rightIndex, int midPoint) {
        int rightMax = uniMax(a, midPoint + 1, rightIndex, 1);
        int leftMax = uniMax(a, midPoint, leftIndex, -1);
        return leftMax + rightMax;
    }

    private int uniMax(int[] a, int startIndex, int endIndex, int direction) {
        int unimax = a[startIndex];
        int unisum = a[startIndex];
        int index = startIndex + direction;
        while (index <= endIndex && index >= 0) {
            unisum += a[index];
            unimax = Math.max(unimax, unisum);
            index += direction;
        }
        return unimax;
    }

    @Override
    public int findMax(int[] array) {
        return findMax(array, 0, array.length - 1);
    }
}
