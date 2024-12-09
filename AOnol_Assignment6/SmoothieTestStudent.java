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

public class SmoothieTestStudent {

    @Test
    public void testCalcPrice() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.LARGE, 3, true);
        assertEquals(7.0, smoothie.calcPrice(), 0.01); // Base price + large size + fruits + protein
    }

    @Test
    public void testToString() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.LARGE, 3, true);
        String expected = "Berry Blast, LARGE, fruits: 3, protein, price: $7.0";
        assertEquals(expected, smoothie.toString());
    }

    @Test
    public void testEquals() {
        Smoothie smoothie1 = new Smoothie("Tropical Twist", Size.SMALL, 2, false);
        Smoothie smoothie2 = new Smoothie("Tropical Twist", Size.SMALL, 2, false);
        assertTrue(smoothie1.equals(smoothie2));
    }
}