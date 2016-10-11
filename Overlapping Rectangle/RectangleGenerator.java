/**
 * Created by yichenzhou on 10/6/16.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class RectangleGenerator {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < count; i++) {
            double topX = Math.random() * count + 1;
            double topY = Math.random() * count + 1;
            double bottomX = Math.random() * count * 2 + (topX + 1);
            double bottomY = Math.random() * topY - 1;
            assert Double.parseDouble(df.format(topX)) < Double.parseDouble(df.format(bottomX));
            assert Double.parseDouble(df.format(bottomY)) < Double.parseDouble(df.format(topY));
            System.out.println("[" + df.format(topX) + " " + df.format(topY) + " " + df.format(bottomX) + " " + df.format(bottomY) + "]");
        }
    }
}
