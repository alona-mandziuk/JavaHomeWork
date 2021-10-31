package com.pb.mandziuk.hw5;

import com.pb.mandziuk.hw5.Book;

public class Reader {
    Book b = new Book();

    public String NameReader;
    public String BirthDate;
    public double PhoneNumber;
    public int Ticket;
    public String Faculty;


    public String getNameReader() {
          return NameReader;
    }

    public String getBirthDate() {

        return BirthDate;
    }

    public double getPhoneNumber() {
        return PhoneNumber;
    }

    public int getTicket() {
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

    public void setPhoneNumber(double phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setTicket(int ticket) {
        Ticket = ticket;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

public void takeBook(Reader reader) {
    if (Reader == null) {
        System.out.print(NameReader + "взяв 3 книги");
    }

}
public void takeBook() {
            System.out.print(NameReader + " взяв книги "+ BookName);
    }

public void takeBook() {
    System.out.println(NameReader + " взяв книги " + Book);
}

}
