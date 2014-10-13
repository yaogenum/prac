package com.yoage.rmitest;

import java.rmi.Remote;

public interface MyRemote extends Remote{
	public int add(int a ,int b) ;
}
