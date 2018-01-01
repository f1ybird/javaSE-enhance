package org.javase.util.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloQuartz implements Job {
	
	@SuppressWarnings("deprecation")
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		JobDetail detail = context.getJobDetail();
//		String name = detail.getJobDataMap().getString("name");
//		System.out.println("say hello to " + name + " at " + new Date());
		System.out.println(new Date().getSeconds() + " : hello quartz");
	}
}