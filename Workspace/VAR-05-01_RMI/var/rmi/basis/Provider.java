package var.rmi.basis;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Provider extends Remote {
	public int sum(int a, int b) throws RemoteException;
}
