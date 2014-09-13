package com.yaoge.sort;

public class AllSort {
	
	public static void main(String args[] ) {
		BruteSort brute = new BruteSort() ;
		int array[] = {5,7,1,9,2} ;
		array = brute.outputSort(brute.startSort(brute.inputSort(array)));
		
		for(int i : array) {
			System.out.print(i);
		}
	}
	
}
