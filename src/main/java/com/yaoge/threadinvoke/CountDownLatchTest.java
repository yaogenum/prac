package com.yaoge.threadinvoke;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 10 ;
		final CountDownLatch cdl = new CountDownLatch(count) ;
		
		ExecutorService threadpool = Executors.newFixedThreadPool(10) ; 
		System.out.println("main start work all");
		for(int i =0 ; i<10 ;i++) {
			threadpool.execute(new Worker(cdl,"thread"+i,1000));
		}
		try {
			System.out.println("main start work wait");
			cdl.await();
			System.out.println("main end work wait");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
