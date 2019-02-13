package edu.gwu.algorithms.dandc.mvcs;

import org.junit.Assert;
import org.junit.Test;

import edu.gwu.algorithms.problems.MVCS;

public class MVCS_BruteForceTest extends MVCS_Test {

    private MVCS mvcsBf = new MVCS_BruteForce();

    @Test
    public void testAll() {
        for (MVCS_TestCase tc : testBattery) {
            Assert.assertEquals(mvcsBf.findMax(tc.getArray()), tc.getValue());
        }
    }
}
