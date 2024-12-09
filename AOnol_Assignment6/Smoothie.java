/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #6
 * Description: This project is a beverage shop management system that processes customer orders, calculates prices with customizable options.
 * Due: 12/08/2024
 * Platform/compiler: Eclipse
 * Author: Ata Onol
 */
public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    private final double FRUIT_PRICE = 0.5;
    private final double PROTEIN_PRICE = 1.5;

    // constructor to initialize smoothie object
    public Smoothie(String smoothieName, Size size, int numOfFruits, boolean addProtein) {
        super(smoothieName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    // get the number of fruits
    public int getNumOfFruits() {
        return numOfFruits;
    }

    // set the number of fruits
    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    // check if protein is added
    public boolean hasProtein() {
        return addProtein;
    }

    // set protein addition
    public void setProtein(boolean addProtein) {
        this.addProtein = addProtein;
    }

    // calculate price for smoothie
    @Override
    public double calcPrice() {
        double price = super.getBasePrice();

        // add size-based upcharges
        if (getSize() == Size.MEDIUM) {
            price += super.getSizeUp();
        } else if (getSize() == Size.LARGE) {
            price += 2 * super.getSizeUp();
        }

        // add charges for fruits and protein
        price += numOfFruits * FRUIT_PRICE;
        if (addProtein) {
            price += PROTEIN_PRICE;
        }

        return price;
    }

    // toString representation of smoothie
    @Override
    public String toString() {
        String details = getBevName() + ", " + getSize() + ", fruits: " + numOfFruits;
        if (addProtein) {
            details += ", protein";
        }
        return details + ", price: $" + calcPrice();
    }
}