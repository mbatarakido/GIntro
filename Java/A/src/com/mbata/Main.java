package com.mbata;

import java.time.*;

public class Main{

    public static void main(String[] args) {

        // Fetch student records from the database based on student ID
        Student model = retrieveStudentFromDB();

        // Create view to write student details in the console
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        // Display initial data
        controller.updateView();

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Period p = Period.between(LocalDate.of(2026,01,01),date);
        System.out.println(p.toTotalMonths()+" \n"+zone+" \n"+date+" \n"+time+" \n"+dateTime);
        Mobile mobile = new Mobile();
        mobile.run();

        // Update model data through controller
        controller.setStudentName("John Doe");

        // Display updated data
        controller.updateView();
    }

    private static Student retrieveStudentFromDB() {
        return new Student("1001", "Alex");
    }
}