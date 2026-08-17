package com.mbata.appnum3;

class Leopard extends Cat{
    private String claws;

    public Leopard(String name, String color, int amountOfSpeed, int amountOfPower, int numOfLegs, boolean canHunt, String claws){
        super(name, color, amountOfSpeed, amountOfPower, numOfLegs, canHunt);
        this.claws = claws;
    }

    public String getClaws() {
        return claws;
    }

    public void setClaws(String claws) {
        this.claws = claws;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Claws: " + claws ;
    }
}
