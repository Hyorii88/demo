package project;

import java.io.Serializable;


public class Student  {
    private int id;
    private String name;
    private byte age;
    private String address;
 
    private float gpa;
 
    public Student() {
    }
 
    public Student(int id, String name, 
            String address, float gpa) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public byte getAge() {
        return age;
    }
 
    public void setAge(byte age) {
        this.age = age;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public float getGpa() {
        return gpa;
    }
 
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}