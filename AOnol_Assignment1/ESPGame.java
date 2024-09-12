/*
 * Class: CMSC203 CRN 32488
 * Instructor: Dr. Aygun
 * Description: Write a program that tests your ESP (extrasensory perception) using colors.
 * Due: 09/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Ata Onol
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

class ESPGame {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		//Read the user's input for the required filename
		Scanner input = new Scanner(System.in);
		
		//Welcome message
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		
		//Prompt and ask user for the required filename
		System.out.print("Enter the filename: ");
		String colorsFile = input.nextLine();
		
		//Open colorsFile from user input
		File file = new File(colorsFile);
		Scanner fileScanner = new Scanner(file);
		
		//Display all 16 colors from colors.txt
		System.out.println("There are sixteen colors from the file:");
		
		while (fileScanner.hasNextLine()) {
			String colors = fileScanner.nextLine();
			System.out.println(colors);
		
		}
		//assign variables for storing the colors names based off the numbers next to them in the colors.txt
		final String COLOR_1 = "black";
        final String COLOR_2 = "white";
        final String COLOR_3 = "gray";
        final String COLOR_4 = "silver";
        final String COLOR_5 = "maroon";
        final String COLOR_6 = "red";
        final String COLOR_7 = "purple";
        final String COLOR_8 = "fuchsia";
        final String COLOR_9 = "green";
        final String COLOR_10 = "lime";
        final String COLOR_11 = "olive";
        final String COLOR_12 = "yellow";
        final String COLOR_13 = "navy";
        final String COLOR_14 = "blue";
        final String COLOR_15 = "teal";
        final String COLOR_16 = "aqua";
        
        Random random = new Random();
        
        //assign variable to track the number of correct guesses
        int numCorrectGuess = 0;
        
        //Make loop to start the game for 3 rounds
        for (int round = 1; round <=3; round++) {
        	System.out.println("\nRound " + round + ":");
        	System.out.println("\nI am thinking of a color.");
        	System.out.println("Is it one from the list of colors above?");
        	
        	//generate random color from numbers between 1-16 
        	int randomNum = random.nextInt(16) + 1;
        	String randomColor = "";
        	
        	switch (randomNum) {
        	case 1: randomColor = COLOR_1; break;
        	case 2: randomColor = COLOR_2; break;
            case 3: randomColor = COLOR_3; break;
            case 4: randomColor = COLOR_4; break;
            case 5: randomColor = COLOR_5; break;
            case 6: randomColor = COLOR_6; break;
            case 7: randomColor = COLOR_7; break;
            case 8: randomColor = COLOR_8; break;
            case 9: randomColor = COLOR_9; break;
            case 10: randomColor = COLOR_10; break;
            case 11: randomColor = COLOR_11; break;
            case 12: randomColor = COLOR_12; break;
            case 13: randomColor = COLOR_13; break;
            case 14: randomColor = COLOR_14; break;
            case 15: randomColor = COLOR_15; break;
            case 16: randomColor = COLOR_16; break;
        	}
       
        	//Prompt user to guess the color
        	System.out.print("Enter your guess: ");
        	String guess = input.nextLine();
        	
        	//Compare the guess with the random selected color (with case insensitive)
        	if (guess.equalsIgnoreCase(randomColor)) {
        		System.out.println("\nCorrect!");
        		System.out.println("I was also thinking of " + randomColor + ".");
        		numCorrectGuess++;
        		
        }
        	else {
        		System.out.println("\nIncorrect.");
        		System.out.println("I was thinking of " + randomColor + ".");
        	}
        }
        //Display end of game prompts and score
        System.out.println("\nGame Over!");
        System.out.println("You guessed " + numCorrectGuess + " out of 3 colors correctly.");
        	
        
        //User information
        System.out.print("\nEnter your name: ");
        String name = input.nextLine();
        
        System.out.print("Describe yourself: ");
        String description = input.nextLine();
        
        System.out.print("Due Date: ");
        String assignmentDueDate = input.nextLine();
        
        //Display user information
        System.out.println("User Name: " + name);
        System.out.println("User description: " + description);
        System.out.println("Due Date: " + assignmentDueDate);
        }
	}