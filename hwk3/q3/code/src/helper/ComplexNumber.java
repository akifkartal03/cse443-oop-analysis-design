package helper;

public class ComplexNumber {
    private int real;
    private int img;

    public ComplexNumber(int real, int img) {
        this.real = real;
        this.img = img;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
    public String getNumber(){
        return String.format("%d + %di",real,img);
    }
    @Override
    public String toString() {
        return String.format("%d + %di",real,img);
    }
}
