package com.yaoge.quartztest;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class ScheduleFactoryTest {
	private static SchedulerFactory factory = null ;
	private static Scheduler scheduler = null ;
	
	
	
	ScheduleFactoryTest() {
		
		factory = new StdSchedulerFactory() ;
		
		try {
			scheduler = factory.getScheduler() ;
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static  Scheduler getScheduler() {
		
		if(null!=scheduler) {
			return  scheduler ;
		}
		else{
			return  null ;
		}
		
	}
	
	
}
