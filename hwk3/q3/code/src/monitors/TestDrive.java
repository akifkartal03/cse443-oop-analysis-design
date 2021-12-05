package monitors;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestDrive {
    public static void main(String[] args) {
        // create thread shared data
        ReentrantLock mutex = new ReentrantLock();
        Condition cond= mutex.newCondition();
        AtomicInteger arrivedCount = new AtomicInteger(0);


        //set common data
        ThreadSharedData data= new ThreadSharedData(arrivedCount,mutex,cond);

        //create thread with classes and inject shared data
        Thread thread0 = new Thread(new ThreadFunction(data,new Coordinates(0,4096,0,4096)));
        Thread thread1 = new Thread(new ThreadFunction(data,new Coordinates(0,4096,4096,8192)));
        Thread thread2 = new Thread(new ThreadFunction(data,new Coordinates(4096,8192,0,4096)));
        Thread thread3 = new Thread(new ThreadFunction(data,new Coordinates(4096,8192,4096,8192)));

        //start threads
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
