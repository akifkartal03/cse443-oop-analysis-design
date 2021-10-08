package com.Akif;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadData {
    private AtomicInteger numberOfArrow;
    private ReentrantLock mutex;
    private Condition full;
    private Condition empty;
    private int upperBound;
    private AtomicInteger enemyPower;

    public AtomicInteger getEnemyPower() {
        return enemyPower;
    }

    public void setEnemyPower(AtomicInteger enemyPower) {
        this.enemyPower = enemyPower;
    }

    public ThreadData(AtomicInteger numberOfArrow, ReentrantLock mutex, Condition full, Condition empty, int upperBound, AtomicInteger enemyPower) {
        this.numberOfArrow = numberOfArrow;
        this.mutex = mutex;
        this.full = full;
        this.empty = empty;
        this.upperBound = upperBound;
        this.enemyPower = enemyPower;
    }

    public AtomicInteger getNumberOfArrow() {
        return numberOfArrow;
    }

    public void setNumberOfArrow(AtomicInteger numberOfArrow) {
        this.numberOfArrow = numberOfArrow;
    }

    public ReentrantLock getMutex() {
        return mutex;
    }

    public void setMutex(ReentrantLock mutex) {
        this.mutex = mutex;
    }

    public Condition getFull() {
        return full;
    }

    public void setFull(Condition full) {
        this.full = full;
    }

    public Condition getEmpty() {
        return empty;
    }

    public void setEmpty(Condition empty) {
        this.empty = empty;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }
}
