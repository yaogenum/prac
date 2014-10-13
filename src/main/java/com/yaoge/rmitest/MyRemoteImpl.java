package com.yaoge.rmitest;

import java.io.Serializable;

public class MyRemoteImpl implements MyRemote,Serializable{
	
	private static final long serialVersionUID = 3059641056055864344L;
	
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

}
