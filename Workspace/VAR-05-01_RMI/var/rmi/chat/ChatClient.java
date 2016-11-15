package var.rmi.chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * RMI Chat Client
 * 
 * @author Marcel Herd (1527440) <me@marcelherd.com>
 */
public class ChatClient extends UnicastRemoteObject implements ChatClientInterface {

	private static final long serialVersionUID = -6978055884469542062L;
	
	private static final String CMD_LEAVE = "leave chat";
	
	private String user;

	protected ChatClient() throws RemoteException {
		this("Anonymous");
	}
	
	public ChatClient(final String user) throws RemoteException {
		this.user = user;
	}

	/**
	 * Invoked via RMI by ChatServer to send a message to the client.
	 * 
	 * @param message The message string
	 * @param sender  The sender of the message
	 */
	@Override
	public void receiveMessage(String message, String sender) throws RemoteException {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		String formattedMessage = String.format("[%s] <%s> %s", sdf.format(now), sender, message);
		
		System.out.println(formattedMessage);
	}

	/**
	 * Returns the username of this client.
	 * 
	 * @return the username of this client
	 */
	@Override
	public String getUser() throws RemoteException {
		return user;
	}
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: java -Djava.security.policy=$policyfile ChatClient $username");
			System.exit(-1);
		} else {
			System.setSecurityManager(new SecurityManager());
			
			try (Scanner scanner = new Scanner(System.in)) {
				ChatClient chatClient = new ChatClient(args[0]);
				
				ChatServerInterface server = (ChatServerInterface) Naming.lookup(Conf.CHATSERVICE);
				server.enter(chatClient.getUser(), chatClient);
				
				boolean connected = true;
				
				while (connected) {
					System.out.print("Message: ");
					String message = scanner.nextLine();
					
					switch (message) {
						case ChatClient.CMD_LEAVE:
							server.leave(chatClient);
							connected = false;
							break;
						default:
							server.postMessage(message, chatClient.getUser());
					}
				}
				
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				e.printStackTrace();
			}
		}
	}

}
