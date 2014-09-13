package com.yaoge.sort;

import com.yaoge.inter.Sort;

public class BruteSort implements Sort{
	
	public  int[] inputSort(int[] sourceArray) {
		
		if(sourceArray.length<=0){
			return null;
		}
		else{
			return sourceArray.clone();
		}
	}
	public  int[] outputSort(int targetArray[]) {
		
		if(targetArray.length<=0) {
			return null;
		}
		else{
			return targetArray.clone();
		}	
		
	}
	public int[] startSort(int[] centerArray) {
		
		int length=centerArray.length;
		int tmp;
		for(int i=0 ; i<length ; i++) {
			
			for(int j=i+1 ; j<length ; j++) {
				
				if(centerArray[i] < centerArray[j]) {
					tmp = centerArray[i] ;
					centerArray[i] = centerArray[j] ;
					centerArray[j] = tmp ;
				}
				
			}
		}
		
		return centerArray;
	}
	
	public <T> void swapItem(T[] swapArray,int t1,int t2) {
		T tmp=swapArray[t2];
		swapArray[t2]=swapArray[t1];
		swapArray[t1]=tmp;
	}
	
	
}
