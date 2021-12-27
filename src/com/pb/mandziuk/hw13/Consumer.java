package com.pb.mandziuk.hw13;

public class Consumer implements Runnable {
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }


    public void run() {
        for (int i=1; i<5; i++){
            store.get();
        }

    }
}
