package var.rmi.poll;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BallotBoxInterface extends Remote {
	public void vote(Choice choice) throws RemoteException;

	public int countVotes() throws RemoteException;

	public int getNumberOfVotes(Choice choice) throws RemoteException;
}
