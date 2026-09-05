package com.mbata;

//the View
public class StudentView {
    public void printStudentDetails(String studentID, String studentName) {
        System.out.println("*****************************");
        System.out.println(" ----> STUDENT DETAILS <---- ");
        System.out.println("*****************************");
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + studentName);
    }
}
