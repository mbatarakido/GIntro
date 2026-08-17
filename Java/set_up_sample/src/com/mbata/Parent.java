package com.mbata;

public class Parent{
    public static void main(String[] args) {
        System.out.println("Parent Class");
        Child child = new Child();
        child.methodOne();
    }
}
class Child extends Parent{
    public void methodOne(){
        System.out.println("Child methodOne");
    }
}
