/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing6;

/**
 *
 * @author QuangAnh
 */
public class Student {
    private String id;
    private String name;
    private String classId;

    public Student() {
    }

    public Student(String id, String name, String classId) {
        this.id = id;
        this.name = name;
        this.classId = classId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
    public String[] getStringArr(){
        String[] arr={this.id,this.name,this.classId};
    return arr;
    }

    @Override
    public String toString() {
        return classId;
    }
    
}
