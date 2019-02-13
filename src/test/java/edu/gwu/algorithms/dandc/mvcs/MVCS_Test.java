package edu.gwu.algorithms.dandc.mvcs;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MVCS_Test {

    public List<MVCS_TestCase> testBattery = new ArrayList<>();

    public MVCS_Test() {
        int[] a1 = { -1, 1, 2, -3, -1, 2, 2, -1, -1, 2, -10 };
        MVCS_TestCase tc = new MVCS_TestCase();
        tc.setArray(a1);
        tc.setValue(4);
        testBattery.add(tc);

        int[] a2 = { 1, 1, 2, 3, 1, 10 };
        tc = new MVCS_TestCase();
        tc.setArray(a2);
        tc.setValue(18);
        testBattery.add(tc);

        int[] a3 = { -1, -1, -200, -10 };
        tc = new MVCS_TestCase();
        tc.setArray(a3);
        tc.setValue(-1);
        testBattery.add(tc);
    }

    /**
     * Generates an array of length "length" with values
     * from -bound to +bound.
     */
    public int[] generateRandomArray(int length, int bound) {
        int[] a = new int[length];
        Random random = new SecureRandom();
        for (int i=0;i<length;i++) {
            a[i] = random.nextInt(bound) - 2 * bound;
        }
        return a;
    }
}
