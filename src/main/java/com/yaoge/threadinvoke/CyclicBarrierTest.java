package com.yaoge.threadinvoke;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 10 ;
		final CyclicBarrier cb = new CyclicBarrier(count) ;
		
		ExecutorService threadpool = Executors.newFixedThreadPool(count) ;
		
		System.out.println("CyclicBarrier start work ");
		
		for(int i = 0 ; i<10; i++) {
			threadpool.execute(new Worker(cb,"thread"+i,2000));
		}
		try {
			System.out.println("CyclicBarrier start wait");
			cb.await();
			System.out.println("CyclicBarrier end wait");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("CyclicBarrier end work ");
		
		
		
		
		
		
	}

}
