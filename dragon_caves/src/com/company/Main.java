package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner enterDragonCave = new Scanner(System.in);
        String response;
        System.out.println("You are in a land full of Dragons.");
        System.out.println("In Front of you, you see two caves. In one cave, ");
        System.out.println("the dragon is friendly and will share his treasure with ");
        System.out.println("you. The other dragon is greedy and hungry and will eat you");
        System.out.println("on sight. Which cave will you go into? (1 or 2)");
        String userinput = enterDragonCave.nextLine();
        System.out.println(userinput);
        if(userinput.equals("1")) {
            response = userinput;
            System.out.println("Welcome Friend, want to share my wealth!");
        }
        else if (userinput.equals("")) {
            System.out.println("You need to choose a Path!");
        }
        else {
            System.out.println("You approach the case...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He open his jaws and...");
            System.out.println("Gobbles you down in one bite!");
        }
    }
}
