package com.yaoge.sort;

import com.yaoge.inter.Sort;

/**
 * 快速排序
 * @author Administrator
 *
 */
public class QuickSort implements Sort {

	public int[] inputSort(int[] sourceArray) {
		// TODO Auto-generated method stub
		if(sourceArray.length<=0){
			return null;
		}
		else{
			return sourceArray.clone();
		}
	}

	public int[] outputSort(int[] targetArray) {
		// TODO Auto-generated method stub
		if(targetArray.length<=0) {
			return null;
		}
		else{
			return targetArray.clone();
		}	
		
	}

	public int[] startSort(int[] centerArray, int start, int end) {
		// TODO Auto-generated method stub
		if (start < end) {
			
			int flag = sortByMiddle(centerArray, start, end);
			startSort(centerArray, start, flag - 1);
			startSort(centerArray, flag + 1, end);
			
			
		}

		return centerArray;
	}

	public int sortByMiddle(int[] minArray, int start, int end) {
		int flag;
		flag = minArray[start];

		while (start < end) {

			while (start < end && minArray[end] >= flag) {
				end--;
			}
			minArray[start] = minArray[end];
			
			while (start < end && minArray[start] < flag) {
				start++;
			}
			minArray[end] = minArray[start] ;
			
		}
		
		minArray[start] = flag ;

		return start;

	}

	public void swapItem(int[] array, int t1, int t2) {
		// TODO Auto-generated method stub
		int tmp = array[t1] ;
		array[t1] = array[t2] ;
		array[t2] = tmp ;
		
	}
	public int[] startSort(int[] centerArray) {
		
		startSort(centerArray,0,centerArray.length-1);
		return centerArray;
	}

}
