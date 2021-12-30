import java.util.Scanner;

public class Main {
  public static String whichPath (String option) {
    String choice;
    switch (option) {
      case "1" -> choice = "wealth";
      case "2" -> choice = "death";
      case "" -> choice = "blank";
      default -> choice = "noOption";
    }
    return choice;
  }

  public static void main(String[] args) {
    Scanner enterDragonCave = new Scanner(System.in);
    System.out.println("You are in a land full of Dragons.");
    System.out.println("In Front of you, you see two caves. In one cave, ");
    System.out.println("the dragon is friendly and will share his treasure with ");
    System.out.println("you. The other dragon is greedy and hungry and will eat you");
    System.out.println("on sight. Which cave will you go into? (1 or 2)");
    String userInput = enterDragonCave.nextLine();

    System.out.println("You chose to take Path: " + userInput);
    try{
      switch (whichPath(userInput)) {
        case "wealth" -> System.out.println("Welcome Friend, want to share my wealth?!");
        case "death" -> System.out.println("""
                    You approach the case...
                    It is dark and spooky...
                    A large dragon jumps out in front of you! He open his jaws and...
                    Gobbles you down in one bite!""");
        case "blank" -> throw new Exception();
        case "noOption" -> {
          System.out.println("That is not one of the options. Again...");
          main(args);
        }
      }
    } catch (Exception e) {
      System.out.println("You have not chosen, let me ask again...");
      main(args);
    }

  }
}
