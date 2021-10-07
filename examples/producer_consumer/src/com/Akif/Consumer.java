package com.Akif;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable{
    private List<String> buffer;
    private ReentrantLock bufferLock;

    public Consumer(List<String> buffer, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }
    @Override
    public void run() {
        while(true){
            bufferLock.lock();
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals("EOF")) {
                    System.out.println(Thread.currentThread().getName() + " exiting.");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " removed " + buffer.remove(0));
                    try {

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " interrupted.");
                    }
                }
            } finally {
                bufferLock.unlock();
            }
        }
    }
}
