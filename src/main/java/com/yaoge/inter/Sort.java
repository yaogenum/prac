package com.yaoge.inter;

/**
 * 排序算法实现接口
 * @author Administrator
 *
 */
public interface Sort {
	/**
	 * 提出非法子元素
	 * @param 源输入数组sourceArray
	 * @return 输出数组
	 */
	public  int[] inputSort(int[] sourceArray) ;
	
	/**
	 * 处理返回排序后的数组
	 * @param targetArray
	 * @return
	 */
	public  int[] outputSort(int targetArray[]) ;
	
	/**
	 * 使用算法进行排序
	 * @param centerArray
	 * @return
	 */
	public int[] startSort(int[] centerArray) ;
	
	/**
	 * 交换来两个数
	 * @param t1
	 * @param t2
	 */
	public  void swapItem(int[] array , int t1,int t2) ;
}
