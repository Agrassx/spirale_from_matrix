package test2.onetwotrip;

public class Main {

    public static void main(String[] args) {
        int[][] B5 = {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 32, 24, 25}
        };

        int[][] B3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] B2 = {
                {1, 2, 3},
                {4, 5, 6}
        };


        printMatrix("Matrix B", B3);
        System.out.println( new MatrixToSpiralUtil().getSpiralString(B2));


        int[][] randomMatrix = new MatrixToSpiralUtil().generateRandomMatrix(2, 25);

        printMatrix("Random Matrix", randomMatrix);
        System.out.println(new MatrixToSpiralUtil().getSpiralString(randomMatrix));

        printMatrix("B5", B5);
        System.out.println(new MatrixToSpiralUtil().getSpiralString(B5));
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
