package var.rmi.chat;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("serial")
public class ChatServer extends UnicastRemoteObject implements ChatServerInterface {
	List<ChatClientInterface> mRemoteClients = Collections.synchronizedList(new ArrayList<ChatClientInterface>());

	public ChatServer() throws RemoteException {
	}

	public void enter(String username, ChatClientInterface remoteClient) throws RemoteException {
		postMessage(username + " enters", "sysop");
		mRemoteClients.add(remoteClient);
	}

	public void leave(ChatClientInterface remoteClient) throws RemoteException {
		postMessage(remoteClient.getUser() + " leaves", "sysop");
		mRemoteClients.remove(remoteClient);
	}

	public void postMessage(String message, String user) {
		for (ChatClientInterface remote : mRemoteClients) {
			try {
				remote.receiveMessage(message, user);
			} catch (RemoteException ex) {
				// z.B. Verbindungsfehler
			}
		}
	}

	public static void main(String args[]) {
		try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind(Conf.CHATSERVICE, new ChatServer());
			System.out.println("HELLO");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}