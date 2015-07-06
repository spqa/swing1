/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingDB;

/**
 *
 * @author QuangAnh
 */
public class Student {
    private String ID;
    private String name;
    private String address;

    public Student() {
    }

    public Student(String ID, String name, String address) {
        this.ID = ID;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String[] getStringArr(){
        String[] arr={this.ID,this.address,this.name};
        return arr;
    }
}
