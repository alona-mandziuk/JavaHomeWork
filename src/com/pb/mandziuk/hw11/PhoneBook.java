package com.pb.mandziuk.hw11;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    List<PhoneContact> phoneContacts;
//PhoneContact phoneContact = new PhoneContact();
    Scanner scanner = new Scanner(System.in);

    public void manipulate () throws IOException{
        System.out.println("...phoneBOOK...");
        System.out.println("Chose yor action:");
        System.out.println("1 - adding new contact~");
        System.out.println("2 - remove the contact~");
        System.out.println("3 - searching~");
        System.out.println("4 - show all contacts~");
        System.out.println("5 - change the contact~");
        System.out.println("6 - exit.");
        String select = scanner.next();
        switch (select){
            case "1":
                addContact();
                //break;
            case "2":
                removeContact();
               // break;
            case "3":
                search();
               // break;
            case "4":
                showAll();
               // break;
            case "5":
                change();
               // break;
            case "6":
                scanner.close();
                break;

        }
    }

    public void change() throws IOException {
        System.out.println("Please enter the name of contact which you want to change: ");
        String changeC = scanner.next();
        System.out.println("Put new phone number:");
        if (phoneContacts != null) {
            for (PhoneContact phoneContact : phoneContacts) {
                if (phoneContact.getName().equals(changeC)) {
                    phoneContact.setPhoneNumber(changeC);
                    System.out.println("New nuber is: " + changeC);
                }
            }
        }
    }
    public void showAll() {
        if (phoneContacts != null) {
            for (PhoneContact phoneContact: phoneContacts){
                               System.out.println(phoneContact);

            }
        }
    }
    public void search()  {
        System.out.println("Please enter the name of contact to search:");
        String searchC = scanner.next();
if (phoneContacts != null){
        for (int i = 0; i<phoneContacts.size(); i++){
            PhoneContact phoneContact = phoneContacts.get(i);
            if (phoneContact.getName().equals(searchC)){
                System.out.println(phoneContact.getName().toString());
            }
            }
        }
    }

    public void removeContact() {
        System.out.println("Please enter the name of contact to delete:");
        String removeC = scanner.next();
        if (phoneContacts != null) {
            for (int i = 0; i < phoneContacts.size(); i++) {
                PhoneContact phoneContact = phoneContacts.get(i);
                if (phoneContact.getName().equals(removeC)) {
                    phoneContacts.remove(phoneContact);
                    System.out.println("You have deleted the contact.");
                } else {
                    continue;
                }
            }
        }
    }
    public void addContact() {
        System.out.println("Please, enter the name:");
        String name1 = scanner.next();
        System.out.println("Please, enter the phone number:");
        String number1 = scanner.next();
        System.out.println("Please, enter the date of birth: (XXXX-XX-XX) " );
        LocalDate dateOfBith1 = LocalDate.parse(scanner.next());
        System.out.println("Please, enter the adress: ");
        String adress1 = scanner.next();
        LocalDateTime modifyTime = null;
        PhoneContact phoneContact1 = new PhoneContact (name1, dateOfBith1,number1, adress1, modifyTime);
        if (phoneContacts != null){
        phoneContacts.add(phoneContact1);}
        System.out.println(phoneContact1);
        System.out.println("The contact is saved.");

    }



    public static void main (String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);


        PhoneBook phoneBook = new PhoneBook();
        List<PhoneContact> phoneContacts = new ArrayList<>(Arrays.asList(
                new PhoneContact("Alona Mandziuk",
                        LocalDate.of(1993, 4, 26),
                        "0966628899" ,
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

    String phoneContactsJson = mapper.writeValueAsString(phoneContacts);
//    System.out.println(phoneContactsJson);

//        List phoneContacts2 = mapper.readValue(phoneContactsJson, List.class);
//        System.out.println(phoneContacts2.get(0).getClass().getName());
//        System.out.println(phoneContacts2);

//        List<PhoneContact> phoneContacts3 = mapper.readValue(phoneContactsJson, new TypeReference<List<PhoneContact>>() {});
//        System.out.println(phoneContacts3.get(0).getClass().getName());
//        System.out.println(phoneContacts3);


phoneBook.manipulate();
 }
}
