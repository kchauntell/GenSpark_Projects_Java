import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class hangMan {

  //Methods to use in Main class for HangMan
  public static int getRandomNumber() {
    Random number = new Random();
    return number.nextInt(0, 2);
  };

  public static String getRandomWord(int number) {
    List<String> wordList = Arrays.asList("basketball", "java", "awesome");
    ArrayList<String> wordArrList  = new ArrayList<String>();
    wordArrList.addAll(wordList);

    return wordArrList.get(number);
  }


  public static void main(String[] args) {
    int randomSelection = getRandomNumber();
    String randomWordToGuess = getRandomWord(randomSelection);


  }
}
