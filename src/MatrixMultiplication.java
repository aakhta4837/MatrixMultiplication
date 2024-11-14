import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MatrixMultiplication {
    public static void main(String[] args) throws Exception {
        
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrix2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        // Matrix multiplication for matrix3
        int[][] matrix3 = MultiplyMatrix(matrix1, matrix2);

        saveMatrixToFile(matrix1, "matrix1.txt");
        saveMatrixToFile(matrix2, "matrix2.txt");
        saveMatrixToFile(matrix3, "matrix3.txt");



    }

    public static int[][] MultiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix2[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void saveMatrixToFile(int[][] matrix, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int[] row : matrix) {
                for (int value : row) {  
                    writer.print(value + " ");
                }
                writer.println();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }











}