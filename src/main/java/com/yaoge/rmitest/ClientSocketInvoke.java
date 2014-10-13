package com.yaoge.rmitest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientSocketInvoke {
	
	public void startRMIInvoke() {
		try {
			MyRemoteImpl remote = (MyRemoteImpl) Naming.lookup("rmi://127.0.0.1:10010/MyRemote");
			
			System.out.println(remote.add(2,5));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
