package com.Akif;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BowAndArrow implements WeaponBehavior{
    private ThreadData data;

    public BowAndArrow(ThreadData data) {
        this.data = data;
    }

    @Override
    public void useWeapon(){
        while (data.getEnemyPower().get() > 0) {
            data.getMutex().lock();
            try {
                while (data.getNumberOfArrow().get() == 0){
                    data.getFull().await();
                }
                if(data.getEnemyPower().get() > 0){
                    System.out.println(Thread.currentThread().getName()+" is using 1 arrow...");
                    data.getNumberOfArrow().getAndDecrement();
                    if (data.getNumberOfArrow().get() % 2 == 0){
                        data.getEnemyPower().set(data.getEnemyPower().get() - 10);
                    }
                    Thread.sleep(1);
                    data.getEmpty().signalAll();
                }
               else {
                    data.getEmpty().signalAll();
                    break;
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                data.getMutex().unlock();
            }
        }
        System.out.println("Enemy Power Consumer: " + data.getEnemyPower().get());

    }
}
