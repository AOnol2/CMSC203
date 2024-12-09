/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #6
 * Description: This project is a beverage shop management system that processes customer orders, calculates prices with customizable options.
 * Due: 12/08/2024
 * Platform/compiler: Eclipse
 * Author: Ata Onol
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlcoholTestStudent {

    private Alcohol smallAlcohol, mediumAlcohol, largeAlcohol;

    @BeforeEach
    public void setUp() {
        smallAlcohol = new Alcohol("Alcohol", Size.SMALL, false);
        mediumAlcohol = new Alcohol("Alcohol", Size.MEDIUM, false);
        largeAlcohol = new Alcohol("Alcohol", Size.LARGE, true);
    }

    @Test
    public void testConstructorAndToString() {
        assertNotNull(smallAlcohol);
        assertEquals("Alcohol, SMALL, price: $2.0", smallAlcohol.toString());
        assertEquals("Alcohol, MEDIUM, price: $3.0", mediumAlcohol.toString());
        assertEquals("Alcohol, LARGE, weekend fee, price: $4.6", largeAlcohol.toString());
    }

    @Test
    public void testCalcPriceAndWeekend() {
        assertEquals(2.0, smallAlcohol.calcPrice(), 0.01);
        assertEquals(3.0, mediumAlcohol.calcPrice(), 0.01);
        assertEquals(4.6, largeAlcohol.calcPrice(), 0.01);
        assertFalse(smallAlcohol.isWeekend());
        assertTrue(largeAlcohol.isWeekend());
    }
}