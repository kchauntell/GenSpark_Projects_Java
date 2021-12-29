import java.util.Scanner;
import java.util.Random;

class HelperClass {
  public static int getRandomNumber () {
    Random number = new Random();
    int num = number.nextInt(1, 20);
    return num;
  }

  public static String playAgain(String answer) {
    Boolean result = null;
    try {
      switch (answer) {
        case "yes" -> result = true;
        case "no" -> result = false;
        case "" -> throw new Exception();
      }
    } catch (Exception e) {
      System.out.println("Blank Response/Invalid Response: Need to answer yes or no.");
      System.out.println("Two consecutive Invalid/Blank Responses is automatic shut down of Game!");
    }
    return String.valueOf(result);
  }

  public static String Guesses(int one, int two) {
    String result = "";
    if(one > two)  result = "Too High!";
    else if (one < two) result = "Too Low!";
    else if (one == two) result = "Correct!";
    return result;
  }
}

public class Main {
  public static void main(String [] args) {
    int random_num = HelperClass.getRandomNumber();
    int count = 6;
    Scanner guess_the_number = new Scanner(System.in);
    System.out.println("Welcome to the Guessing Game!");
    System.out.println("Let's start by grabbing your name.");
    System.out.println("What shall we call you?");
    String username = guess_the_number.nextLine();
    try {
      if (username.equals("")) throw new Exception();
      else System.out.println(String.format("Hello, %s, Let's Play!.", username));
    } catch (Exception e) {
      System.out.println("Please Provide a name.");
      username = guess_the_number.nextLine();
      System.out.println(String.format("Hello, %s, Let's Play!.", username));
    }
    System.out.println("What do you think the number is, between 1 and 20?");
    while(count !=0) {
      String guess = guess_the_number.nextLine();
      try {
        int numGuess = Integer.parseInt(guess);
        switch(HelperClass.Guesses(numGuess, random_num)) {
          case "Too High!" -> {
            count--;
            System.out.println("Guessed Too High! Try Again.");
            System.out.println(String.format("You have %s lives left.", count));
          }
          case "Too Low!" -> {
            count--;
            System.out.println("Guess Too Low! Try Again.");
            System.out.println(String.format("You have %s lives left.", count));
          }
          case "Correct!" -> {
            System.out.println("You Guessed it!");
            count = 0;
          }
          default -> throw new Exception();
        }
      } catch (Exception e){
        System.out.println("That was not a valid guess.");
//        guess = guess_the_number.nextLine();
      }
    }
    System.out.println("Would you like to play again? (yes/no)");
    String answer = guess_the_number.nextLine();
    try {
      switch(HelperClass.playAgain(answer)) {
        case "true" -> main(args);
        case "false" -> {
          System.out.println("GoodBye");
          break;
        }
        default -> throw new Exception();
      }
    } catch (Exception e) {
      String newAnswer = guess_the_number.nextLine();
      switch(HelperClass.playAgain(newAnswer)) {
        case "true" -> main(args);
        case "false" -> {
          System.out.println("GoodBye");
          break;
        }
        default -> {break;}
      }
    }
  }
}
