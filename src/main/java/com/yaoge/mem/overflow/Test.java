package com.yaoge.mem.overflow;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongTimeThread mem = null;
		
/*		for(int i=0 ; i<1000000; i++) {
			mem = new LongTimeThread();
			System.out.println("开始启动");
			mem.start();
		}
*/			System.out.println("测试结束");

		Object o1 = new Object();
		Object o2 = new Object();
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		
		String s1= new String();
		String s2= new String();
		s1="2";
		s1="2"+"2";
		s1="2";
		s2="2";
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		if(o1.equals(o2)){
			System.out.println("equal");
		}
		if(s1.equals(s2)) {
			System.out.println("s equal");
		}
		if(o1==o2){
			System.out.println("s ==");
		}
		

	}

}
