/*
 * Class: CMSC203 CRN 32488
 * Instructor: Dr. Aygun
 * Description: Write a program that gathers patient information, then displays it
 * Due: 09/30/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Ata Onol
*/
public class Patient {

    // Fields that store patient's basic info
    private String firstName, middleName, lastName;
    private String streetAddress, city, state, zip;
    private String phoneNumber;
    private String emergencyContactName, emergencyContactPhoneNumber;

    // Default constructor initializing fields with empty values
    public Patient() {
        this("", "", "", "", "", "", "", "", "", "");
    }

    // Constructor that initializes name only
    public Patient(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "", "", "", "", "", "", "");
    }

    // Constructor that initializes all patient info
    public Patient(String firstName, String middleName, String lastName, String streetAddress, 
                   String city, String state, String zip, String phoneNumber, 
                   String emergencyContactName, String emergencyContactPhoneNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }

    // Getters and Setters
    public String getFirstName() { 
    	return firstName; 
    }
    public void setFirstName(String firstName) { 
    	this.firstName = firstName; 
    	}

    public String getMiddleName() {
    	return middleName; 
    	}
    public void setMiddleName(String middleName) {
    	this.middleName = middleName; 
    }

    public String getLastName() {
    	return lastName; 
    	}
    public void setLastName(String lastName) {
    	this.lastName = lastName; 
    	}

    public String getStreetAddress() {
    	return streetAddress; 
    	}
    public void setStreetAddress(String streetAddress) {
    	this.streetAddress = streetAddress; 
    	}

    public String getCity() {
    	return city; 
    	}
    public void setCity(String city) { 
    	this.city = city; 
    	}

    public String getState() {
    	return state; 
    	}
    public void setState(String state) {
    	this.state = state; 
    	}

    public String getZip() {
    	return zip; 
    	}
    public void setZip(String zip) {
    	this.zip = zip; 
    	}

    public String getPhoneNumber() {
    	return phoneNumber; 
    	}
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber; 
    	}

    public String getEmergencyContactName() {
    	return emergencyContactName; 
    	}
    public void setEmergencyContactName(String emergencyContactName) { 
    	this.emergencyContactName = emergencyContactName; 
    	}

    public String getEmergencyContactPhoneNumber() {
    	return emergencyContactPhoneNumber; 
    	}
    public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
    	this.emergencyContactPhoneNumber = emergencyContactPhoneNumber; 
    	}

    // Helper methods to build full name, address, and emergency contact info
    public String buildFullName() {
        return String.join(" ", firstName, middleName, lastName).trim();
    }

    public String buildAddress() {
        return String.join(", ", streetAddress, city, state + " " + zip).trim();
    }

    public String buildEmergencyContact() {
        return emergencyContactName + " (" + emergencyContactPhoneNumber + ")";
    }

    // Override the toString method to display all patient info
    @Override
    public String toString() {
        return "     Patient: " + buildFullName() + "\n     Address: " + buildAddress() + "\n     Emergency Contact: " + buildEmergencyContact();
    }
}
