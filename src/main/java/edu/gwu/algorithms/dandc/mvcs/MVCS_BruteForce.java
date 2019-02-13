package edu.gwu.algorithms.dandc.mvcs;

import edu.gwu.algorithms.problems.MVCS;

/** Solves MVCS problem using bruteforce method, in O(n^2) time. */
public class MVCS_BruteForce implements MVCS {

    /** Finds the maximum value CS in a, given left and right indices, both inclusive. */
    @Override
    public int findMax(int[] array) {
        int maximum = Integer.MIN_VALUE;
        int[][] sums = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            sums[i][0] = array[i];
            maximum = Math.max(maximum, sums[i][0]);
            for (int j = 1; i + j < array.length; j++) {
                sums[i][j] = sums[i][j - 1] + array[i + j];
                maximum = Math.max(maximum, sums[i][j]);
            }
        }

        return maximum;
    }
}
