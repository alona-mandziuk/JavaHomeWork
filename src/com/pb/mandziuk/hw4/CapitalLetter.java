package com.pb.mandziuk.hw4;

import java.util.Scanner;

public class CapitalLetter {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("Наберіть текст ");
            System.out.println("Модифікований текст: " + replaceText(in.nextLine()));
        }

        private static String replaceText(String text) {
            StringBuilder result = new StringBuilder();
            if (text != null) {
                boolean end = false;
                for (char symbol : text.toCharArray()) {
                    if (Character.isLetter(symbol)) {
                        result.append(end ? symbol : Character.toUpperCase(symbol));
                        end = true;
                    } else {
                        result.append(symbol);
                        end = false;
                    }
                }
            }
            return result.toString();
        }
    }



