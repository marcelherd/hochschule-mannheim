package var.rmi.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServerInterface extends Remote {

	public void enter(String username, ChatClientInterface client) throws RemoteException;

	public void leave(ChatClientInterface client) throws RemoteException;

	public void postMessage(String message, String senderUsername) throws RemoteException;

}