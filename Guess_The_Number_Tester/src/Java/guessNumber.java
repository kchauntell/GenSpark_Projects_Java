import java.util.Scanner;
import java.util.Random;

public class guessNumber {
  // Generates the Random number to be Guessed
  public static int getRandomNumber () {
    Random number = new Random();
    return number.nextInt(1, 20);
  }
  // Check input for if user  wants to play again...
  public static String playAgain(String answer) {
    Boolean result = null;
    try {
      switch (answer) {
        case "yes" -> result = true;
        case "no" -> result = false;
        default -> throw new Exception();
      }
    } catch (Exception e) {
      System.out.println("Blank/Invalid Response: Need to answer yes or no." +
          "\nTwo consecutive Invalid/Blank Responses is automatic shut down of Game!");
    }
    return String.valueOf(result);
  }
  //Checks the guesses of the user, and provides response.
  public static String Guesses(int guess, int random) {
    String result;
    if (guess < 1 || guess > 20 ) result = "oor";
    else if(guess > random)  result = "high";
    else if (guess < random) result = "low";
    else result = "correct";
    return result;
  }
  public static void main(String [] args) {
    //Setting random number to be guessed. Imported java.util.Random method.
    int random_num = getRandomNumber();
    //Set the total number of lives to begin with. Will decrement with each guess.
    int count = 6;
    //Sets up User input.
    Scanner guess_the_number = new Scanner(System.in);
    //Introduction to game.
    System.out.println("""
        Welcome to the Guessing Game!
        You get 6 lives.
        Now, let me ask you, what is your name?""");
    //User input initialized for response here.
    String username = guess_the_number.nextLine();
    // try-catch blocks to run responses from user.
    // catch block set for empty string/ blank responses.
    try {
      if (username.equals("")) throw new Exception();
      else System.out.printf("Hello, %s, Let's Play!.%n", username);
    } catch (Exception e) {
      System.out.println("Please Provide a name.");
      //This asks for another entry to user for provide a valid name, once blank response caught.
      username = guess_the_number.nextLine();
      System.out.printf("Hello, %s, Let's Play!.%n", username);
    }
    System.out.println("What do you think the number is, between 1 and 20?");
    while(count != 0) {
      String guess = guess_the_number.nextLine();
      try {
        //This try/catch block will account for a blank entry
        // an empty string cannot be converted into an empty parseInt
        // so taking in account for an empty string is initially running the string input
        // for an empty value. If caught, sends a message and continues the loop until exit.
        try{
          if(guess.equals("")) throw new Exception();
        }catch (Exception e){
          System.out.println("You entered a blank guess");
          //this will continue the while loop run, without exiting the loop.
          continue;
        }
        int numGuess = Integer.parseInt(guess);
        //uses helper class method to use comparison operators: guess vs. random number.
        switch(Guesses(numGuess, random_num)) {
          //Decrements the count, wrong guess, and lets user know guess is greater than random number
          case "high" -> {
            count--;
            System.out.printf("Guessed Too High! Try Again.\nYou have %s lives left.%n", count);
          }
          case "low" -> {
            count--;
            System.out.printf("Guess Too Low! Try Again.\nYou have %s lives left.%n", count);
          }
          case "correct" -> {
            System.out.println("You Guessed it!");
            count = 0;
          }
          case "oor" -> System.out.println("Guess out of range.");
          default -> throw new Exception();
        }
      } catch (Exception e) {
        System.out.println("That was not a valid guess.");
      }
    }
    //Once out of guess or guess correctly, exit the while loop and ask if user wants to play again.
    System.out.println("Would you like to play again? (yes/no)");
    String answer = guess_the_number.nextLine();
    try {
      //helper function to determine to continue game....
      switch(playAgain(answer)) {
        case "true" -> main(args);
        case "false" -> System.out.println("GoodBye");
        default -> throw new Exception();
      }
    } catch (Exception e) {
      //Will initiate one more chance to provide valid response.
      String newAnswer = guess_the_number.nextLine();
      switch(playAgain(newAnswer)) {
        case "true" -> main(args);
        case "false" -> System.out.println("GoodBye");
      }
    }
  }
}
