package com.pb.mandziuk.hw8;

//Создать класс OnlineShop с методом main.
//        В main создать один объект класса Auth.
//        Предложить пользователю сперва зарегистрироваться (signUp) потом войти на сайт (signIn).
//        Обработать исключения методов signUp signIn с помощью блоков try-catch.

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please registrate: ");
        System.out.println("(Login should be 5-20 symbols, contains latin letters and figures.");
        System.out.println("Password should be more than 5 symbols, " +
                "contains latin letters, figures and symbol '_'.)");
        System.out.println("Input login: ");
        String login = in.nextLine();
        System.out.println("Input password: ");
        String password = in.nextLine();
        Auth user = new Auth(login, password);

        user.signUp(login, password);

        try {
            user.signUp(login, password);
        } catch (WrongLoginException e1) {
            System.out.println("Incorrect type of login!");
        } catch (WrongPasswordException e2) {
            System.out.println("Incorrect type of password!");
        }
        System.out.println("Confirm your password: ");
        String confirmPassword = in.nextLine();
        if (confirmPassword.equals(password)) {
            System.out.println("Registration is successfuly! Welcome!");
        }
        System.out.println("*************************");
        System.out.println("Now you can authorise in system.");
        System.out.println("Input login: ");
        String login1 = in.nextLine();
        System.out.println("Input password: ");
        String password1 = in.nextLine();


        try {
            user.signIn(login1, password1);
        } catch (WrongLoginException e) {
            System.out.println("Incorrect login or password!");
        }

    }
}




