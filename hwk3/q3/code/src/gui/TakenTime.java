package gui;

public class TakenTime {
    private int type;
    Long time;

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
    public Long getDiffer(TakenTime tk1,TakenTime tk2){
        return tk1.getTime() - tk2.getTime();
    }
}
