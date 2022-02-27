package monitors;

import helper.ComplexNumber;
import helper.Coordinates;
import helper.Helper;

/***
 * This is a class which implements runnable interface
 * to use as a different thread.
 */
public class ThreadFunction implements Runnable{
    //shared data between threads
    private ThreadSharedData data;
    //coordinates on matrix for current thread.
    private Coordinates coordinates;

    //inject data and coordinates
    public ThreadFunction(ThreadSharedData data ,Coordinates coordinates) {
        this.data = data;
        this.coordinates = coordinates;
    }
    /***
     * this is the function that thread will run.
     */
    @Override
    public void run() {
        //task1
        for (int i = coordinates.getxLow(); i < coordinates.getxUp() ; i++) {
            for (int j = coordinates.getyLow(); j <coordinates.getyUp() ; j++) {
                data.setSumByIndex(i,j, Helper.addNumbers(data.getAByIndex(i,j),data.getBByIndex(i,j)));
            }
        }
        /*check barrier!!!*/
        data.getMutex().lock(); // lock(m)
        try{
            data.getArrived().getAndIncrement(); // ++arrived
            if(data.getArrived().get() < 4){
                data.getCond().await(); // cwait(c,m)
            }
            else{
                data.getCond().signalAll(); // broadcast(c)
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            data.getMutex().unlock(); // unlock(m)
        }
        //task2
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

    }
}

