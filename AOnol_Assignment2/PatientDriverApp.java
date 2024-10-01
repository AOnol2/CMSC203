/*
 * Class: CMSC203 CRN 32488
 * Instructor: Dr. Aygun
 * Description: Write a program that gathers patient information, then displays it
 * Due: 09/30/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Ata Onol
*/
import java.util.Scanner;

public class PatientDriverApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for Patient personal information
        System.out.println("Enter patient info:");
        System.out.print("First Name: ");
        String firstName = input.nextLine();
        
        System.out.print("Middle Name: ");
        
       String middleName = input.nextLine();
       
       System.out.print("Last Name: ");
        String lastName = input.nextLine();
       
        System.out.print("Street Address: ");
        String streetAddress = input.nextLine();
        
        System.out.print("City: ");
        String city = input.nextLine();
        
        System.out.print("State: ");
        String state = input.nextLine();
        
        System.out.print("ZIP Code: ");
        String zip = input.nextLine();
        
        System.out.print("Phone Number: ");
        String phoneNumber = input.nextLine();
        
        System.out.print("Emergency Contact Name: ");
        String emergencyContactName = input.nextLine();
        
        System.out.print("Emergency Contact Phone Number: ");
        String emergencyContactPhoneNumber = input.nextLine();
        
        System.out.print("Student name: " );
        String studentName = input.nextLine();
        
        System.out.print("MC#: ");
        String mcMNumber = input.nextLine();
        
        System.out.print("Due Date: ");
        String dueDate = input.nextLine();

        // Create Patient object
        Patient patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zip, phoneNumber, emergencyContactName, emergencyContactPhoneNumber);

        // Create and input Procedure objects
        Procedure[] procedures = new Procedure[3];

        for (int i = 0; i < procedures.length; i++) {
            System.out.println("\nPlease enter details for procedure " + (i + 1) + ":");
            System.out.print("Procedure Name: ");
            String procedureName = input.nextLine();
        
            System.out.print("What is the procedure date (MM/DD/YYYY): ");
            String procedureDate = input.nextLine();
            
            System.out.print("Practitioner Name: ");
            String practitionerName = input.nextLine();
            
            System.out.print("Charge = ");
            double charge = input.nextDouble();
            input.nextLine(); // Consume newline

            // Create Procedure object with input values
            procedures[i] = new Procedure(procedureName, procedureDate, practitionerName, charge);
        }

        // Display patient information
        displayPatient(patient);

        // Display procedure information
        for (Procedure procedure : procedures) {
            displayProcedure(procedure);
        }

        // Display total charges
        double totalCharges = calculateTotalCharges(procedures);
        System.out.println("\nTotal Charges = $" + String.format("%,.2f", totalCharges));

 

        // Display Student Information at the end
        System.out.println("\nStudent Name: " + studentName);
        System.out.println("MC#: " + mcMNumber);
        System.out.println("Due Date: " + dueDate);

        input.close();
    }

    // Method to display patient information
    public static void displayPatient(Patient patient) {
        System.out.println("\nPatient Information:");
        System.out.println(patient.toString());
    }

    // Method to display procedure information
    public static void displayProcedure(Procedure procedure) {
      
        System.out.println(procedure.toString());
    }

    // Method to calculate total charges
    public static double calculateTotalCharges(Procedure[] procedures) {
        double total = 0;
        for (Procedure procedure : procedures) {
            total += procedure.getCharges();
        }
        return total;
    }
}

