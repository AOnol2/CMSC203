/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #6
 * Description: This project is a beverage shop management system that processes customer orders, calculates prices with customizable options.
 * Due: 12/08/2024
 * Platform/compiler: Eclipse
 * Author: Ata Onol
 */
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double SHOT_PRICE = 0.5;
    private final double SYRUP_PRICE = 0.5;

    // constructor to initialize coffee object
    public Coffee(String coffeeName, Size size, boolean extraShot, boolean extraSyrup) {
        super(coffeeName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    // check if extra shot is added
    public boolean hasExtraShot() {
        return extraShot;
    }

    // set extra shot
    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    // check if extra syrup is added
    public boolean hasExtraSyrup() {
        return extraSyrup;
    }

    // set extra syrup
    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }

    // calculate price for coffee
    @Override
    public double calcPrice() {
        double price = super.getBasePrice();

        // add size-based upcharges
        if (getSize() == Size.MEDIUM) {
            price += super.getSizeUp();
        } else if (getSize() == Size.LARGE) {
            price += 2 * super.getSizeUp();
        }

        // add extras
        if (extraShot) {
            price += SHOT_PRICE;
        }
        if (extraSyrup) {
            price += SYRUP_PRICE;
        }

        return price;
    }

    // toString representation of coffee
    @Override
    public String toString() {
        String details = getBevName() + ", " + getSize();
        if (extraShot) {
            details += ", extra shot";
        }
        if (extraSyrup) {
            details += ", extra syrup";
        }
        return details + ", price: $" + calcPrice();
    }
}