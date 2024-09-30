package Lab1;

import java.util.Scanner;
public class MovieDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String yesOrNo;
		
		//user input movie name
		do {
		Movie movie = new Movie();
		System.out.println("\nEnter the name of the movie: ");
		String movieTitle = scanner.nextLine();
		movie.setTitle(movieTitle);
		
		//user input movie rating
		System.out.println("\nEnter the rating of the movie: ");
		String movieRating = scanner.nextLine();
		movie.setRating(movieRating);
		
		//user input tickets sold
		System.out.println("\nEnter the number of tickets sold for this movie: ");
		int ticketsSold = scanner.nextInt();
		movie.setSoldTickets(ticketsSold);
		
		//display user inputs
		System.out.println( "\n" + movieTitle + " " + "(" + movieRating + "): Tickets sold: " + ticketsSold );
		
		
		scanner.nextLine();
		//ask user to repeat loop
		System.out.println("\nDo you want to enter another movie? (y or n): ");
		yesOrNo = scanner.nextLine();
		} 
		
		//ask user yes or no
		while (yesOrNo.equalsIgnoreCase("y"));
			if (yesOrNo.equalsIgnoreCase("n")){{
			System.out.println("\nGoodbye!");
		}
		}
	}

}
