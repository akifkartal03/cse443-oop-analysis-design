package helper;

/***
 * This class is a representation of a coordinates for threads on matrix.
 */
public class Coordinates {
    private int portion; // 0 - 1 - 2 - 3
    private int xLow;
    private int xUp;
    private int yLow;
    private int yUp;

    public Coordinates(int xLow, int xUp, int yLow, int yUp,int portion) {
        this.xLow = xLow;
        this.xUp = xUp;
        this.yLow = yLow;
        this.yUp = yUp;
        this.portion = portion;
    }

    public int getxLow() {
        return xLow;
    }

    public void setxLow(int xLow) {
        this.xLow = xLow;
    }

    public int getxUp() {
        return xUp;
    }

    public void setxUp(int xUp) {
        this.xUp = xUp;
    }

    public int getyLow() {
        return yLow;
    }

    public void setyLow(int yLow) {
        this.yLow = yLow;
    }

    public int getyUp() {
        return yUp;
    }

    public void setyUp(int yUp) {
        this.yUp = yUp;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }
}
