package edu.gwu.algorithms.asymptotic;

public class TCObservation {
	private int problemInstance;
	private double observedTimeNanos;

	public int getProblemInstance() {
		return problemInstance;
	}

	public void setProblemInstance(int problemInstance) {
		this.problemInstance = problemInstance;
	}

	public double getObservedTimeNanos() {
		return observedTimeNanos;
	}

	public void setObservedTimeNanos(double observedTimeNanos) {
		this.observedTimeNanos = observedTimeNanos;
	}

}
