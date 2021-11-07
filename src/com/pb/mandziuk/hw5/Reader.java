package com.pb.mandziuk.hw5;


public class Reader {
    Book book = new Book();

    public String NameReader;
    public String BirthDate;
    public String PhoneNumber;
    public String Ticket;
    public String Faculty;
public static int BookCounter = 0;

    public static int getBookCounter() {
        return BookCounter;
    }

    public static void setBookCounter(int bookCounter) {
        BookCounter = bookCounter;
    }

    public String getNameReader() {
        return NameReader;
    }

    public String getBirthDate() {

        return BirthDate;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getTicket() {
        return Ticket;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setNameReader(String nameReader) {
        NameReader = nameReader;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }


    public void takeBook(String bookName, String bookAuthor, String NameBook) {

            System.out.print("\n" + NameReader + "взяв " + BookCounter + " книги ");
        }



    public void takeBook(String BookName, String BookAuthor) {
        System.out.print("\n" + NameReader + " взяв книги " + BookName + book.getBookAuthor());
    }

    public void takeBook(String bookName, String BookName, int BookYear) {
        System.out.println("\n" + getNameReader() + " взяв книги: " + BookName + BookYear);
    }

    public void  returnBook (String BookName, int BookCont) {
        System.out.println( " \n" + getNameReader() + " повернув " + getBookCounter() + " книги ");
    }
public void returnBook (String BookName) {
    System.out.println( "\n" + getNameReader() + " повернув: " + "\n" + BookName);

}
public void returnBook (String BookName, String BookAuthor, int BookYear) {
    System.out.println("\n" + getNameReader() + "повернув книги: " + "\n" + BookName + "/" +
            BookAuthor + BookYear);
}

    public Reader() {
        this.NameReader = "NameReader";
        this.BirthDate = "10.10.1990";
        this.Faculty = "Faculty";
        this.PhoneNumber = "0966000000";
        this.Ticket = "101010";

    }

    public Reader(String NameReader, String BirthDate, String Faculty, String PhoneNumber, String Ticket) {
        this.NameReader = NameReader;
        this.BirthDate = BirthDate;
        this.Faculty = Faculty;
        this.PhoneNumber = PhoneNumber;
        this.Ticket = Ticket;
        BookCounter++;

    }




}