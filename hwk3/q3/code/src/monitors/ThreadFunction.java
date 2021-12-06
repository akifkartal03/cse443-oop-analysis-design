package monitors;

import helper.Coordinates;
import helper.Helper;

public class ThreadFunction implements Runnable{
    private ThreadSharedData data;
    private Coordinates coordinates;

    public ThreadFunction(ThreadSharedData data ,Coordinates coordinates) {
        this.data = data;
        this.coordinates = coordinates;
    }

    @Override
    public void run() {
        System.out.println("Task1 -> XStart: " + coordinates.getxLow() + " YStart: "+ coordinates.getyLow());
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
        System.out.println("Task2 -> XStart: " + coordinates.getxLow() + " YStart: "+ coordinates.getyLow());

    }
}

