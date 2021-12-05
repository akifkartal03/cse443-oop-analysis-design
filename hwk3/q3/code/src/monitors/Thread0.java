package monitors;

public class Thread0 implements Runnable{
    private ThreadSharedData data;

    public Thread0(ThreadSharedData data) {
        this.data = data;
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("Thread0 task1");
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
        System.out.println("Thread0 task2 "+"Arrived: "+data.getArrived().get());
    }
}
