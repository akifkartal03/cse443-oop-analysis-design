package javaSynchronized;

import helper.ComplexNumber;
import helper.Coordinates;
import helper.Helper;

import java.util.concurrent.atomic.AtomicInteger;

/***
 * Test class for java synchronized mechanism
 */
public class SyncTestDrive {
    /***
     * main function
     * @param args params
     */
    public static void main(String[] args) {
        // create thread shared data number of arrived
        AtomicInteger arrivedCount = new AtomicInteger(0);

        //set common data and lock object
        LockAndData data = new LockAndData(arrivedCount);
        data.setMatrixA(Helper.createRandomMatrix());
        data.setMatrixB(Helper.createRandomMatrix());
        data.setMatrixSum(new ComplexNumber[4096][4096]);

        //create threads and inject shared data and its responsible coordinates in matrix
        Thread thread0 = new Thread(new SyncThreadFunction(data, new Coordinates(0, 2048, 0, 2048, 0)));
        Thread thread1 = new Thread(new SyncThreadFunction(data, new Coordinates(0, 2048, 2048, 4096, 1)));
        Thread thread2 = new Thread(new SyncThreadFunction(data, new Coordinates(2048, 4096, 0, 2048, 2)));
        Thread thread3 = new Thread(new SyncThreadFunction(data, new Coordinates(2048, 4096, 2048, 4096, 3)));

        System.out.println("Threads are starting...");
        long start = System.currentTimeMillis();
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

        long time = System.currentTimeMillis() - start;
        System.out.println("Time Taken in java synchronized: " + time + " ms");
        System.out.println("All threads are finished. Good Bye...");

    }
}
