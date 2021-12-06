package monitors;

import helper.ComplexNumber;
import helper.Coordinates;
import helper.Helper;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestDrive {
    public static void main(String[] args) throws IOException, InterruptedException {
        // create thread shared data
        ReentrantLock mutex = new ReentrantLock();
        Condition cond = mutex.newCondition();
        AtomicInteger arrivedCount = new AtomicInteger(0);

        //set common data
        ThreadSharedData data = new ThreadSharedData(arrivedCount, mutex, cond);

        data.setMatrixA(Helper.createRandomMatrix());
        data.setMatrixB(Helper.createRandomMatrix());
        data.setMatrixSum(new ComplexNumber[8192][8192]);

        Helper.writeToFile(data.getMatrixA(), "matrixA.txt");
        Helper.writeToFile(data.getMatrixB(), "matrixB.txt");

        //create threads and inject shared data and its responsible coordinates in matrix
        Thread thread0 = new Thread(new ThreadFunction(data, new Coordinates(0, 500, 0, 500)));
        Thread thread1 = new Thread(new ThreadFunction(data, new Coordinates(0, 500, 500, 1000)));
        Thread thread2 = new Thread(new ThreadFunction(data, new Coordinates(500, 1000, 0, 500)));
        Thread thread3 = new Thread(new ThreadFunction(data, new Coordinates(500, 1000, 500, 1000)));

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
        Helper.writeToFile(data.getMatrixSum(), "matrixSum.txt");


    }
}
