package com.pb.mandziuk.hw2;


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
        if (y == 0 && sign == '/') {
            System.out.println("You've chased the wrong action");
        }

                switch (sign) {
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
                        if (y == 0) throw new ArithmeticException("you cannot divide to 0");
                        z = x / y;
                        break;

                    default:
                        System.out.println("You've chased the wrong action");
                        return;
                }
            System.out.println("The result is");
            System.out.println(x + " " + sign + " " + y + " = " + z);
        }
    }


