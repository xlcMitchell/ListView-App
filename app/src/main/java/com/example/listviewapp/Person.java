package com.example.listviewapp;

import java.io.Serializable;
//person class for creating new person object
public class Person implements Serializable {
    private String name;
    private boolean gender;

    public Person(String name,boolean gender){
         this.name = name;
         this.gender = gender;
    }

    public String getName(){return name;}
    public boolean isGender(){return gender;}
    public void setName(String name){this.name=name;}
    public void setGender(boolean gender){this.gender=gender;}


}
