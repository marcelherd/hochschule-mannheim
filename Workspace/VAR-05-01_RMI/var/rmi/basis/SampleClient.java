package var.rmi.basis;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SampleClient {

	public static void main(String[] args) {
		try {
			Provider remoteObject = (Provider) Naming.lookup("//localhost:1099/SummenbildungsService");
			System.out.println("1+2=" + remoteObject.sum(1, 2));
		} catch (MalformedURLException | RemoteException | NotBoundException ex) {
			System.err.println(ex.toString());
		}
	}

}
