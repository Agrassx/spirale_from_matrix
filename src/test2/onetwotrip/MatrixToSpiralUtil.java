package test2.onetwotrip;

import test2.onetwotrip.exceptions.SquareException;

import java.util.Random;

public class MatrixToSpiralUtil {

    private final static int LEFT = 0;
    private final static int RIGHT = 1;
    private final static int DOWN = 2;
    private final static int UP = 3;
    private final static int ERROR = -1;

    private int currentCol;
    private int currentRow;
    private int currentDirection;
    private int matrixSize;
    private int stepSize;

    public MatrixToSpiralUtil() {

    }

    public int[][] generateRandomMatrix(int N, int bound) {
        int[][] matrix = new int[2 * N - 1][2 * N - 1];
        Random random = new Random();
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                matrix[i][j] = random.nextInt(bound);
            }
        }
        return matrix;
    }

    public String getSpiralString(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            new SquareException("Matrix must be square").printStackTrace();
            return null;
        }

        int centralIndex = (matrix.length - 1) / 2;
        String result = "" + matrix[centralIndex][centralIndex];
        matrixSize = matrix.length * matrix.length;
        stepSize = 1;
        currentCol = centralIndex;
        currentRow = centralIndex;
        currentDirection = LEFT;

        while(matrixSize > 1) {
             result = step(matrix, result);
        }

        return result;
    }

    private String step(int[][] matrix, String result) {
        StringBuilder resultBuilder = new StringBuilder(result);
        for (int i = 0; i < stepSize; i++) {
            switch (currentDirection) {
                case LEFT:
                    resultBuilder.append(" ") .append(turnLeft(matrix));
                    break;
                case DOWN:
                    resultBuilder.append(" ").append(turnDown(matrix));
                    break;
                case RIGHT:
                    resultBuilder.append(" ").append(turnRight(matrix));
                    break;
                case UP:
                    resultBuilder.append(" ").append(turnUp(matrix));
                    break;
                case ERROR:
                    new Exception("Direction Error").printStackTrace();
                    break;
            }
            matrixSize--;
        }

        currentDirection = changeDirection(currentDirection);
        if ((currentDirection == LEFT || currentDirection == RIGHT) && stepSize < matrix.length - 1) stepSize++;
        return resultBuilder.toString();
    }

    private int changeDirection(int direction) {

        /* TODO
         * Тут можно поразвлекаться сделать
         * спираль которая будет завиваться
         * по часовой или против часовой стрелки
         */
        switch (direction) {
            case LEFT: return DOWN;
            case DOWN: return RIGHT;
            case RIGHT: return UP;
            case UP: return LEFT;
        }
        return ERROR;
    }

    private int turnLeft(int[][] matrix) {
        currentCol--;
        return matrix[currentRow][currentCol];
    }

    private int turnDown(int[][] matrix) {
        currentRow++;
        return matrix[currentRow][currentCol];
    }

    private int turnRight(int[][] matrix) {
        currentCol++;
        return matrix[currentRow][currentCol];
    }

    private int turnUp(int[][] matrix) {
        currentRow--;
        return matrix[currentRow][currentCol];
    }

}
