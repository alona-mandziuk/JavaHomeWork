package com.pb.mandziuk.hw5;


public class Reader {
    Book book = new Book();

    public String NameReader;
    public String BirthDate;
    public String PhoneNumber;
    public String Ticket;
    public String Faculty;

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


    public void takeBook(String NameBook, int BookCounter) {

            System.out.print("\n" + NameReader + "взяв " + BookCounter);
        }



    public void takeBook(String BookName, String BookAuthor) {
        System.out.print("\n" + NameReader + " взяв книги " + BookName + BookAuthor);
    }

    public void takeBook (String BookName, String BookAuthor, int BookYear) {
        System.out.println("\n" + getNameReader() + " взяв книги " + BookName + BookYear);
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



    }
}