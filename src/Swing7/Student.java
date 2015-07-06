/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing7;

/**
 *
 * @author c1409l3544
 */
public class Student {
    private String ID;
    private String name;
    private String yob;

    public Student() {
    }

    public Student(String ID, String name, String yob) {
        this.ID = ID;
        this.name = name;
        this.yob = yob;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }
    public String[] getStringArr(){
        String[] arr={this.ID,this.name,this.yob};
        return arr;
    }
}

