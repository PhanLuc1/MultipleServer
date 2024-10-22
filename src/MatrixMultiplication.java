import java.rmi.Remote;
import java.rmi.RemoteException;
// create Interface register remote object
public interface MatrixMultiplication extends Remote {
    public int[][] multiply(int[][] matrix1, int[][] matrix2) throws RemoteException;
}