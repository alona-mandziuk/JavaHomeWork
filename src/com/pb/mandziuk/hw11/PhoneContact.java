package com.pb.mandziuk.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PhoneContact {
    private String name;
    private LocalDate dateOfBirth;
    private List<String> phoneNumber;
    private String adress;
    private LocalDateTime modifyTime;

    public PhoneContact(String name, LocalDate dateOfBirth, String number, String adress, LocalDateTime now) {}


    public PhoneContact(String name, LocalDate dateOfBirth,
                        List<String> phoneNumber, String adress,
                        LocalDateTime modifyTime) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.modifyTime = modifyTime;
    }

    public PhoneContact() {
        
    }

    public PhoneContact(String name, List<String> numbers, LocalDate dateOfBirth, String adress) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
