package com.yaoge.quartztest;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 单例模式
 * @author Administrator
 *
 */
public class ScheduleFactoryTest {
	
	private static final SchedulerFactory factory = new StdSchedulerFactory() ;
	private static Scheduler scheduler = null ;
	
	
	private ScheduleFactoryTest() {
		System.out.println("无构造");
	}
	
	public static Scheduler getScheduler() {
		
		if(scheduler == null) {
			
			synchronized(ScheduleFactoryTest.class) {
				
				if(scheduler == null) {
					
					try {
						scheduler = factory.getScheduler() ;
					} catch (SchedulerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return scheduler ;
					
				}
				
				
			}
			
		}
		
		return scheduler ;
		
	}
	
	
}
