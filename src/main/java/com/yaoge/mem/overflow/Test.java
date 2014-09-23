package com.yaoge.mem.overflow;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongTimeThread mem = null;
		
		for(int i=0 ; i<1000000; i++) {
			mem = new LongTimeThread();
			System.out.println("开始启动");
			mem.start();
		}
			
		System.out.println("测试结束");
	
		
		
		
	}

}
