package javaSynchronized;

import helper.Coordinates;
import helper.Helper;
import monitors.ThreadSharedData;

public class SyncThreadFunction implements Runnable{
    private final ThreadSharedData data;
    private Coordinates coordinates;

    public SyncThreadFunction(ThreadSharedData data ,Coordinates coordinates) {
        this.data = data;
        this.coordinates = coordinates;
    }

    @Override
    public void run() {
        System.out.println("Task1 -> XStart: " + coordinates.getxLow() + " YStart: "+ coordinates.getyLow());
        /*for (int i = coordinates.getxLow(); i < coordinates.getxUp() ; i++) {
            for (int j = coordinates.getyLow(); j <coordinates.getyUp() ; j++) {
                data.setSumByIndex(i,j, Helper.addNumbers(data.getAByIndex(i,j),data.getBByIndex(i,j)));
            }
        }*/
        synchronized (data){
            try{
                data.getArrived().getAndIncrement(); // ++arrived
                if(data.getArrived().get() < 4){
                    wait(); // cwait(c,m)
                }
                else{
                    notifyAll(); // broadcast(c)
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task2 -> XStart: " + coordinates.getxLow() + " YStart: "+ coordinates.getyLow());
        }


    }
}
