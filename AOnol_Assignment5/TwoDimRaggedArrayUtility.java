/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #5
 * Description: (Create a utility class that manipulates a two-dimensional ragged array of doubles. This utility class will be used to create a Sales Report for Retail District #5)
 * Due: 11/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * Print your Name here: Ata Onol
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    // Reads data from a file and creates a ragged 2D array.
    public static double[][] readFile(File file) throws FileNotFoundException {
        int totalRows = 0;

        // First scan to count rows
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                totalRows++;
                scanner.nextLine(); // Move to next line
            }
        }

        double[][] resultArray = new double[totalRows][];
        int row = 0;

        // Second scan to populate array
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] rowValues = scanner.nextLine().split(" ");
                double[] parsedRow = new double[rowValues.length];
                for (int i = 0; i < rowValues.length; i++) {
                    parsedRow[i] = Double.parseDouble(rowValues[i]);
                }
                resultArray[row] = parsedRow;
                row++;
            }
        }

        return resultArray;
    }

    // Writes a 2D ragged array to a file.
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (double[] row : data) {
                for (double value : row) {
                    writer.print(value + " ");
                }
                writer.println(); // Newline after each row
            }
        }
    }

    // Computes the sum of all elements in the 2D array.
    public static double getTotal(double[][] array) {
        double sum = 0.0;
        for (double[] row : array) {
            for (double value : row) {
                sum += value;
            }
        }
        return sum;
    }

    // Computes the average value of all elements.
    public static double getAverage(double[][] array) {
        double sum = 0.0;
        int count = 0;

        for (double[] row : array) {
            for (double value : row) {
                sum += value;
                count++;
            }
        }

        return count > 0 ? sum / count : 0.0;
    }

    // Computes the total of a specific row.
    public static double getRowTotal(double[][] array, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= array.length) return 0.0;

        double sum = 0.0;
        for (double value : array[rowIndex]) {
            sum += value;
        }
        return sum;
    }

    // Computes the total of a specific column.
    public static double getColumnTotal(double[][] array, int colIndex) {
        double sum = 0.0;
        for (double[] row : array) {
            if (colIndex >= 0 && colIndex < row.length) {
                sum += row[colIndex];
            }
        }
        return sum;
    }

    // Finds the highest value in a row.
    public static double getHighestInRow(double[][] array, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= array.length) return Double.NEGATIVE_INFINITY;

        double highest = array[rowIndex][0];
        for (double value : array[rowIndex]) {
            if (value > highest) highest = value;
        }
        return highest;
    }

    // Finds the lowest value in a row.
    public static double getLowestInRow(double[][] array, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= array.length) {
            throw new IllegalArgumentException("Invalid row index: " + rowIndex);
        }

        double lowest = array[rowIndex][0];
        for (double value : array[rowIndex]) {
            if (value < lowest) lowest = value;
        }
        return lowest;
    }

    // Finds the index of the highest value in a row.
    public static int getHighestInRowIndex(double[][] array, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= array.length) return -1;

        int index = 0;
        double highest = array[rowIndex][0];
        for (int i = 1; i < array[rowIndex].length; i++) {
            if (array[rowIndex][i] > highest) {
                highest = array[rowIndex][i];
                index = i;
            }
        }
        return index;
    }

    // Finds the highest value in a column.
    public static double getHighestInColumn(double[][] array, int colIndex) {
        double highest = Double.NEGATIVE_INFINITY;

        for (double[] row : array) {
            if (colIndex >= 0 && colIndex < row.length) {
                highest = Math.max(highest, row[colIndex]);
            }
        }
        return highest;
    }

    // Finds the lowest value in a column.
    public static double getLowestInColumn(double[][] array, int colIndex) {
        double lowest = Double.POSITIVE_INFINITY;

        for (double[] row : array) {
            if (colIndex >= 0 && colIndex < row.length) {
                lowest = Math.min(lowest, row[colIndex]);
            }
        }
        return lowest;
    }
}