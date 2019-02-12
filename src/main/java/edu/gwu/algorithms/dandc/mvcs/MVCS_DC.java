package edu.gwu.algorithms.dandc.mvcs;

/** Solves MVCS problem using D&C, in n log n time. */
public class MVCS_DC {

    public int findMax(int[] a, int leftIndex, int rightIndex) {

        // Base Cases
        if (leftIndex > rightIndex) {
            throw new IllegalArgumentException("Left can't be greater than right.");
        }
        if (leftIndex == rightIndex) {
            return a[leftIndex];
        }
        if (leftIndex == rightIndex - 1) {
            return max(a[leftIndex] + a[rightIndex], a[leftIndex], a[rightIndex]);
        }

        // Finds the mid point.
        int midPoint = (leftIndex + rightIndex) / 2;

        // Makes two recursive calls
        int leftMax = findMax(a, leftIndex, midPoint);
        int rightMax = findMax(a, midPoint + 1, rightIndex);
        int midMax = 0; // TODO
        return max(leftMax, rightMax, midMax);
    }

    private int max(int arg1, int arg2, int arg3) {
        return Math.max(arg1, Math.max(arg2, arg3));
    }
}
