/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #6
 * Description: This project is a beverage shop management system that processes customer orders, calculates prices with customizable options.
 * Due: 12/08/2024
 * Platform/compiler: Eclipse
 * Author: Ata Onol
 */
import java.util.Scanner;

public class BevShopDriverApp {

    public static void main(String[] args) {
        // scanner object to scan user input
        Scanner scanner = new Scanner(System.in);

        // create a BevShop object
        BevShop bevShop = new BevShop();

        // total amount for all orders
        double totalAmountForAllOrders = 0.0;

        // inform user about shop policies
        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");

        // variable to track if user wants to create more orders
        boolean moreOrders = true;

        // start the ordering process
        while (moreOrders) {
            System.out.println("\nStart please a new order:");
            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Would you please enter your age: ");
            int age = Integer.parseInt(scanner.nextLine());
            
            //day of the week
            System.out.println("Please select the day of the week: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, or SUNDAY");
            Day day;
            try {
                day = Day.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid day. Defaulting to MONDAY.");
                day = Day.MONDAY;
            }

            // start a new order
            bevShop.startNewOrder(10, Day.MONDAY, name, age);
            Order currentOrder = bevShop.getCurrentOrder();

            System.out.println("Your Total Order for now is 0.0");

            // alcohol ordering section
            if (age >= 21) {
                int alcoholCount = 0;
                while (alcoholCount < 3) {
                    System.out.print("Would you please add an alcohol drink? (yes/no): ");
                    if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                        
                    	// prompt for alcohol size
                        System.out.println("Choose a size: SMALL, MEDIUM, or LARGE");
                        Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                        // process the alcohol order
                        bevShop.processAlcoholOrder("Generic Alcohol", size);
                        alcoholCount++;
                        System.out.println("The current order of drinks is " + alcoholCount);
                        System.out.println("The Total Price on the Order: " + currentOrder.calcOrderTotal());

                        // check if max alcohol drinks reached
                        if (alcoholCount == 3) {
                            System.out.println("You have a maximum alcohol drinks for this order.");
                        }
                    } else {
                        break;
                    }
                }
            } else {
                System.out.println("Your Age is not appropriate for alcohol drink!!");
            }

            // add other beverages
            boolean addMoreBeverages = true;

            while (addMoreBeverages) {
                System.out.println("Would you please add a COFFEE or a SMOOTHIE to your order? (type 'coffee', 'smoothie', or 'end')");
                String response = scanner.nextLine().toLowerCase();

                switch (response) {
                    case "coffee":
                        // prompt for coffee size and extras
                        System.out.println("Choose a size: SMALL, MEDIUM, or LARGE");
                        Size coffeeSize = Size.valueOf(scanner.nextLine().toUpperCase());
                        System.out.print("Would you like an extra shot? (yes/no): ");
                        boolean extraShot = "yes".equalsIgnoreCase(scanner.nextLine());
                        System.out.print("Would you like extra syrup? (yes/no): ");
                        boolean extraSyrup = "yes".equalsIgnoreCase(scanner.nextLine());

                        // process the coffee order
                        bevShop.processCoffeeOrder("Regular Coffee", coffeeSize, extraShot, extraSyrup);
                        break;

                    case "smoothie":
                        // prompt for smoothie size, fruits, and protein
                        System.out.println("Choose a size: SMALL, MEDIUM, or LARGE");
                        Size smoothieSize = Size.valueOf(scanner.nextLine().toUpperCase());
                        System.out.print("How many fruits would you like to add? (max " + bevShop.getMaxNumOfFruits() + "): ");
                        int numOfFruits = Integer.parseInt(scanner.nextLine());

                        if (bevShop.isMaxFruit(numOfFruits)) {
                            System.out.println("You reached a maximum number of fruits. Cannot add this smoothie.");
                        } else {
                            System.out.print("Would you like to add protein? (yes/no): ");
                            boolean addProtein = "yes".equalsIgnoreCase(scanner.nextLine());

                            // process the smoothie order
                            bevShop.processSmoothieOrder("Berry Smoothie", smoothieSize, numOfFruits, addProtein);
                        }
                        break;

                    case "end":
                        // end the beverage adding process
                        addMoreBeverages = false;
                        break;

                    default:
                        // handle invalid input
                        System.out.println("Invalid option, please choose 'coffee', 'smoothie', or 'end'.");
                        break;
                }

                // print the updated total price if not ending the order
                if (!response.equals("end")) {
                    System.out.println("The Total Price on the Order: " + currentOrder.calcOrderTotal());
                }
            }

            // total items and price of the current order
            System.out.println("Total items on your order: " + currentOrder.getTotalItems());
            System.out.println("The Total Price on the Order: " + currentOrder.calcOrderTotal());

            // add the order total to the monthly total
            totalAmountForAllOrders += currentOrder.calcOrderTotal();

            // print chit
            System.out.println("\n#----------------------------------#");

            // ask the user if they want to start another order
            System.out.print("\nWould you like to start another order? (yes/no): ");
            moreOrders = "yes".equalsIgnoreCase(scanner.nextLine());
        }

        // print the total for all orders
        System.out.println("Total amount for all orders: " + totalAmountForAllOrders);

        // programmer name
        System.out.println("\nProgrammed by: Ata Onol");

        // close the scanner
        scanner.close();
    }
}