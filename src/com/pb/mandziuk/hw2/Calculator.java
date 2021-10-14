package com.pb.mandziuk.hw2;

import java.io.PrintStream;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Try to do the math");
        Scanner scan = new Scanner(System.in);
        Double x;
        Double y;
        Double z;
        char sign;
        System.out.println("Enter two numbers:");
        x = scan.nextDouble();
        y = scan.nextDouble();
        System.out.println("Enter what u wanna do with them: (+,-,*,/");
        sign = scan.next().charAt(0);
switch(sign) {
    case '+':
        z = x + y;
        break;
    case '-':
        z = x - y;
        break;
    case '*':
        z = x * y;
        break;
    case '/':
        z = x / y;
        if (y == 0) {
            System.out.println("dont do this!!!");
        }
        break;

    default:
        System.out.println("You've chased the wrong action");
        return;}
        System.out.println("The result is");
            System.out.println(x + " " + sign + " " + y + " = " + z);}
}

