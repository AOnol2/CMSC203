/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #6
 * Description: This project is a beverage shop management system that processes customer orders, calculates prices with customizable options.
 * Due: 12/08/2024
 * Platform/compiler: Eclipse
 * Author: Ata Onol
 */
public class Customer {
    private String name;
    private int age;

    // constructor to initialize customer
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // copy constructor
    public Customer(Customer customer) {
        this.name = customer.name;
        this.age = customer.age;
    }

    // get the customer's name
    public String getName() {
        return name;
    }

    // set the customer's name
    public void setName(String name) {
        this.name = name;
    }

    // get the customer's age
    public int getAge() {
        return age;
    }

    // set the customer's age
    public void setAge(int age) {
        this.age = age;
    }

    // toString representation of customer
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}