package com.example.esoftwaricareplica.models;

public class Students {

    private String fullname, age, gender, address;
    private int img;

    public Students(String fullname, String age, String gender, String address, int img) {
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.img = img;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public int getImg() {
        return img;
    }
}
