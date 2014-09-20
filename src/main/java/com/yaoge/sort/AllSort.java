package com.yaoge.sort;

public class AllSort {
	
	public static void main(String args[] ) {
		BruteSort brute = new BruteSort() ;
		int array[] = {5,7,1,9,2} ;
		array = brute.outputSort(brute.startSort(brute.inputSort(array)));
		for(int i : array) {
			System.out.print(i);
		}
		Object i=null;
		if(i == null) {
			System.out.println("ok");
		}
		HeapSort sort = new HeapSort();
		
		int arrays[] = {3,4,1,12,34,89,123,5,7,9,45,12,78,2} ;
		
		System.out.println("length:"+arrays.length);
		
		arrays = sort.startSort(arrays);
		
		
		System.out.println("length:"+arrays.length);
		for(int k = 0 ; k < arrays.length ; k++) {
			System.out.println(arrays[k]);
		}
		
		
		
	}
	
	
}
