package edu.gwu.algorithms.dandc.mvcs;

import org.junit.Assert;
import org.junit.Test;

import edu.gwu.algorithms.problems.MVCS;

public class MVCS_DCTest extends MVCS_Test {

    private MVCS mvcsDc = new MVCS_DC();

    @Test
    public void testBattery() {
        for (MVCS_TestCase tc : testBattery) {
            Assert.assertEquals(mvcsDc.findMax(tc.getArray()), tc.getValue());
        }
    }

    @Test
    public void testAgainstBruteForce() {
        MVCS mvcsBf = new MVCS_BruteForce();
        int[] tc = generateRandomArray(100, 1000);
        int bfMax = mvcsBf.findMax(tc);
        int dcMax = mvcsDc.findMax(tc);
        System.out.println("bfMax: " + bfMax);
        Assert.assertEquals(bfMax, dcMax);
    }

}
