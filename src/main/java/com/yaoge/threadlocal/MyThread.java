package com.yaoge.threadlocal;

public class MyThread extends Thread{
	public int i;
	public String name = null;
	public void  setNames(String name) {
		this.name = name ;
	}
	public void setInts(int a) {
		this.i = a ;
		
	}
	
	@Override
	public void run() {
		  for(int a=0;a<5;a++) {
			  i++;
			  System.out.println(name+":"+MyThread.class.getName()+":"+i);
		  }
	}
}
