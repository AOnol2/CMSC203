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

public class BevShopTestStudent {

    BevShop shop;

    @BeforeEach
    void setUp() {
        shop = new BevShop();
        shop.startNewOrder(15, Day.SATURDAY, "John", 30);
    }

    @Test
    public void testProcessAlcoholOrder() {
        shop.processAlcoholOrder("Whiskey", Size.SMALL);
        assertEquals(1, shop.getNumOfAlcoholDrink());
    }

    @Test
    public void testIsValidAge() {
        assertTrue(shop.isValidAge(25));
        assertFalse(shop.isValidAge(20));
    }
    
    // base price + medium size + extra shot
    @Test
    public void testTotalMonthlySale() {
        shop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        assertEquals(3.5, shop.totalMonthlySale(), 0.01); 
    }
}