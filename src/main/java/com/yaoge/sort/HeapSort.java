package com.yaoge.sort;

import com.yaoge.inter.Sort;


/**
 * 堆排序
 * 改良之后的直接选择排序
 * @author Administrator
 *
 */
public class HeapSort implements Sort{

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

	public int[] startSort(int[] centerArray) {
		// TODO Auto-generated method stub
		
		int length = centerArray.length;
		for(int i=0 ; i<length ; i++) {
			getMaxHeapItem(centerArray,length-1);
			swapItem(centerArray,0,length-1-i);
			System.out.println("交换最大值："+centerArray[length-1-i]);
		}
		
		
		
		return centerArray;
	}
/**
 * 选择出最大的节点值
 * @param centerArray
 * @param lastIndex
 */
	public void getMaxHeapItem(int[] data , int lastIndex) {
		
        System.out.println("正在判断倒数第"+lastIndex+"个构造堆");
		  for(int i=(lastIndex-1)/2;i>=0;i--){  
			  
	            //k保存正在判断的节点  
	  
	            int k=i;  
	            System.out.println("选举过程中比较的节点节点"+k);
	            //如果当前k节点的子节点存在  
	  
            while(k*2+1<=lastIndex){  
	            	
	            	 System.out.println("选举过程中当前节点与子节点比较选择出最大值"+k);
	                //k节点的左子节点的索引  
	  
	                int biggerIndex=2*k+1;  
	  
	                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在  
	  
	                if(biggerIndex<lastIndex){  
	  
	                    //若果右子节点的值较大  
	  
	                    if(data[biggerIndex]<data[biggerIndex+1]){  
	  
	                        //biggerIndex总是记录较大子节点的索引  
	  
	                        biggerIndex++;  
	  
	                    }  
	  
	                }  
	  
	                //如果k节点的值小于其较大的子节点的值  
	  
	                if(data[k]<data[biggerIndex]){  
	  
	                    //交换他们  
	  
	                	swapItem(data,k,biggerIndex);  
	  
	                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值  
	  
	                    k=biggerIndex;  
	  
	                }else{  
	  
	                    break;  
	  
	                }  
	  
	            }  
	  
	        }  
	  
	    System.out.println("最大值为"+data[0]);
		
	}
	
	public void swapItem(int[] array, int t1, int t2) {
		// TODO Auto-generated method stub
		int tmp = array[t1] ;
		array[t1] = array[t2] ;
		array[t2] = tmp ;
		
	}
	
	
	
	
}
