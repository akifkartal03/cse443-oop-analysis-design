package helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Helper {
    public static ComplexNumber addNumbers(ComplexNumber number1, ComplexNumber number2){
        return new ComplexNumber(number1.getReal()+number2.getReal(),number1.getImg()+number2.getImg());
    }
    public static ComplexNumber[][] createRandomMatrix(){
        ComplexNumber[][] matrix = new ComplexNumber[1000][1000];
        Random rand = new Random();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = new ComplexNumber(rand.nextInt(30) + 1, rand.nextInt(30) + 1);
                //System.out.print(matrix[i][j].toString());
            }
            //System.out.print("\n");
        }
        return matrix;
    }
    public static void writeToFile(ComplexNumber[][] matrix,String name) throws IOException {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 8; i++)//for each row
        {
            for(int j = 0; j < 8; j++)//for each column
            {
                builder.append(matrix[i][j].toString()+"");//append to the output string
                if(j < matrix.length - 1)//if this is not the last row element
                    builder.append(",");//then add comma (if you don't like commas you can use spaces)
            }
            builder.append("\n");//append new line at the end of the row
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(name));
        writer.write(builder.toString());//save the string representation of the board
        writer.close();
    }
    public static void writeToFile2(ComplexNumber[][] matrix,String name) throws IOException {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 4; i++)//for each row
        {
            for(int j = 0; j < 4; j++)//for each column
            {
                builder.append(matrix[i][j].toString()+"");//append to the output string
                if(j < matrix.length - 1)//if this is not the last row element
                    builder.append(",");//then add comma (if you don't like commas you can use spaces)
            }
            builder.append("\n");//append new line at the end of the row
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(name));
        writer.write(builder.toString());//save the string representation of the board
        writer.close();
    }
}
