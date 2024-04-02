package org.example;

import java.util.ArrayList;
import java.util.List;

class WaitAndNotify {

    private final Integer UPPER_LIMIT = 5;
    private final Integer LOWER_LIMIT = 0;
    private  Integer value = 0;
//    private final Object lock = new Object();

    List<Integer> list = new ArrayList<>();

    public void producer() throws InterruptedException {
        synchronized (this){
            while(true){
                if(list.size() == UPPER_LIMIT){
                    System.out.println("Wating for the thread to remove items");
//                    lock.wait();
                    wait();
                }
                else{
                    System.out.println("Adding values in the list: "+value);
                    list.add(value++);
//                    lock.notify();
                    notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consumer() throws InterruptedException{
        synchronized (this){
            while(true){
                if(list.size() == LOWER_LIMIT){
                    System.out.println("Waiting for the thread to add the elements");
//                    lock.wait();
                    wait();
                }
                else{
                    System.out.println("Removed: "+list.remove(--value));
//                    lock.notify();
                    notify();
                }
                Thread.sleep(500);
            }
        }
    }
}

public class TestWaitAndNotify {

    static WaitAndNotify processor = new WaitAndNotify();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}

