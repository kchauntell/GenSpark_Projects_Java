package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner enterDragonCave = new Scanner(System.in);
        System.out.println("You are in a land full of Dragons.");
        System.out.println("In Front of you, you see two caves. In one cave, ");
        System.out.println("the dragon is friendly and will share his treasure with ");
        System.out.println("you. The other dragon is greedy and hungry and will eat you");
        System.out.println("on sight. Which cave will you go into? (1 or 2)");
        String userInput = enterDragonCave.nextLine();
        System.out.println("You chose to take Path: " + userInput);
        try {
            switch (userInput) {
                case "1" -> System.out.println("Welcome Friend, want to share my wealth?!");
                case "2" -> {
                    System.out.println("You approach the case...");
                    System.out.println("It is dark and spooky...");
                    System.out.println("A large dragon jumps out in front of you! He open his jaws and...");
                    System.out.println("Gobbles you down in one bite!");
                }
                default -> throw new Exception();
            }
        } catch (Exception e) {
            if(userInput.equals("")) System.out.println("You did not choose a Path!");
            else System.out.println("Not an Option! Please choose Path 1 or 2.");
        }
    }
}

