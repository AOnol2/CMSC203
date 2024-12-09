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

public class BevShop implements BevShopInterface {
    private int alcoholOrderCount = 0; // track alcohol count
    private int currentIndex = -1; // index of current order
    private List<Order> orderList = new ArrayList<>(); // list of orders

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return alcoholOrderCount < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return alcoholOrderCount;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        if (!isValidTime(time)) {
            throw new IllegalArgumentException("Invalid time for placing order.");
        }
        Customer customer = new Customer(customerName, customerAge);
        Order order = new Order(time, day, customer);
        orderList.add(order);
        currentIndex = orderList.size() - 1;
        alcoholOrderCount = 0; // reset alcohol count for new order
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        orderList.get(currentIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (!isEligibleForMore()) {
            throw new IllegalStateException("Cannot order more than " + MAX_ORDER_FOR_ALCOHOL + " alcoholic beverages.");
        }
        orderList.get(currentIndex).addNewBeverage(bevName, size);
        alcoholOrderCount++;
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (isMaxFruit(numOfFruits)) {
            throw new IllegalArgumentException("Exceeds maximum allowed fruits.");
        }
        orderList.get(currentIndex).addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index == -1) {
            throw new IllegalArgumentException("Order not found.");
        }
        return orderList.get(index).calcOrderTotal();
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orderList) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orderList.size();
    }

    @Override
    public Order getCurrentOrder() {
        return orderList.get(currentIndex);
    }

    @Override
    public Order getOrderAtIndex(int index) {
        return orderList.get(index);
    }

    @Override
    public void sortOrders() {
        Collections.sort(orderList);
    }
}
