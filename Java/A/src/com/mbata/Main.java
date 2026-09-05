package com.mbata;

import java.time.*;

public class Main{

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Period p = Period.between(LocalDate.of(2026,01,01),date);
        System.out.println("No of months: "+p.toTotalMonths()+" \n"+zone+" \n"+date+" \n"+time+" \n"+dateTime);

        // Fetch student records from the database based on student ID
        Student model = retrieveStudentFromDB();

        // Create view to write student details in the console
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        // Display initial data
        controller.updateView();

        B child = new B();
        child.run();

        // Update model data through controller
        controller.setStudentName("James Gosling");

        // Display updated data
        controller.updateView();
    }

    private static Student retrieveStudentFromDB() {
        return new Student("1001", "Allan Turing");
    }
}