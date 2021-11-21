package com.pb.mandziuk.hw8;

//Создать класс Auth, который содержит поля login и password и методы:
//
// - signUp (регистрация на сайте) принимающий login, password, и confirmPassword.
//        Проверяет параметр login, длинна должна быть от 5 до 20 символов.
//        Login должен содержать только латинские буквы и цифры.
//        Если логин не соответствует требованиям нужно выбросить WrongLoginException.
//        Проверяет параметр password, длинна более 5, только латинские буквы и цифры и знак подчеркивания.
//        Также password и confirmPassword должны совпадать.
//        Если password не соответствует требованиям нужно выбросить WrongPasswordException.
//        Если проверки все пройдены успешно записать в свои поля значение login и password.
//        Так сохраняем пользователя :)
//- signIn (вход на сайт) принимающий login и password.
//        Проверяет что login и password соответствуют значениям из полей класса.
//        Если нет - выбрасывает исключение WrongLoginException.


import java.util.regex.Pattern;

public class Auth {
public  String login;
public String password;
public String confirmPassword;

    public Auth() {

    }

    public void signUp (String login, String password )
                        throws WrongLoginException, WrongPasswordException {

        if(Pattern.matches("[a-zA-Z0-9]{5,20}", login)){
            System.out.println("Ok! Login! ");}
        else {
            throw new WrongLoginException("Login is not correct");}


       if (Pattern.matches("[a-zA-Z0-9] {5,}", password)){
           System.out.println("Ok! Password!");}
       else {
            throw new WrongPasswordException("Password is not correct");}


}

    public void signIn (String login1, String password1) throws WrongLoginException{

    if (login1.equals(login) && password1.equals(password)) {
        System.out.println("Your authorisation is successful. Welcome!");
    } else {
        throw new WrongLoginException("Login is not correct");

    }

}



}







