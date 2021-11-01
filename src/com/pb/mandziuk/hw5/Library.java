package com.pb.mandziuk.hw5;

import java.util.Arrays;

public class Library {
    public static void main(String[] args) {
        Book b = new Book();
        Reader r = new Reader();

        Book[] books = new Book[3];
        books[0] = new Book(" Інферно ", " (Ден Браун) ", 2017);
        books[1] = new Book(" Казино смерти ", " (Дин Кунц) ", 2010);
        books[2] = new Book(" Вбивство в Східному експресі ", " (Агата Кристи) ", 1939);

        Reader[] readers = new Reader[3];
        readers[0] = new Reader("Іванов І.І. ", " 10.10.1999 ", " Економічний ", " 0988880000 ",
                " 101010 ");
        readers[1] = new Reader("Веромейко В.В. ", " 30.11.2001 ", " Природничий ", " 0976543298 ",
                "6875");
        readers[2] = new Reader("Квача Ф.Й. ", " 15.07.2002 ", " Філологічний ", " 0687851245 ",
                " 368570 ");

        System.out.println("***Бібліотека***");

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getInfoBook());
        }
        System.out.println("***Читачі***");

        for (int j = 0; j< readers.length; j++) {
            System.out.println(readers[j].getNameReader() + readers[j].getBirthDate() + readers[j].getFaculty() + readers[j].getPhoneNumber() + readers[j].getTicket() );

        }
        System.out.println("******************************");

        readers[1].takeBook(books[1].getBookName(), books[1].getBookAuthor() + books[0].getBookName() + books[0].getBookAuthor());

        readers[2].takeBook(books[2].getBookName(), books[2].getBookAuthor(),books[2].getBookYear() );

        }

    }




