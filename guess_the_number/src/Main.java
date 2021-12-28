import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String [] args) {
        int count = 6;
        Boolean play = true;

        while (play == true) {
            Random num = new Random();
            int random_number = num.nextInt(1, 20);
            Scanner guess_the_number = new Scanner(System.in);
            System.out.println("Welcome to the Guessing Game!");
            System.out.println("Let's start by grabbing your name.");
            System.out.println("What shall we call you?");
            String username = guess_the_number.nextLine();
            try {
                switch (username) {
                    case "" -> {
                        throw new Exception();
                    }
                    default -> {
                        System.out.println(String.format("Hello, %s, Let's Play!.", username));
                        System.out.println("You get 6 lives! Let's see if you survive!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Please Provide a Player Name.");
                continue;
            }
            System.out.println("What do you think the number is, between 1 and 20?");
            while (count != 0) {
                String guess = guess_the_number.nextLine();
                try {
                    Integer.parseInt((String) guess);
                } catch (NumberFormatException e) {
                    System.out.println("Caught Exception: Number Format Exception");
                    System.out.println("Mistakes happen, you didn't lose a life, try again!");
                    continue;
                }
                if (guess.equals(String.valueOf(random_number))) {
                    System.out.println("You Guessed It!");
                    System.out.println("Would you like to play again? (yes/no)");
                    String playAgain = guess_the_number.nextLine();
                        if (playAgain.equals("no")) {
                            System.out.println("GoodBye");
                            play = false;
                            break;
                        } else if (playAgain.equals("yes")){
                            main(args);
                        }
                    break;
                } else if (!guess.equals(String.valueOf(random_number)) && count != 0) {
                    count--;
                    if (count == 0) {
                        System.out.println(String.format("You are out of lives, %s!", username));
                        System.out.println("Better luck next time!");
                        System.out.println("Would you like to play again? (yes/no)");
                        String playAgain = guess_the_number.nextLine();
                        try {
                            if (playAgain.equals("no")) {
                                System.out.println("GoodBye");
                                play = false;
                                break;
                            } else if (playAgain.equals("yes")){
                                main(args);
                            } else {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            System.out.println("Please respond with yes or no.");
                        }
                        break;
                    }
                    int inputGuess = Integer.parseInt((String) guess);
                    try {
                        if(inputGuess > 20 || inputGuess <= 0) throw new Exception();
                        if (inputGuess > random_number) {
                            System.out.println("Guess is too High!");
                            System.out.println(String.format("You have %s lives left. Try again!", count));
                        } else if (inputGuess < random_number) {
                            System.out.println("Guess is too Low! Give it one more try!");
                            System.out.println(String.format("You have %s lives left. Try again!", count));
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Entry: You picked a number out of range.");
                        System.out.println("You STILL lose a life! Pay Attention, between 1-20!");
                        System.out.println(String.format("You have %s lives left. Try again!", count));
                    }
                }

            }
        }
    }
}
