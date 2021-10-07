package com.Akif;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        List<String > buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        Thread producerThread = new Thread(new Producer(buffer,bufferLock));
        producerThread.setName("producerThread");
        Thread consumerThread = new Thread(new Consumer(buffer,bufferLock));
        consumerThread.setName("consumerThread");

        producerThread.start();
        consumerThread.start();



    }
}
