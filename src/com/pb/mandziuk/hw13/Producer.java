package com.pb.mandziuk.hw13;

public class Producer implements Runnable {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

       public void run() {
        for (int i=1; i<5; i++){
            store.put();
        }

    }
}
