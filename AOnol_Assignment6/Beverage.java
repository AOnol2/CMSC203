/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #6
 * Description: This project is a beverage shop management system that processes customer orders, calculates prices with customizable options.
 * Due: 12/08/2024
 * Platform/compiler: Eclipse
 * Author: Ata Onol
 */
public abstract class Beverage {
    private String name;
    private Type type;
    private Size size;
    private final double PRICE = 2.0;
    private final double SIZE_UP = 1.0;

    // initialize beverage with its name, type, and size
    public Beverage(String bevName, Type type, Size size) {
        this.name = bevName;
        this.type = type;
        this.size = size;
    }

    // calculate price (must be implemented by subclasses)
    public abstract double calcPrice();

    // get the name of the beverage
    public String getBevName() {
        return name;
    }

    // set a new name for the beverage
    public void setBevName(String bevName) {
        this.name = bevName;
    }

    // get the type of beverage
    public Type getType() {
        return type;
    }

    // set a new type for the beverage
    public void setType(Type type) {
        this.type = type;
    }

    // get the size of the beverage
    public Size getSize() {
        return size;
    }

    // set a new size for the beverage
    public void setSize(Size size) {
        this.size = size;
    }

    // get the base price of a beverage
    public double getBasePrice() {
        return PRICE;
    }

    // get the price increase for larger sizes
    public double getSizeUp() {
        return SIZE_UP;
    }

    // string representation of a beverage
    @Override
    public String toString() {
        return name + ", " + size;
    }

    // check if two beverages are equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Beverage)) return false;
        Beverage other = (Beverage) obj;
        return name.equals(other.getBevName()) && type == other.getType() && size == other.getSize();
    }
}