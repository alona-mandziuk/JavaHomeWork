package com.pb.mandziuk.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        int random, guess, attempts;

        Scanner keyboard = new Scanner(System.in);
        Random generator = new Random();
        random = generator.nextInt(100) + 1;
        attempts = 1;

        System.out.println("I've chose the number between and 100. Try to guess!");
        System.out.println("Type 'exit' if u want to stop");

        guess = keyboard.nextInt();

        while (guess != random) {

                if (guess > random) {
                    System.out.println("Lower!");
                    attempts += 1;

                }
                else {
                    System.out.println("Higher!");
                    attempts += 1;
                }


                guess = keyboard.nextInt();

                // String value = keyboard.next();
                //   if (value.equals("exit")) {
                // System.out.println("the end");
                // }
            }

            System.out.println(random + " is correct, it took you " + attempts + " attempts to guess!");


        }
    }






