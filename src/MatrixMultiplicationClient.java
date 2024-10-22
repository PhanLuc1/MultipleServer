import java.rmi.Naming;

public class MatrixMultiplicationClient {

    public static void main(String[] args) {
        try {
            int[][] matrix1 = { {1, 2, 3}, {4, 5, 6} };
            int[][] matrix2 = { {7, 8}, {9, 10}, {11, 12} };

            MatrixMultiplication server1 = (MatrixMultiplication) Naming.lookup("rmi://localhost:1099/MatrixMultiplyServer1");
            MatrixMultiplication server2 = (MatrixMultiplication) Naming.lookup("rmi://localhost:1100/MatrixMultiplyServer2");

            int[][] result1 = server1.multiply(matrix1, matrix2);
            System.out.println("Result from Server1:");
            printMatrix(result1);

            int[][] result2 = server2.multiply(matrix1, matrix2);
            System.out.println("Result from Server2:");
            printMatrix(result2);

        } catch (Exception e) {
            System.out.println("Error on client: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
