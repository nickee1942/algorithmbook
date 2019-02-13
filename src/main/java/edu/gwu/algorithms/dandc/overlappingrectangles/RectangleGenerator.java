package edu.gwu.algorithms.dandc.overlappingrectangles;

import java.io.FileWriter;
import java.io.IOException;

/** Generates sample rectangle data. */
public class RectangleGenerator {

    public static void main(String args[]) throws IOException {
        int count = Integer.parseInt(args[0]);
        int maxLength = 1000;
        int maxHeight = 1000;
        FileWriter fileWriter = new FileWriter(args[1]);
        String newLine = System.getProperty("line.separator");
        for (int i = 0; i < count; i++) {
            int topX = (int) (Math.random() * count + 1);
            int topY = (int) (Math.random() * count + 1);
            Point topLeft = new Point(topX, topY);
            int widthX = (int) (Math.random() * maxLength);
            int heightY = (int) (Math.random() * maxHeight);
            Point bottomRight = new Point(topX + widthX, topY - heightY);
            Rectangle rectangle = new Rectangle(topLeft, bottomRight);
            fileWriter.write(rectangle + newLine);
        }
        fileWriter.close();
    }
}
