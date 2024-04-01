package org.example;

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for(int i=0; i<10; i++){
                System.out.println("Runner1: "+i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<10; i++){
                System.out.println("Runner2: "+i);
            }
        });

        t1.start();
        t2.start();
    }
}