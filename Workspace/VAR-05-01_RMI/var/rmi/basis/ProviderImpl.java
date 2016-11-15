package var.rmi.basis;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class ProviderImpl extends UnicastRemoteObject implements Provider {

	protected ProviderImpl() throws RemoteException {
		super();
	}

	@Override
	public int sum(int a, int b) throws RemoteException {
		return a + b;
	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind("//localhost:1099/Addierer", new ProviderImpl());
		} catch (MalformedURLException | RemoteException e) {
			System.err.println(e);
		}

	}

}
