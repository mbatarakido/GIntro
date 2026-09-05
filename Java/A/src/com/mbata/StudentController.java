package com.mbata;

//the Controller
public class StudentController {
    Student model;
    StudentView view;

    //Constructor
    public StudentController(Student student, StudentView view) {
        this.model = student;
        this.view = view;
    }

    //Control the Model
    public void setStudentName(String studentName) {
        model.setName(studentName);
    }
    public String getStudentName() {
        return model.getName();
    }
    public void setStudentID(String studentID) {
        model.setID(studentID);
    }
    public String getStudentID() {
        return model.getID();
    }

    //Control the View Updates
    public void updateView(){
        view.printStudentDetails(model.getID(), model.getName());
    }
}
