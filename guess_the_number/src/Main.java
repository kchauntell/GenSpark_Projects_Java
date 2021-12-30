import java.util.Scanner;
import java.util.Random;

class HelperClass {
  // Generates the Random number to be Guessed
  public static int getRandomNumber () {
    Random number = new Random();
    int num = number.nextInt(1, 20);
    return num;
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
  public static String Guesses(int one, int two) {
    String result = "";
    if(one > two)  result = "high";
    else if (one < two) result = "low";
    else if (one == two) result = "correct";
    return result;
  }
}

public class Main {
  public static void main(String [] args) {
    //Setting random number to be guessed. Imported java.util.Random method.
    int random_num = HelperClass.getRandomNumber();
    //Set the total number of lives to begin with. Will decrement with each guess.
    int count = 6;
    //Sets up User input.
    Scanner guess_the_number = new Scanner(System.in);
    //Introduction to game.
    System.out.println("Welcome to the Guessing Game!"+
        "\nYou get 6 lives." +
        "\nNow, let me ask you, what is your name?");
    //User input initialized for response here.
    String username = guess_the_number.nextLine();
    // try-catch blocks to run responses from user.
    // catch block set for empty string/ blank responses.
    try {
      if (username.equals("")) throw new Exception();
      else System.out.println(String.format("Hello, %s, Let's Play!.", username));
    } catch (Exception e) {
      System.out.println("Please Provide a name.");
      //This asks for another entry to user for provide a valid name, once blank response caught.
      username = guess_the_number.nextLine();
      System.out.println(String.format("Hello, %s, Let's Play!.", username));
    }
    System.out.println("What do you think the number is, between 1 and 20?");
    while(count != 0) {
      String guess = guess_the_number.nextLine();
      try {
        int numGuess = Integer.parseInt(guess);
        //uses helper class method to use comparison operators: guess vs. random number.
        switch(HelperClass.Guesses(numGuess, random_num)) {
          //Decrements the count, wrong guess, and lets user know guess is greater than random number
          case "high" -> {
            count--;
            System.out.println(String.format("Guessed Too High! Try Again.\nYou have %s lives left.", count));
          }
          case "low" -> {
            count--;
            System.out.println(String.format("Guess Too Low! Try Again.\nYou have %s lives left.", count));
          }
          case "correct" -> {
            System.out.println("You Guessed it!");
            count = 0;
          }
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
      switch(HelperClass.playAgain(answer)) {
        case "true" -> main(args);
        case "false" -> {
          System.out.println("GoodBye"); break;
        }
        default -> throw new Exception();
      }
    } catch (Exception e) {
      //Will initiate one more chance to provide valid response.
      String newAnswer = guess_the_number.nextLine();
      switch(HelperClass.playAgain(newAnswer)) {
        case "true" -> main(args);
        case "false" -> {
          System.out.println("GoodBye"); break;
        }
      }
    }
  }
}
