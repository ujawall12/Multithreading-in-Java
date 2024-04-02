package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

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



        // Join method
        /*
         * The join method is used to wait for a thread to finish.
         */

        t1.join();
        System.out.println("Finished with threads"); // Waits for the first thread to finish the execution.
    }


}