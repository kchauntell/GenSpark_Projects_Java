import java.util.*;
import java.io.File;


public class hangMan {

  //Methods to use in Main class for HangMan
  public static int getRandomNumber() {
    Random number = new Random();
    return number.nextInt(0,61336);
  };

  public static String getRandomWord(int num) throws Exception{
    File dictionary = new File("/Users/kendrachauntell/GenSparkMaterial/genspark_projects/hangman_Project/src/Java/dictionary.txt");
    Scanner words = new Scanner(dictionary);
    ArrayList<String> wordsList = new ArrayList<>();
    while(words.hasNextLine()) {
      wordsList.add(words.nextLine());
    }
    return wordsList.get(num);
  }

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

  public static void drawHangMan (int l) {
    if(l == 6) {
      System.out.println("|----------");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
    }
    else if(l == 5) {
      System.out.println("|----------");
      System.out.println("|    O");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
    }
    else if(l == 4) {
      System.out.println("|----------");
      System.out.println("|    O");
      System.out.println("|    |");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
    }
    else if(l == 3) {
      System.out.println("|----------");
      System.out.println("|    O");
      System.out.println("|   -|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
    }
    else if(l == 2) {
      System.out.println("|----------");
      System.out.println("|    O");
      System.out.println("|   -|-");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
    }
    else if(l == 1) {
      System.out.println("|----------");
      System.out.println("|    O");
      System.out.println("|   -|-");
      System.out.println("|   /");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
    }
    else{
      System.out.println("|----------");
      System.out.println("|    O");
      System.out.println("|   -|-");
      System.out.println("|   /|");
      System.out.println("|");
      System.out.println("|");
      System.out.println("|");
    }
  }

  public static void main(String[] args) throws Exception {
    int randomNum = getRandomNumber();
    String randomWord = getRandomWord(randomNum);
    Scanner hangManInput = new Scanner(System.in);
    System.out.println(
        """
            Welcome to HangMan...
            Guess the word in just 6 tries.
            Guess one letter at a time.

            Let's Start... What word am I thinking of?
            """
    );


    char[] guessWordArr = randomWord.toCharArray();
    char[] userGuessArr = new char[guessWordArr.length];

    for (var i = 0; i < guessWordArr.length; i++) {
      userGuessArr[i] = '?';
    }

    boolean finished = false;
    int lives = 6;

    while (finished == false) {
      String guess = hangManInput.next();

      while (guess.length() != 1 || Character.isDigit(guess.charAt(0))) {
        System.out.println("Invalid input. DO IT OVER!!!");
        guess = hangManInput.next();
      }

      boolean discovered = false;
      for (var i = 0; i < guessWordArr.length; i++) {
        if (guess.charAt(0) == guessWordArr[i]) {
          userGuessArr[i] = guessWordArr[i];
          discovered = true;
        }
      }

      if (!discovered) {
        lives--;
        System.out.println("Dead Wrong!");
      }

      boolean done = true;

      for (var i = 0; i < userGuessArr.length; i++) {
        if (userGuessArr[i] == '?') {
          System.out.println(" _");
          done = false;
        } else {
          System.out.println(" " + userGuessArr[i]);
        }
      }
      System.out.println("\n" + "Lives Left: " + lives);
      drawHangMan(lives);


      if (done) {
        System.out.println("Congrats! You can read my mind, you little Genius");
        finished = true;
      }

      if (lives == 0) {
        System.out.println("You don't know WHAT I be thinking!!!");
        finished = true;
      }
    }
    System.out.println("Would you like to play again? (yes/no)");
    String answer = hangManInput.nextLine();
    try {
      //helper function to determine to continue game....
      switch(playAgain(answer)) {
        case "true" -> main(args);
        case "false" -> System.out.println("GoodBye");
        default -> throw new Exception();
      }
    } catch (Exception e) {
      //Will initiate one more chance to provide valid response.
      String newAnswer = hangManInput.nextLine();
      switch(playAgain(newAnswer)) {
        case "true" -> main(args);
        case "false" -> System.out.println("GoodBye");
      }
    }
  }
}
