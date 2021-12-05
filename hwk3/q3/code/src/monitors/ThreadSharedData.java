package monitors;

import helper.ComplexNumber;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSharedData {
    //private ComplexNumber[][] matrixA;
    //private ComplexNumber[][] matrixB;
    //private ComplexNumber[][] matrixSum;
    private AtomicInteger arrived;
    private ReentrantLock mutex;
    private Condition cond;

    public ThreadSharedData(AtomicInteger arrived, ReentrantLock mutex, Condition cond) {
        this.arrived = arrived;
        this.mutex = mutex;
        this.cond = cond;
    }

    public AtomicInteger getArrived() {
        return arrived;
    }

    public void setArrived(AtomicInteger arrived) {
        this.arrived = arrived;
    }

    public ReentrantLock getMutex() {
        return mutex;
    }

    public void setMutex(ReentrantLock mutex) {
        this.mutex = mutex;
    }

    public Condition getCond() {
        return cond;
    }

    public void setCond(Condition cond) {
        this.cond = cond;
    }
}
