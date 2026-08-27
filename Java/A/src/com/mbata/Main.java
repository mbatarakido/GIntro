package com.mbata;

import java.time.*;

public class Main{

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Period p = Period.between(LocalDate.of(2026,01,01),date);

        System.out.println(p.toTotalMonths()+" \n"+zone+" \n"+date+" \n"+time+" \n"+dateTime);

        Mobile mobile = new Mobile();
        mobile.run();

    }
}