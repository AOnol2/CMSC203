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

public class CoffeeTestStudent {

    @Test
    public void testCalcPrice() {
        Coffee coffee = new Coffee("Espresso", Size.LARGE, true, true);
        assertEquals(5.0, coffee.calcPrice(), 0.01); // Base price + large size + extra shot + extra syrup
    }

    @Test
    public void testToString() {
        Coffee coffee = new Coffee("Espresso", Size.LARGE, true, true);
        String expected = "Espresso, LARGE, extra shot, extra syrup, price: $5.0";
        assertEquals(expected, coffee.toString());
    }

    @Test
    public void testEquals() {
        Coffee coffee1 = new Coffee("Cappuccino", Size.SMALL, false, false);
        Coffee coffee2 = new Coffee("Cappuccino", Size.SMALL, false, false);
        assertTrue(coffee1.equals(coffee2));
    }
}