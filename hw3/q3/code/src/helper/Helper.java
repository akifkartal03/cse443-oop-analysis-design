package helper;
import java.util.Random;

/***
 * This class contains important methods for projet
 */
public class Helper {
    /***
     * add two complex number and return addition result
     * @param number1 complex number1
     * @param number2 complex number2
     * @return  addition result
     */
    public static ComplexNumber addNumbers(ComplexNumber number1, ComplexNumber number2){
        return new ComplexNumber(number1.getReal()+number2.getReal(),number1.getImg()+number2.getImg());
    }

    /***
     * Create a 4096x4096 random complex number matrix
     * @return a 4096x4096 random complex number matrix
     */
    public static ComplexNumber[][] createRandomMatrix(){
        ComplexNumber[][] matrix = new ComplexNumber[8192][8192];
        Random rand = new Random();
        for (int i = 0; i < 4096; i++) {
            for (int j = 0; j < 4096; j++) {
                matrix[i][j] = new ComplexNumber(rand.nextInt(30) + 1, rand.nextInt(30) + 1);
                //System.out.print(matrix[i][j].toString());
            }
            //System.out.print("\n");
        }
        return matrix;
    }
}
