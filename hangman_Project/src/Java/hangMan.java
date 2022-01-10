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

  //Create a method to check the guess.

  public static void main(String[] args) throws Exception {
    int randomNum = getRandomNumber();
    String randomWord = getRandomWord(randomNum);
    System.out.println(randomWord);
    Scanner hangManInput = new Scanner(System.in);
//    System.out.println(
//        """
//        Welcome to
//        """
//    );

  }
}
