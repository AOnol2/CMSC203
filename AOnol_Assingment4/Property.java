/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #4
 * Description: (Write an application that lets the user create a management 
 * company and add the properties managed by the company to its list.)
 * Due: 10/28/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * Print your Name here: Ata Onol
 */
/**
 * The Property class encapsulates the details of a real estate property.
 * Each property has a name, location (city), owner, rental amount, and
 * an associated plot of land. This class is designed to interact with
 * the Plot class for spatial representation and with the ManagementCompany
 * class for organizational management.
 */
public class Property {

    private String propertyName; // Name of the property
    private String city; // City where property is located
    private double rentAmount; // Rent amount
    private String owner; // Owner of the property
    private Plot plot; // Plot of the property

    // Default constructor
    public Property() {
        propertyName = "";
        city = "";
        rentAmount = 0.0;
        owner = "";
        plot = new Plot();
    }

    // Main constructor with all fields
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(); // Default plot
    }

    // Constructor with all fields, including plot details
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth); // Custom plot
    }

    // Copy constructor
    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);
    }

    // Accessors and Mutators
    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public double getRentAmount() { return rentAmount; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public Plot getPlot() { return plot; }
    public void setPlot(int x, int y, int width, int depth) { this.plot = new Plot(x, y, width, depth); }

    // Returns a formatted string for the property
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}