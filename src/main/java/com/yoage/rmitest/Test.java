package com.yoage.rmitest;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RMIServerSocket rmi =new RMIServerSocket();
		System.out.println("准备开启");
		rmi.startService();
		System.out.println("开启ok");
		System.out.println("准备RMI INVOKE");
		ClientSocketInvoke client = new ClientSocketInvoke();
		client.startRMIInvoke();
		System.out.println("RMI INVOKE ok");
	}

}
