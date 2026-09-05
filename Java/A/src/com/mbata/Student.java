package com.mbata;

// the Model
public class Student {
    private String studentName;
    private String studentID;

    public Student(String studentID, String studentName) {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    public String getName() {
        return studentName;
    }

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public String getID() {
        return studentID;
    }

    public void setID(String studentID) {
        this.studentID = studentID;
    }
}
