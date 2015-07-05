/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing4.DCJTest;

import java.io.Serializable;

/**
 *
 * @author QuangAnh
 */
public class Student implements Serializable{
    private String name;
    private String Address;
    private String Gender;
    private int Age;

    public Student() {
    }

    public Student(String name, String Address, String Gender, int Age) {
        this.name = name;
        this.Address = Address;
        this.Gender = Gender;
        this.Age = Age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
    
}
