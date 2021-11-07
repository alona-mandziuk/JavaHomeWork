package com.pb.mandziuk.hw5;

/**
 * Клас, який описує книги, наявні в бібліотеці
 */
public class Book {
    public static int BookCounter = 0;

    public static int getBookCounter() {
        return BookCounter;
    }

    public static void setBookCounter(int bookCounter) {
        BookCounter = bookCounter;
    }

    public String BookName;
    public String  BookAuthor;
    public int BookYear;

    public Book (String BookName, String BookAuthor, int BookYear) {
        this.BookName = BookName;
        this.BookAuthor = BookAuthor;
        this.BookYear = BookYear;
        BookCounter++;
    }

    public String getBookName() {
                        return BookName;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public int getBookYear() {
        if (BookYear <= 0){
        }
        return BookYear;
    }

    public void setBookName(String bookName) {
                BookName = bookName ;
    }

    public void setBookAuthor(String bookAuthor) {
        BookAuthor = bookAuthor;
    }

    public void setBookYear(int bookYear) {
        BookYear = bookYear;
    }
    public Book() {
        this.BookName = " BookName ";
        this.BookAuthor = " BookAuthor ";
        this.BookYear = Integer.parseInt("2000");
        BookCounter++;
    }
String getInfoBook () {
        return  BookName + BookAuthor + BookYear + BookCounter;
}
}
