package javaSynchronized;

import helper.ComplexNumber;
import helper.Coordinates;
import helper.Helper;
import monitors.ThreadFunction;
import monitors.ThreadSharedData;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestDrive {
    public static void main(String[] args) {
        // create thread shared data number of arrived
        AtomicInteger arrivedCount = new AtomicInteger(0);

        //set common data and lock object
        LockAndData data = new LockAndData(arrivedCount);

        //create threads and inject shared data and its responsible coordinates in matrix
        Thread thread0 = new Thread(new SyncThreadFunction(data, new Coordinates(0, 4096, 0, 4096)));
        Thread thread1 = new Thread(new SyncThreadFunction(data, new Coordinates(0, 4096, 4096, 8192)));
        Thread thread2 = new Thread(new SyncThreadFunction(data, new Coordinates(4096, 8192, 0, 4096)));
        Thread thread3 = new Thread(new SyncThreadFunction(data, new Coordinates(4096, 8192, 4096, 8192)));

        //start threads
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            /*Make sure all threads have finished.*/
            thread0.join();
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("All threads are finished. Good Bye...");

    }
}
