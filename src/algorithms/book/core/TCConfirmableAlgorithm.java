package algorithms.book.core;

public interface TCConfirmableAlgorithm {
	/**
	 * Runs the problem instances of varying sizes and different number of
	 * times. Produces a TCReport.
	 */
	TCReport runProblemInstances(int[] inputSizes, int numTimes);
}
