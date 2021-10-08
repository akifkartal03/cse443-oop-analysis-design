package com.Akif;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OttomanWoman implements Runnable{
    private ThreadData data;

    public OttomanWoman(ThreadData data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (data.getEnemyPower().get() > 0){
            data.getMutex().lock();
            try{
                while(data.getNumberOfArrow().get() == data.getUpperBound()){
                    data.getEmpty().await();
                }
                if(data.getEnemyPower().get() > 0){
                    System.out.println(Thread.currentThread().getName()+" brought a new arrow.");
                    data.getNumberOfArrow().getAndIncrement();
                    Thread.sleep(1);
                    data.getFull().signalAll();
                }
                else{
                    data.getNumberOfArrow().getAndIncrement();
                    data.getFull().signalAll();
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                data.getMutex().unlock();
            }
        }
        System.out.println("Enemy Power Ottoman: " + data.getEnemyPower().get());
        System.out.println("Enemy was killed!!");
    }
}
