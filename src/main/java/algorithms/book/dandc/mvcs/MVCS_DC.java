package algorithms.book.dandc.mvcs;

/** Solves MVCS problem using D&C, in n log n time. */
public class MVCS_DC {

    public int findMax(int[] a, int leftIndex, int rightIndex) {

        // Base Case
        if (leftIndex >= rightIndex - 1) {
            return Math.max(a[leftIndex] + a[rightIndex], Math.max(a[leftIndex], a[rightIndex]));
        }

        return 0;

    }
}
