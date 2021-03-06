package monitors;

import helper.ComplexNumber;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/***
 * This class is used for shared data between threads
 */
public class ThreadSharedData {
    //shared matrices
    private ComplexNumber[][] matrixA;
    private ComplexNumber[][] matrixB;
    private ComplexNumber[][] matrixSum;
    private ComplexNumber[][] dftResult;

    //shared synchronization data
    private AtomicInteger arrived;
    private ReentrantLock mutex;
    private Condition cond;

    //inject some shared data
    public ThreadSharedData(AtomicInteger arrived, ReentrantLock mutex, Condition cond) {
        this.arrived = arrived;
        this.mutex = mutex;
        this.cond = cond;
        dftResult = new ComplexNumber[2048][4096];
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
    public void setResByIndex(int i, int j,ComplexNumber number){
        dftResult[i][j] = number;
    }

    public ComplexNumber[][] getDftResult() {
        return dftResult;
    }

    public void setDftResult(ComplexNumber[][] dftResult) {
        this.dftResult = dftResult;
    }
}
