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

public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus() {
        double[][] salesData = {
            {1000, 2000, 3000},
            {4000, 5000, 6000},
            {7000, 8000, 9000}
        };
     // Each store gets one high and one low bonus
        double[] expectedBonuses = {3000.0, 6000.0, 15000.0}; 
        assertArrayEquals(expectedBonuses, HolidayBonus.calculateHolidayBonus(salesData), 0.0001);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] salesData = {
            {1000, 2000, 3000},
            {4000, 5000, 6000},
            {7000, 8000, 9000}
        };
     // Sum of all bonuses
        double expectedTotal = 24000.0; 
        assertEquals(expectedTotal, HolidayBonus.calculateTotalHolidayBonus(salesData), 0.0001);
    }

    @Test
    public void testFindHighestStore() {
        double[][] salesData = {
            {1000, 2000, 3000},
            {4000, 5000, 6000},
            {7000, 8000, 9000}
        };
     // 9000 is the highest in column 2
        assertEquals(2, HolidayBonus.findHighestStore(salesData, 2)); 
    }

    @Test
    public void testFindLowestStore() {
        double[][] salesData = {
            {1000, 2000, 3000},
            {4000, 5000, 6000},
            {7000, 8000, 9000}
        };
     // 1000 is the lowest in column 0
        assertEquals(0, HolidayBonus.findLowestStore(salesData, 0)); // 1000 is the lowest in column 0
    }

    @Test
    public void testCalculateTotalStoreBonus() {
        double[] bonuses = {2000.0, 5000.0, 7000.0};
     // Total of bonuses
        double expectedTotal = 14000.0; // Total of bonuses
        assertEquals(expectedTotal, HolidayBonus.calculateTotalStoreBonus(bonuses), 0.0001);
    }
}