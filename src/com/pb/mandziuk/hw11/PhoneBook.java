package com.pb.mandziuk.hw11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PhoneBook {
    private static final DateTimeFormatter CHANGE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String DATA_FILE_PATH = "files/Phone_Book.json";
    private final Scanner scan = new Scanner(System.in);
    //public List<PhoneContact> contacts = new ArrayList<>();
    private final ObjectMapper objectMapper;


    public PhoneBook() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        objectMapper.registerModule(module);
    }

    List<PhoneContact> contacts = new ArrayList<>(Arrays.asList(
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

    public void addContact() {
        System.out.println("Please, enter the name:");
        String name = scan.nextLine();
        System.out.println("Please, enter the phone number:");
        List<String> numbers = inputPhoneNumbers();
        System.out.println("Please, enter the date of birth: (XXXX-XX-XX) ");
        String dateOfBirthStr = scan.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);
        System.out.println("Please, enter the adress: ");
        String adress = scan.nextLine();
        PhoneContact contact = new PhoneContact(name, numbers, dateOfBirth, adress);
        contacts.add(contact);
        System.out.println("You have add a new contact");

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

    public void removeContact() {
        System.out.println("Please enter the name of contact to delete:");
        String removeC = scan.nextLine();
        PhoneContact phoneContact = findContactByName(removeC);
        if (phoneContact == null) {
            System.out.println("No phonecontact by this name.");
            return;
        }
        contacts.remove(removeC);
        System.out.println("The contact is removed.");
    }

    public void printContacts(List<PhoneContact> contacts) {

        System.out.println("--------------------------------------------");
        for (PhoneContact c : contacts) {
            System.out.printf(c.getName(), c.getPhoneNumber().isEmpty() ? " " : c.getPhoneNumber().get(0),
                    c.getDateOfBirth().toString(), c.getAdress(),
                    c.getModifyTime().format(CHANGE_TIME_FORMAT));
            if (c.getPhoneNumber().size() > 1) {
                for (int i = 1; i < c.getPhoneNumber().size(); i++) {
                    System.out.printf(c.getPhoneNumber().get(i));
                    System.out.println("-------------------------------------------------------");
                }

            }
        }
    }

    public PhoneContact findContactByName(String name) {
        System.out.println("Enter the name: ");
        String namef = scan.nextLine();
        List<PhoneContact> foundContacts = new ArrayList<>();
        for (PhoneContact phoneContact : contacts) {
            if (phoneContact.getName().contains(namef)) {
                foundContacts.add(phoneContact);
            }
        }
        printContacts(foundContacts);
        return null;
    }

    public void showSort() {
        contacts.sort(new Comparator<PhoneContact>() {
            @Override
            public int compare(PhoneContact c1, PhoneContact c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        printContacts(contacts);
    }

    public void change (){
        System.out.println("Please enter the name of contact which you want to change: ");
        String edit = scan.nextLine();
        PhoneContact phoneContact = findContactByName(edit);
        editPhoneNumber(phoneContact);

    }



    public void editPhoneNumber (PhoneContact phoneContact) {
        List<String> phoneNumber = phoneContact.getPhoneNumber();
        String changeC = scan.nextLine();
        phoneContact = findContactByName(changeC);
        if (phoneContact == null) {
            System.out.println("Contact is not found.");
            return;
        }

        while (true) {
            System.out.println("Phones:");
            for (int i = 0; i < phoneNumber.size(); i++) {
                System.out.println((i + 1) + "." + phoneNumber.get(i));
            }
            System.out.println("Press 1 to add the phone number");
            System.out.println("Press 2 to exit");
            String input = scan.nextLine();
            switch (input) {
                case "1":
                    List<String> newNumbers = inputPhoneNumbers();
                    phoneNumber.addAll(newNumbers);
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


//    public void search() {
//        System.out.println("Please enter the name of contact to search:");
//        String searchC = scan.nextLine();
//        PhoneContact phoneContact = findContactByName(searchC);
//        if (phoneContact == null) {
//            System.out.println("No phonecontact by this name.");
//            return;
//        }
//        printContacts
//
//    }


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
            List<PhoneContact> contacts = objectMapper.readValue(bytesData, new TypeReference<List<PhoneContact>>() {
            });
            this.contacts.clear();
            this.contacts.addAll(contacts);
        } catch (Exception ex) {
            System.out.println("Ошибка при загрузки из файла: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
//    private void printContacts(List<PhoneContact> contacts) {
//        System.out.println("----------------------------------------------------------------");
//           for (PhoneContact c : contacts) {
//            System.out.printf(  c.getName(), c.getDateOfBirth().toString(),
//                    c.getPhoneNumber().isEmpty() ? "" : c.getPhoneNumber().get(0),
//                    c.getAdress(),
//                    c.getModifyTime().format(CHANGE_TIME_FORMAT)
//            );
////            if (c.getPhoneNumber().size() > 1) {
////                for (int i = 1; i < c.getPhoneNumber().size(); i++) {
////                    System.out.printf(
////                            "|    |                 |               | %14s |                      |                     |%n",
////                            c.getPhoneNumber().get(i)
////                    );
//
//
//            System.out.println("-------------------------------------------------------");
//        }
//    }


    @Override
    public String toString() {
        return "PhoneBook{" +
                "scan=" + scan +
                ", objectMapper=" + objectMapper +
                ", contacts=" + contacts +
                '}';
    }
}