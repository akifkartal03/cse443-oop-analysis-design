package helper;

import java.util.Random;

public class Helper {
    public static ComplexNumber addNumbers(ComplexNumber number1, ComplexNumber number2){
        return new ComplexNumber(number1.getReal()+number2.getReal(),number1.getImg()+number2.getImg());
    }
    public static ComplexNumber[][] createMatrix(){
        ComplexNumber[][] matrix = new ComplexNumber[8192][8192];
        Random rand = new Random();
        for (int i = 0; i < 8192; i++) {
            for (int j = 0; j < 8192; j++) {
                matrix[i][j] = new ComplexNumber(rand.nextInt(30) + 1, rand.nextInt(30) + 1);
            }
            System.out.print("\n");
        }
        return matrix;
    }
}
