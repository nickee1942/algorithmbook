package algorithms.book.core;

/**
 * Time complexity confirmable algorithms.
 * 
 * @author Amrinder Arora
 */
public interface TCConfirmableAlgorithm {
	/**
	 * Runs the problem instances of varying sizes and different number of
	 * times. Produces a TCReport.
	 */
	TCReport runProblemInstances(int[] inputSizes, int numTimes);
}
