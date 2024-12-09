/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #6
 * Description: This project is a beverage shop management system that processes customer orders, calculates prices with customizable options.
 * Due: 12/08/2024
 * Platform/compiler: Eclipse
 * Author: Ata Onol
 */
import java.util.*;

public class Order implements OrderInterface, Comparable<Order> {

    private int orderNumber;
    private int time;
    private Day day;
    private Customer customer;
    private ArrayList<Beverage> beverageList;

    // constructor to create a new order
    public Order(int t, Day d, Customer c) {
        orderNumber = randomNumber();
        time = t;
        day = d;
        customer = c;
        beverageList = new ArrayList<>();
    }

    // generate a random order number
    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(80000) + 10000; // range: 10000 to 89999
    }

    // getter and Setter Methods
    public int getOrderNo() {
        return orderNumber;
    }

    public void setOrderNo(int number) {
        orderNumber = number;
    }

    public int getOrderTime() {
        return time;
    }

    public void setOrderTime(int orderTime) {
        time = orderTime;
    }

    public Day getOrderDay() {
        return day;
    }

    public void setOrderDay(Day orderDay) {
        day = orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // return a deep copy of the customer
    }

    public void setCustomer(Customer customerName) {
        customer = customerName;
    }

    public ArrayList<Beverage> getBeverages() {
        return beverageList;
    }

    // checks if the current day is a weekend
    @Override
    public boolean isWeekend() {
        return day == Day.SATURDAY || day == Day.SUNDAY;
    }

    // retrieves a beverage at the specified index
    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverageList.size()) {
            return beverageList.get(itemNo);
        }
        return null; // return null if index is out of bounds
    }

    // add a coffee to the order
    @Override
    public void addNewBeverage(String bevName, Size bevSize, boolean extraShot, boolean extraSyrup) {
        Coffee coffeeOrder = new Coffee(bevName, bevSize, extraShot, extraSyrup);
        beverageList.add(coffeeOrder);
    }

    // add an alcohol beverage to the order
    @Override
    public void addNewBeverage(String bevName, Size bevSize) {
        boolean weekendFlag = isWeekend(); // check if it's the weekend
        Alcohol alcoholOrder = new Alcohol(bevName, bevSize, weekendFlag); // pass weekend flag
        beverageList.add(alcoholOrder);
    }

    // add a smoothie to the order
    @Override
    public void addNewBeverage(String bevName, Size bevSize, int numOfFruits, boolean addProtein) {
        Smoothie smoothieOrder = new Smoothie(bevName, bevSize, numOfFruits, addProtein);
        beverageList.add(smoothieOrder);
    }

    // calculate the total price for the order
    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage beverage : beverageList) {
            total += beverage.calcPrice(); // includes weekend fee if applicable
        }
        return total;
    }

    // find the number of beverages of a specific type
    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverageList) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }

    // compare orders based on their order number
    @Override
    public int compareTo(Order otherOrder) {
        return Integer.compare(orderNumber, otherOrder.getOrderNo());
    }

    // total items in the order
    public int getTotalItems() {
        return beverageList.size();
    }

    // string representation of the order
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Order number: " + orderNumber + ", " + time + " ," + day + ", " + customer);
        for (Beverage beverage : beverageList) {
            str.append("\n").append(beverage);
        }
        str.append(", total: ").append(calcOrderTotal());
        return str.toString();
    }
}
