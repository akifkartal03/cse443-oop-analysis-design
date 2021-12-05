package monitors;

import helper.ComplexNumber;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSharedData {
    private ComplexNumber[][] matrixA;
    private ComplexNumber[][] matrixB;
    private ComplexNumber[][] matrixSum;
    private AtomicInteger arrived;
    private ReentrantLock mutex;
    private Condition cond;
    private AtomicInteger mainArrived;
    private Condition cond2;
    private ReentrantLock mutex2;


    public ThreadSharedData(AtomicInteger arrived, ReentrantLock mutex, Condition cond) {
        this.arrived = arrived;
        this.mutex = mutex;
        this.cond = cond;
    }

    public ReentrantLock getMutex2() {
        return mutex2;
    }

    public void setMutex2(ReentrantLock mutex2) {
        this.mutex2 = mutex2;
    }

    public Condition getCond2() {
        return cond2;
    }

    public void setCond2(Condition cond2) {
        this.cond2 = cond2;
    }

    public AtomicInteger getMainArrived() {
        return mainArrived;
    }

    public void setMainArrived(AtomicInteger mainArrived) {
        this.mainArrived = mainArrived;
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
    public ComplexNumber getAByIndex(int i, int j){
        return matrixA[i][j];
    }
    public ComplexNumber getBByIndex(int i, int j){
        return matrixB[i][j];
    }
    public ComplexNumber getSumByIndex(int i, int j){
        return matrixSum[i][j];
    }
    public void setSumByIndex(int i, int j,ComplexNumber number){
        matrixSum[i][j] = number;
    }

    public void setMatrixA(ComplexNumber[][] matrixA) {
        this.matrixA = matrixA;
    }

    public void setMatrixB(ComplexNumber[][] matrixB) {
        this.matrixB = matrixB;
    }

    public void setMatrixSum(ComplexNumber[][] matrixSum) {
        this.matrixSum = matrixSum;
    }

    public ComplexNumber[][] getMatrixA() {
        return matrixA;
    }

    public ComplexNumber[][] getMatrixB() {
        return matrixB;
    }

    public ComplexNumber[][] getMatrixSum() {
        return matrixSum;
    }
}
