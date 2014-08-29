package com.yaoge.threadlocal;

public class ThreadLocalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread my1=new MyThread();
		MyThread my2=new MyThread();
		my1.setNames("my1");
		my1.setInts(1);
		my2.setNames("my2");
		my2.setInts(2);
		my2.start();
		my1.start();
		
	}

}
