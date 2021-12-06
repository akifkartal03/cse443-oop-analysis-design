package javaSynchronized;

import helper.ComplexNumber;

import java.util.concurrent.atomic.AtomicInteger;

/***
 * This class is used for both shared data and
 * as a lock object for synchronized.
 */
public class LockAndData {
    private ComplexNumber[][] matrixA;
    private ComplexNumber[][] matrixB;
    private ComplexNumber[][] matrixSum;
    private AtomicInteger arrived;

    public LockAndData(AtomicInteger arrived) {
        this.arrived = arrived;
    }

    public AtomicInteger getArrived() {
        return arrived;
    }

    public void setArrived(AtomicInteger arrived) {
        this.arrived = arrived;
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
