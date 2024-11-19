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
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;

public class TwoDimRaggedArrayUtilityTestStudent {

    @Test
    public void testGetTotal() {
        double[][] array = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0}
        };

        double expectedTotal = 36.0;
        assertEquals(expectedTotal, TwoDimRaggedArrayUtility.getTotal(array), 0.0001);
    }

    @Test
    public void testGetAverage() {
        double[][] array = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0}
        };

        double expectedAverage = 4.5; // Total (36) / Count (8)
        assertEquals(expectedAverage, TwoDimRaggedArrayUtility.getAverage(array), 0.0001);
    }

    @Test
    public void testGetHighestInRow() {
        double[][] array = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0}
        };

        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(array, 0), 0.0001);
    }

    @Test
    public void testGetLowestInRow() {
        double[][] array = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0}
        };

        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(array, 0), 0.0001);
    }

    @Test
    public void testWriteToFileAndReadFile() throws FileNotFoundException {
        File testFile = new File("test_output.txt");
        double[][] array = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0}
        };

        // Write to file
        TwoDimRaggedArrayUtility.writeToFile(array, testFile);

        // Read from file
        double[][] result = TwoDimRaggedArrayUtility.readFile(testFile);

        // Validate content
        assertEquals(array.length, result.length);
        for (int i = 0; i < array.length; i++) {
            assertArrayEquals(array[i], result[i], 0.0001);
        }
    }

    @Test
    public void testGetColumnTotal() {
        double[][] array = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0}
        };

        double expectedTotal = 14.0; // Column 1: 2 + 5 + 4
        assertEquals(expectedTotal, TwoDimRaggedArrayUtility.getColumnTotal(array, 1), 0.0001);
    }

    @Test
    public void testGetLowestInColumn() {
        double[][] array = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0}
        };

        double expectedLowest = 2.0; // Lowest in column 1
        assertEquals(expectedLowest, TwoDimRaggedArrayUtility.getLowestInColumn(array, 1), 0.0001);
    }

    @Test
    public void testGetHighestInColumn() {
        double[][] array = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0}
        };

        double expectedHighest = 7.0; // Highest in column 1
        assertEquals(expectedHighest, TwoDimRaggedArrayUtility.getHighestInColumn(array, 1), 0.0001);
    }
}