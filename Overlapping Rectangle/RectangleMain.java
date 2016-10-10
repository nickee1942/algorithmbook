/**
 * Created by yichenzhou on 10/5/16.
 */

import java.util.Scanner;

public class RectangleMain {
    public static void main(String args[]) {
        int[] maxScales = new int[6];
        int counter = 0;
        // We can make input as [100, 1000, 10000, 100000, 1000000, 10000000],
        // which means 100 rectangles, 1000 rectangles, etc.
        System.out.println("Please type at most 6 count scales for each rectangle array:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println("Type count scale for " + (i+1) + ":");
            maxScales[i] = Integer.parseInt(scanner.nextLine());
            counter++;
        }

        int[] inputScales = new int[counter];
        for (int i = 0; i < counter; i++) {
            inputScales[i] = maxScales[i];
        }

        RectangleOverlapSolver ros = new RectangleOverlapSolver(inputScales);
        ros.toRun();
    }
}
