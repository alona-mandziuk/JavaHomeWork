package com.pb.mandziuk.hw8;

//WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами
// – один по умолчанию, второй принимает сообщение и передает его в конструктор класса Exception.

public class WrongPasswordException extends Exception {
    String password;

    public WrongPasswordException(String password) {
        this.password = password;
    }

    public WrongPasswordException(String message, String password) {
        super(message);
        this.password = password;
    }
}
