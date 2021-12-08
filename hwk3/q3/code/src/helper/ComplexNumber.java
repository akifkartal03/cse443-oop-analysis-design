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
        if (img < 0)
            return String.format("%d - %di",real,-1*img);
        else
            return String.format("%d + %di",real,img);
    }
    @Override
    public String toString() {
        if (img < 0)
            return String.format("%d - %di",real,-1*img);
        else
            return String.format("%d + %di",real,img);
    }
}
