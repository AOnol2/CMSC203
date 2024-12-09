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

public class BeverageTestStudent {

    @Test
    public void testEquality() {
        Beverage beverage1 = new Coffee("Latte", Size.SMALL, true, false);
        Beverage beverage2 = new Coffee("Latte", Size.SMALL, true, false);
        assertEquals(beverage1, beverage2);
    }

    @Test
    public void testBasePrice() {
        Beverage beverage = new Coffee("Espresso", Size.SMALL, false, false);
        assertEquals(2.0, beverage.getBasePrice(), 0.01);
    }
}