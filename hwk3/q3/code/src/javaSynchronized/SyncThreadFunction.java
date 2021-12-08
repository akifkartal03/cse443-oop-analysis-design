package javaSynchronized;

import helper.ComplexNumber;
import helper.Coordinates;
import helper.Helper;

public class SyncThreadFunction implements Runnable{
    private final LockAndData lockData;
    private Coordinates coordinates;

    public SyncThreadFunction(LockAndData lockData, Coordinates coordinates) {
        this.lockData = lockData;
        this.coordinates = coordinates;
    }

    @Override
    public void run() {
        System.out.println("Task1 -> XStart: " + coordinates.getxLow() + " YStart: "+ coordinates.getyLow());
        for (int i = coordinates.getxLow(); i < coordinates.getxUp() ; i++) {
            for (int j = coordinates.getyLow(); j <coordinates.getyUp() ; j++) {
                lockData.setSumByIndex(i,j, Helper.addNumbers(lockData.getAByIndex(i,j),lockData.getBByIndex(i,j)));
            }
        }
        synchronized (lockData){
            try{
                lockData.getArrived().getAndIncrement(); // ++arrived
                if(lockData.getArrived().get() < 4){
                    lockData.wait(); // cwait(c,m)
                }
                else{
                    lockData.notifyAll(); // broadcast(c)
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //System.out.println("Task2 -> XStart: " + coordinates.getxLow() + " YStart: "+ coordinates.getyLow());
        }
        int n = (coordinates.getxUp() - coordinates.getxLow());
        int k = 0;
        for (int i = coordinates.getxLow(); i < coordinates.getxUp() ; i++) {
            double sumReal = 0;
            double sumImag = 0;
            for (int j = coordinates.getyLow(); j <coordinates.getyUp() ; j++) {
                double angle = (2 * Math.PI * k * coordinates.getPortion()) / n;
                sumReal +=  lockData.getSumByIndex(i,j).getReal() * Math.cos(angle) +
                        lockData.getSumByIndex(i,j).getImg() * Math.sin(angle);
                sumImag += -1*lockData.getSumByIndex(i,j).getReal() * Math.sin(angle) +
                        lockData.getSumByIndex(i,j).getImg() * Math.cos(angle);
                System.out.print(lockData.getSumByIndex(i,j).getReal() + " ");
            }
            System.out.print("\n");
            lockData.setResByIndex(coordinates.getPortion(),k,new ComplexNumber((int)sumReal,
                    (int)sumImag));
            k++;
        }
    }
}
