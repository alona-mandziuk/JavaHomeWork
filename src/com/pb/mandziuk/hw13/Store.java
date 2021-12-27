package com.pb.mandziuk.hw13;

public class Store {
    private int product = 0;
    public  synchronized void get() {
        while (product < 1) {
            try {
                wait(1000);
            } catch (InterruptedException e) {

            }
        }

        product--;
        System.out.println("Kid have bought 1 KINDER");
        System.out.println("There are " + product + "eggs in the store.");
        System.out.println("**************************");
        notify();
    }

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait(2000);
            } catch (InterruptedException e) {

            }
        }
        product++;
        System.out.println("Sweetshop adds 1 more KINDER.");
        System.out.println("Available " + product + " eggs are ready to be eaten.");
        notify();
    }

}
