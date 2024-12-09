/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #6
 * Description: This project is a beverage shop management system that processes customer orders, calculates prices with customizable options.
 * Due: 12/08/2024
 * Platform/compiler: Eclipse
 * Author: Ata Onol
 */

public class Alcohol extends Beverage {
    private boolean isWeekend;
    private final double WEEKEND_PRICE = 0.6;

    // constructor to initialize Alcohol object
    public Alcohol(String alcoholName, Size size, boolean isWeekend) {
        super(alcoholName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    // getter for isWeekend
    public boolean isWeekend() {
        return isWeekend;
    }

    // setter for isWeekend
    public void setWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    // getter for weekend price
    public double getWeekendPrice() {
        return WEEKEND_PRICE;
    }

    // override toString to include weekend fee if applicable
    @Override
    public String toString() {
        String str = getBevName() + ", " + getSize();
        if (isWeekend) {
            str += ", weekend fee";
        }
        str += ", price: $" + calcPrice();
        return str;
    }

    // override calcPrice to calculate price with size and weekend fee
    @Override
    public double calcPrice() {
        double bevPrice = super.getBasePrice();
        if (super.getSize() == Size.MEDIUM) {
            bevPrice += super.getSizeUp();
        } else if (super.getSize() == Size.LARGE) {
            bevPrice += 2 * super.getSizeUp();
        }
        if (isWeekend) {
            bevPrice += WEEKEND_PRICE;
        }
        return bevPrice;
    }
}
