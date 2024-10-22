import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatrixMultiplicationServer2 extends UnicastRemoteObject implements MatrixMultiplication {

    protected MatrixMultiplicationServer2() throws RemoteException {
        super();
    }

    @Override
    public int[][] multiply(int[][] matrix1, int[][] matrix2) throws RemoteException {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("Matrix multiplied by Server2.");
        return result;
    }

    public static void main(String[] args) {
        try {
            // server 2 with port 1100
            MatrixMultiplicationServer2 server = new MatrixMultiplicationServer2();
            Naming.rebind("rmi://localhost:1100/MatrixMultiplyServer2", server);
            System.out.println("Matrix Multiplication Server2 is running...");
        } catch (Exception e) {
            System.out.println("Error on Server2: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
