package var.rmi.poll;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.EnumMap;
import java.util.Map;

import var.rmi.basis.ProviderImpl;

@SuppressWarnings("serial")
public class BallotBox extends UnicastRemoteObject implements BallotBoxInterface {
	private Map<Choice, Integer> mVotes = new EnumMap<Choice, Integer>(Choice.class);

	public BallotBox() throws RemoteException {
		super();
	}

	@Override
	public synchronized void vote(Choice choice) throws RemoteException {
		Integer votes = mVotes.get(choice);
		if (votes == null)
			votes = 0;
		mVotes.put(choice, votes + 1);
	}

	@Override
	public synchronized int countVotes() throws RemoteException {
		int sum = 0;
		for (Map.Entry<Choice, Integer> choice : mVotes.entrySet()) {
			sum += choice.getValue();
		}
		return sum;
	}

	@Override
	public synchronized int getNumberOfVotes(Choice choice) throws RemoteException {
		Integer votes = mVotes.get(choice);
		if (votes == null)
			votes = 0;
		return votes;
	}

	public static void main(String args[]) throws RemoteException, MalformedURLException  {
		LocateRegistry.createRegistry(1099);
		Naming.rebind("//localhost:1099/umfrage4711", new BallotBox());
	}
}
