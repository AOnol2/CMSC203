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

public class OrderTestStudent {

    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order(15, Day.SATURDAY, new Customer("John", 25));
    }

    @Test
    public void testOrderInitialization() {
        assertEquals(15, order.getOrderTime());
        assertEquals(Day.SATURDAY, order.getOrderDay());
        assertEquals("John", order.getCustomer().getName());
        assertTrue(order.isWeekend());
    }

    @Test
    public void testAddBeveragesAndCalculateTotal() {
        order.addNewBeverage("Latte", Size.SMALL, false, false); // coffee
        order.addNewBeverage("Mojito", Size.MEDIUM); // alcohol
        assertEquals(2, order.getTotalItems());
        assertEquals(5.6, order.calcOrderTotal(), 0.01); // total price
    }

    @Test
    public void testBeverageTypeCount() {
        order.addNewBeverage("Latte", Size.SMALL, false, false); // coffee
        order.addNewBeverage("Smoothie", Size.LARGE, 3, true); // smoothie
        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, order.findNumOfBeveType(Type.SMOOTHIE));
    }
}