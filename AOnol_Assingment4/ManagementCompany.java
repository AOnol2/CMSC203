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
 * Manages a set of properties and includes functionality to add properties,
 * calculate total rent, find the highest rent property, and manage a plot boundary.
 */
public class ManagementCompany {
    private String name;
    private String taxId;
    private double managementFeePercentage;
/**
 * Define the max number of properties allowed, as well as
 * the width, and depth of the company plot
 */
    private static final int MAX_PROPERTY = 5;  
    private static final int MGMT_WIDTH = 10;   
    private static final int MGMT_DEPTH = 10;   
/**
 * Set the array to hold properties, and the plot for the management company,
 * as well as creating a tracker to count the number of properties added.
 */
    private Property[] properties; 
    private Plot plot;             
    private int numberOfProperties; 

    // Constructor with company details
    public ManagementCompany(String name, String taxId, double managementFeePercentage) {
        this.name = name;
        this.taxId = taxId;
        this.managementFeePercentage = managementFeePercentage;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }
    
    // Default constructor, initializes plot with default values
    public ManagementCompany() {
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    // Getter methods
    public String getName() { 
    	return name; 
    	}
    public Plot getPlot() { 
    	return plot; 
    	}
    public String getTaxId() { 
    	return taxId; 
    	}
    public int getMAX_PROPERTY() { 
    	return MAX_PROPERTY;
    	}
    public double getManagementFeePercentage() { return
    		managementFeePercentage;
    }

    // Setter methods
    public void setName(String name) { 
    	this.name = name; 
    	}
    public void setTaxId(String taxId) { 
    	this.taxId = taxId; 
    	}
    public void setManagementFeePercentage(double managementFeePercentage) { 
    	this.managementFeePercentage = managementFeePercentage; 
    	}

    /** Adds a property if space allows and plots don’t overlap, and
     * and check for out of bounds plot.
    */
    public int addProperty(Property property) {
        if (isPropertiesFull()) return -1;
        if (property == null) return -2; 
        if (!plot.encompasses(property.getPlot())) return -3;
        
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) return -4; // Overlaps another plot
        }

        properties[numberOfProperties] = property;
        numberOfProperties++;
        return numberOfProperties - 1; 
    }

    // Calculates the total rent for all properties
    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    // Returns the property with the highest rent
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;

        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    // Removes the last added property
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    // Checks if the properties array is full
    public boolean isPropertiesFull() {
        return numberOfProperties == MAX_PROPERTY;
    }

    // Returns the number of properties currently managed
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    // Validates if the management fee is within 0-100%
    public boolean isManagementFeeValid() {
        return managementFeePercentage >= 0 && managementFeePercentage <= 100;
    }

    // Provides a summary of the company's properties and total management fee
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxId).append("\n");
        sb.append("______________________________________________________\n");

        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        
        sb.append("______________________________________________________\n\n");
        
        double totalManagementFee = getTotalRent() * (managementFeePercentage / 100);
        sb.append("total management Fee: ").append(String.format("%.2f", totalManagementFee));
        
        return sb.toString();
    }
}