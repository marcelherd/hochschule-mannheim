package var.rmi.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClientInterface extends Remote {

	public void receiveMessage(String message, String sender) throws RemoteException;

	public String getUser() throws RemoteException;

}