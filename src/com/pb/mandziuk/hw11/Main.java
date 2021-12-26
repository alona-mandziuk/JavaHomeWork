package com.pb.mandziuk.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----epicPHONEBOOK-----");
        System.out.println("Chose yor action:");
        System.out.println("1 - adding new contact~");
        System.out.println("2 - remove the contact~");
        System.out.println("3 - show all contacts~");
        System.out.println("4 - change the contact~");
        System.out.println("5 - exit.");
        PhoneBook phoneBook = new PhoneBook();

        Scanner scan = new Scanner(System.in);
        String select = scan.nextLine();
        switch (select){
            case "1":
                phoneBook.addContact();
                return;
            case "2":
                phoneBook.removeContact();
               break;
            case "3":
                phoneBook.showSort();
               break;
            case "4":
                phoneBook.change();
                break;
            default:
                return;

        }
       // phoneBook.saveToFile();
     //   phoneBook.loadFromFile();
    }


}
