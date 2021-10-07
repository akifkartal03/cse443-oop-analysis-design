package com.Akif;


import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable{
    private List<String > buffer;
    private ReentrantLock bufferLock;

    //dependency injection
    public Producer(List<String> buffer, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        String numbers[] = { "1 ","2","3"};
        for (String number:numbers
             ) {
            bufferLock.lock();
            try {
                buffer.add(number);
            }finally {
                bufferLock.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
            System.out.println(Thread.currentThread().getName() + " added " + number);

        }
        bufferLock.lock();
        try {
            buffer.add("EOF");
        }finally {
            bufferLock.unlock();
        }
    }
}
