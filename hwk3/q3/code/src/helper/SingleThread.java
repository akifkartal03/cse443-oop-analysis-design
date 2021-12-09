package helper;

import javaSynchronized.LockAndData;

import java.util.concurrent.atomic.AtomicInteger;

/***
 * This is a single thread to test results
 */
public class SingleThread {

    /***
     * single thread
     * @param args params
     */
    public static void main(String[] args) {
        AtomicInteger arrivedCount = new AtomicInteger(0);
        //set common data and lock object
        LockAndData data = new LockAndData(arrivedCount);
        data.setMatrixA(Helper.createRandomMatrix());
        data.setMatrixB(Helper.createRandomMatrix());
        data.setMatrixSum(new ComplexNumber[4096][4096]);
        Coordinates coordinates = new Coordinates(0,4096,0,4096,1);

        System.out.println("Calculating is starting...");
        long start = System.currentTimeMillis();
        for (int i = coordinates.getxLow(); i < coordinates.getxUp() ; i++) {
            for (int j = coordinates.getyLow(); j <coordinates.getyUp() ; j++) {
                data.setSumByIndex(i,j, Helper.addNumbers(data.getAByIndex(i,j),data.getBByIndex(i,j)));
            }
        }
        int n = (coordinates.getxUp() - coordinates.getxLow());
        int k = 0;
        for (int i = coordinates.getxLow(); i < coordinates.getxUp() ; i++) {
            double sumReal = 0;
            double sumImag = 0;
            for (int j = coordinates.getyLow(); j <coordinates.getyUp() ; j++) {
                double angle = (2 * Math.PI * k * coordinates.getPortion()) / n;
                sumReal +=  data.getSumByIndex(i,j).getReal() * Math.cos(angle) +
                        data.getSumByIndex(i,j).getImg() * Math.sin(angle);
                sumImag += -1*data.getSumByIndex(i,j).getReal() * Math.sin(angle) +
                        data.getSumByIndex(i,j).getImg() * Math.cos(angle);
            }
            data.setResByIndex(coordinates.getPortion(),k,new ComplexNumber((int)sumReal,
                    (int)sumImag));
            k++;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Time Taken in single thread: " + time + " ms");
        System.out.println("Single thread is finished. Good Bye...");
    }
}
