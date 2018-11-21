package com.example.yelaman.alphaacademy;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User {
    private String name;
    private String surname;
    private String email;

    public User(String email, String name , String surname) {
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }

    public String getFullName() {
        return this.name + " " + this.surname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
