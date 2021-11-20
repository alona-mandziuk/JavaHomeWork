package com.pb.mandziuk.hw8;

//WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами
// – один по умолчанию, второй принимает сообщение и передает его в конструктор класса Exception.

public class WrongLoginException extends Exception {
    String login;


    public WrongLoginException(String login) {
        this.login = login;
    }

    public WrongLoginException(String message, String login) {
        super(message);
        this.login = login;
    }
}
