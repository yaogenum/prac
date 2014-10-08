package com.yaoge.minchat;

public class Ptest {

	 int i ;
	 private Ptest(){
		 System.out.println("s");
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ptest p =new Ptest() ;
		System.out.println(p.i);
	}

}
