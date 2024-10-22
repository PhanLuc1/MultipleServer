import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatrixMultiplicationServer1 extends UnicastRemoteObject implements MatrixMultiplication {

    protected MatrixMultiplicationServer1() throws RemoteException {
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
        System.out.println("Matrix multiplied by Server1.");
        return result;
    }

    public static void main(String[] args) {
        try {
            // that server1 with url and port 1099`
            MatrixMultiplicationServer1 server = new MatrixMultiplicationServer1();
            Naming.rebind("rmi://localhost:1099/MatrixMultiplyServer1", server);
            System.out.println("Matrix Multiplication Server1 is running...");
        } catch (Exception e) {
            System.out.println("Error on Server1: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
