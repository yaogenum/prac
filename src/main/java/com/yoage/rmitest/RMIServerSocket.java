package com.yoage.rmitest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServerSocket {
	public  void startService() {
		MyRemote remoteService = new MyRemoteImpl() ;
		try {
			LocateRegistry.createRegistry(10010) ;
			Naming.rebind("rmi://127.0.0.1:10010/MyRemote", remoteService);//Naming内部使用LocateRegistry，被装饰者
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("2");
			e.printStackTrace();
		}
		finally{
			
		}
	}
	
}
