package com.yaoge.mem.overflow;

public class AllocateMem {
	public static StringBuilder builder = new StringBuilder();
	
	private static ThreadLocal<AllocateMem> local = new ThreadLocal<AllocateMem>();
	
	public byte bytes[] = new byte[1000000];
	
	public  void memOutMethod() {
		local.set(this);
	}
	
	
}
