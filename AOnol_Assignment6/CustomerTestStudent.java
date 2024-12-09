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

public class CustomerTestStudent {

    @Test
    public void testGettersAndSetters() {
        Customer customer = new Customer("Alice", 30);
        assertEquals("Alice", customer.getName());
        assertEquals(30, customer.getAge());

        customer.setName("Bob");
        customer.setAge(25);
        assertEquals("Bob", customer.getName());
        assertEquals(25, customer.getAge());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("Alice", 30);
        String expected = "Name: Alice, Age: 30";
        assertEquals(expected, customer.toString());
    }
}