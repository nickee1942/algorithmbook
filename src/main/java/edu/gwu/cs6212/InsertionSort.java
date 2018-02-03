package edu.gwu.cs6212;

public class InsertionSort {

	public static void main(String[] args) {

		int[] nValues = { 10000, 20000, 40000, 60000, 80000, 100000 };

		for (int n : nValues) {
			double[] inputArray = new double[n];
			for (int i = 0; i < inputArray.length; i++) {
				inputArray[i] = Math.random() * 100000;
			}

			double t1 = System.currentTimeMillis();
			sort(inputArray);
			double t2 = System.currentTimeMillis();

			confirmSorted(inputArray);
			System.out.println(n + "," + (t2 - t1));
		}
	}

	private static void confirmSorted(double[] inputArray) {
		for (int i = 0; i < inputArray.length - 1; i++) {
			if (inputArray[i] > inputArray[i + 1]) {
				throw new IllegalArgumentException("Array not sorted");
			}
		}
	}

	public static void sort(double[] inputArray) {
		int n = inputArray.length;
		for (int j = 1; j <= n - 1; j++) {
			double key = inputArray[j];
			// A[j] is added in the sorted sequence A[1.. j-1]
			int i = j - 1;
			while ((i >= 0) && (inputArray[i] > key)) {
				inputArray[i + 1] = inputArray[i];
				i = i - 1;
			}
			inputArray[i + 1] = key;
		}

	}
}
