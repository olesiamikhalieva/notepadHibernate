package com.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String name;
    private String surname;
    private String phone;

    public Person(String name, String sername, String phone) {
        this.name = name;
        this.surname = sername;
        this.phone = phone;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        Pattern p = Pattern.compile("^\\+380\\d{9}$");
        Matcher m = p.matcher(phone);
        if (m.matches()==false) {
            System.out.println("Number in not ukrainian");
        } else {
         this.phone = phone;
        }
    }
}
