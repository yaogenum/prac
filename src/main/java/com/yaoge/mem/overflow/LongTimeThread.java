package com.yaoge.mem.overflow;

public class LongTimeThread  extends Thread{
		
	@Override
	public void run() {
		try {
			AllocateMem men;
			try {
				men = (AllocateMem) Class.forName("com.yaoge.mem.overflow.AllocateMem").newInstance();
//				men.memOutMethod();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
