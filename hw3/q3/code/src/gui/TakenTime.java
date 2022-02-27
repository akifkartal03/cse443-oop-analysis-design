package gui;

/***
 * This class is to measure time gained by using multiple threads
 * (with respect to using a single thread) at the end of the calculations.
 */
public class TakenTime {
    private Long time; // how many ms is passed
    private int type; //multiple or single

    public TakenTime(int type, Long time) {
        this.type = type;
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    /***
     * get time difference in ms
     * @param tk1 time1
     * @param tk2 time 2
     * @return time difference in ms
     */
    public Long getDiffer(TakenTime tk1, TakenTime tk2) {
        return tk1.getTime() - tk2.getTime();
    }
}
