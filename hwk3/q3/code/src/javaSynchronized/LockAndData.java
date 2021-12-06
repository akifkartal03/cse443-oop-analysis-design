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
}
