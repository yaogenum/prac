package com.yaoge.quartztest;

import java.util.Calendar;
import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

/**
 * 简单demo
 * @author Administrator
 *
 */
public class QuartzDemoTest {

	public static void main( String[] args ){
		
		
		Scheduler sch = ScheduleFactoryTest.getScheduler() ;
		
		JobDetail job = new JobDetailImpl("1","A",TimingTask.class) ;
		
		SimpleTrigger trigger = new SimpleTriggerImpl("1","A",new Date(System.currentTimeMillis()),new Date(1000000+System.currentTimeMillis()),10,1000) ;
		
		try {
			sch.scheduleJob(job, trigger);
			sch.start();
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
