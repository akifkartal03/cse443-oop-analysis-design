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
    public static void main(String[] args) throws IOException, InterruptedException {
        // create thread shared data
        ReentrantLock mutex = new ReentrantLock();
        Condition cond= mutex.newCondition();
        AtomicInteger arrivedCount = new AtomicInteger(0);

        //set common data
        ThreadSharedData data= new ThreadSharedData(arrivedCount,mutex,cond);

        data.setMatrixA(Helper.createRandomMatrix());
        data.setMatrixB(Helper.createRandomMatrix());
        data.setMatrixSum(new ComplexNumber[8192][8192]);
        data.setMainArrived(new AtomicInteger(0));
        ReentrantLock mutex2 = new ReentrantLock();
        Condition cond2= mutex2.newCondition();
        data.setCond2(cond2);
        data.setMutex2(mutex2);

        //Helper.writeToFile(data.getMatrixA(),"matrixA.txt");
        //Helper.writeToFile(data.getMatrixB(),"matrixB.txt");


        //create threads and inject shared data and its responsible coordinates in matrix
        Thread thread0 = new Thread(new ThreadFunction(data,new Coordinates(0,500,0,500)));
        Thread thread1 = new Thread(new ThreadFunction(data,new Coordinates(0,500,500,1000)));
        Thread thread2 = new Thread(new ThreadFunction(data,new Coordinates(500,1000,0,500)));
        Thread thread3 = new Thread(new ThreadFunction(data,new Coordinates(500,1000,500,1000)));

        //start threads
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

        /*data.getMutex2().lock(); // lock(m)
        try{
            if(data.getMainArrived().get() < 4){
                data.getCond2().await(); // cwait(c,m)
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            data.getMutex2().unlock(); // unlock(m)
        }
        Helper.writeToFile(data.getMatrixSum(),"matrixSum.txt");*/


    }
}
