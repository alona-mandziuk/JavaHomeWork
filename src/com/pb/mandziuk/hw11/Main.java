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
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        List<PhoneContact> phoneContacts = new ArrayList<>(Arrays.asList(
                new PhoneContact("Alona Mandziuk",
                        LocalDate.of(1993, 4, 26),
                        "0966628899",
                        "Druzhbu narodiv 8, Kamianets",
                        LocalDateTime.now()),
                new PhoneContact("Oleksandr Kodenets",
                        LocalDate.of(1984, 8, 5),
                        "0985488888",
                        "Gagarina 40, Kamianets",
                        LocalDateTime.now()),
                new PhoneContact("Naskalna Inna",
                        LocalDate.of(1971, 5, 3),
                        "0984511022",
                        "Soborna 33, Kamianets",
                        LocalDateTime.now())));

        System.out.println("-----epicPHONEBOOK-----");
        System.out.println("Chose yor action:");
        System.out.println("1 - adding new contact~");
        System.out.println("2 - remove the contact~");
        System.out.println("3 - searching~");
        System.out.println("4 - show all contacts~");
        System.out.println("5 - change the contact~");
        System.out.println("6 - exit.");

        String select = scan.nextLine();
        switch (select){
            case "1":
                phoneBook.addContact();
                break;
            case "2":
                phoneBook.removeContact();
               break;
            case "3":
                phoneBook.search();
                break;
            case "4":
                phoneBook.showAll(phoneContacts);
               break;
            case "5":
                phoneBook.change();
                break;
            default:
                return;

        }
        phoneBook.saveToFile();
        phoneBook.loadFromFile();
    }


}
