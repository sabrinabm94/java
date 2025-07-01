package matrixWithRandomValue;

import javaRepositories.Print;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int row = 3;
        int column = 3;
        int[][] matrix = new int[row][column]; //[linhas][colunas]

        populate(matrix, row, column);
        print(matrix, row, column);
    }

    public static int[][] populate(int[][] matrix, int row, int column) {
        Random randomGenerator = new Random();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                matrix[i][j] = randomGenerator.nextInt(10);
            }
        }

        return matrix;
    }

    public static void print(int[][] matrix, int row, int column) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                Print.print("\nrow: " + i + "\n" + "column: " + j + " " + "\nvalue: " + matrix[i][j]);
            }
        }
    }
}
