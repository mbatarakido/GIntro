package com.mbata;

class A {
    public void run() {
        for(int count = 0; count <= 1; count++) {
            System.out.println("in Thread Execution Class");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class B extends A implements Runnable{
    @Override
    public void run() {
        super.run();
    }
}
