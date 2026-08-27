package com.mbata;

class Computers{
    public void run() {
        for(int count = 0; count <= 5; count++) {
            System.out.println("in Computers run Class");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Mobile extends Computers implements Runnable{

}
