/*
 * Class: CMSC203 CRN 32488
 * Instructor: Dr. Aygun
 * Description: Write a program that gathers patient information, then displays it
 * Due: 09/30/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Ata Onol
*/
public class Procedure {

    // Fields for procedure details
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double charges;

    // Default constructor - sets fields to default values
    public Procedure() {
        this.procedureName = "";
        this.procedureDate = "";
        this.practitionerName = "";
        this.charges = 0.0;
    }

    // Constructor that accepts procedure name and date
    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
    }

    // Constructor that accepts all procedure details
    public Procedure(String procedureName, String procedureDate, String practitionerName, double charges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.charges = charges;
    }

    // Accessor and Mutator methods
    public String getProcedureName() { 
    	return procedureName; 
    	}
    public void setProcedureName(String procedureName) { 
    	this.procedureName = procedureName; 
    	}
    public String getProcedureDate() {
    	return procedureDate; 
    	}
    public void setProcedureDate(String procedureDate) { 
    	this.procedureDate = procedureDate; 
    	}

    public String getPractitionerName() {
    	return practitionerName; }
    public void setPractitionerName(String practitionerName) {
    	this.practitionerName = practitionerName; }

    public double getCharges() {
    	return charges; }
    public void setCharges(double charges) {
    	this.charges = charges; }

    // Override the toString method to display all procedure info
    @Override
    public String toString() {
        return "---------------------------------------\n" + "          Procedure: " + procedureName + "\n" + "         Procedure Date: " + procedureDate + "\n" + "          Practitioner: " + practitionerName + "\n" + "          Charges: $" + String.format("%.2f", charges);
    }
}
