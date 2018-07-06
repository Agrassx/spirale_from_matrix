package test2.onetwotrip;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        int[][] B5 = {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 32, 24, 25}
        };

        int[][] B4 = {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };


//        printMatrix("B5", B4);
//        System.out.println(new MatrixToSpiralUtil().getSpiralString(B4));

        TxtReader reader = new TxtReader("OneTwoTrip", new File("in.txt"));
        reader.showWord();
    }

    private static void printMatrix(String name, int[][] matrix) {
        System.out.println(name + ": ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
