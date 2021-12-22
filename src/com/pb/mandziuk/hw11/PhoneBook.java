package com.pb.mandziuk.hw11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private static final DateTimeFormatter CHANGE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String DATA_FILE_PATH = "files/Phone_Book.json";

    private final Scanner scan = new Scanner(System.in);
    private final List<PhoneContact> contacts = new ArrayList<>();
    private final ObjectMapper objectMapper;


    public PhoneBook(){
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        objectMapper.registerModule(module);}



    public void change() {
        PhoneContact phoneContact = new PhoneContact();
        List<String> phoneNumbers = phoneContact.getPhoneNumber();
        System.out.println("Please enter the name of contact which you want to change: ");
        String changeC = scan.nextLine();
        phoneContact = findContactByName(changeC);
                if (phoneContact == null) {
            System.out.println("Contact is not found.");
            return;
        }
                while (true){
                    System.out.println("Phones:");
                    for (int i=0; i< phoneNumbers.size();i++){
                        System.out.println((i + 1) + "." + phoneNumbers.get(i));
                    }
                    System.out.println("Press 1 to add the phone number");
                    System.out.println("Press 2 to exit");
                    String input = scan.nextLine();
                    switch (input){
                        case "1":
                            List<String> newNumbers = inputPhoneNumbers();
                            phoneNumbers.addAll(newNumbers);
                            phoneContact.setModifyTime(LocalDateTime.now());
                            break;
                        case "2":
                            System.out.println("Exit this menu");
                            break;
                        default:
                            return;

                    }
                }

    }


    public void showAll(List <PhoneContact> contacts) {

        System.out.println("--------------------------------------------");
        for (PhoneContact c: contacts){
            System.out.println(c.toString());
            System.out.println("-----------------------------------------------");
        }
    }
    public void search()  {
        System.out.println("Please enter the name of contact to search:");
        String searchC = scan.nextLine();
        List <PhoneContact> foundContacts = new ArrayList<>();

        for (PhoneContact c: contacts){
            if (c.getName().contains(searchC)){
               foundContacts.add(c);}}
        showAll(foundContacts);

    }

    public void removeContact() {
        System.out.println("Please enter the name of contact to delete:");
        String removeC = scan.nextLine();
        PhoneContact phoneContact = findContactByName(removeC);
        if (phoneContact == null) {
            System.out.println("No phonecontact by this name.");
            return;}
        contacts.remove(removeC);
        System.out.println("The contact is removed.");

    }
    private PhoneContact findContactByName (String name){
        for (PhoneContact phoneContact: contacts){
            if (name.equals(phoneContact.getName())){
                return phoneContact;
            }
        }
        return null;
    }

    public void addContact() {
        System.out.println("Please, enter the name:");
        String name = scan.nextLine();
        System.out.println("Please, enter the phone number:");
        List<String> numbers = inputPhoneNumbers ();
        String number = scan.nextLine();
        System.out.println("Please, enter the date of birth: (XXXX-XX-XX) " );
        LocalDate dateOfBirth = LocalDate.parse(scan.nextLine());
        System.out.println("Please, enter the adress: ");
        String adress = scan.nextLine();
        PhoneContact phoneContact = new PhoneContact (name,numbers,dateOfBirth,adress);
        contacts.add(phoneContact);

    }
    private List<String> inputPhoneNumbers() {
        List<String> numbers = new ArrayList<>();
        while (true) {
            System.out.println("Enter phone number (0 to exit): ");
            String number = scan.nextLine();
            if ("0".equals(number)) {
                return numbers;
            }
            numbers.add(number);
        }
    }
    public void saveToFile() {
        try {
            String json = objectMapper.writeValueAsString(contacts);
            Files.write(Paths.get(DATA_FILE_PATH), json.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            System.out.println("Ошибка при сохранении файла: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void loadFromFile() {
        try {
            byte[] bytesData = Files.readAllBytes(Paths.get(DATA_FILE_PATH));
            List<PhoneContact> contacts = objectMapper.readValue(bytesData, new TypeReference<List<PhoneContact>>() {});
            this.contacts.clear();
            this.contacts.addAll(contacts);
        } catch (Exception ex) {
            System.out.println("Ошибка при загрузки из файла: " + ex.getMessage());
            ex.printStackTrace();
        }
    }



}
