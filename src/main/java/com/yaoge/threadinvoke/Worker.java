package com.yaoge.threadinvoke;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable{
	CountDownLatch cdl ;
	CyclicBarrier cb; 
	String workName ;
	int workTime ;
	Worker(CountDownLatch cdl,String workName,int workTime) {
		this.cdl = cdl ;
		this.workName = workName ;
		this.workTime = workTime;
	}
	Worker(CyclicBarrier cb ,String workName,int workTime) {
		this.cb = cb ;
		this.workName = workName ;
		this.workTime = workTime ;
	}
	public void run() {
		
		System.out.println(workName+"start work ");
		try {
			Thread.sleep(workTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(workName+"end work ");
		if(cb != null) {
			try {
				System.out.println(workName+"cyliyoierBarry停止工作 start");
				cb.await();
				System.out.println(workName+"cyliyoierBarry停止工作 end");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(cdl != null) {
			System.out.println(workName+"验证是否在coutnwork后继续运行，而不像cyliyoierBarry停止工作 start");
			cdl.countDown() ;
			System.out.println(workName+"验证是否在coutnwork后继续运行，而不像cyliyoierBarry停止工作 end");
		}
		
	}
	
}
