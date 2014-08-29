package com.yaoge.threadlocal;

public class CoreThreadLocal {
	  public static void main(String[] args) {  
	        new Thread(new TestRunnable("name1", 1000L, true)).start();  
	        new Thread(new TestRunnable("name2", 700L, true)).start();  
	        new Thread(new TestRunnable("name3", 888, false)).start();  
	    }  
}
