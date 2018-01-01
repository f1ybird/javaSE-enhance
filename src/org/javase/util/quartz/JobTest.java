package org.javase.util.quartz;

//job相关的builder
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
//trigger相关的builder
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.IOException;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class JobTest {
	
	public static void main(String[] args) throws SchedulerException, IOException {
		JobDetail job = newJob().ofType(DoNothingJob.class) // 引用Job Class
				.withIdentity("job1", "group1") // 设置name/group
				.withDescription("this is a test job") // 设置描述
				.usingJobData("age", 18) // 加入属性到ageJobDataMap
				.build();

		job.getJobDataMap().put("name", "quertz"); // 加入属性name到JobDataMap

		// 定义一个每秒执行一次的SimpleTrigger
		Trigger trigger = newTrigger()
				.startNow()
				.withIdentity("trigger1")
				.withSchedule(simpleSchedule()
				.withIntervalInSeconds(1)
				.repeatForever())
				.build();

		Scheduler sche = StdSchedulerFactory.getDefaultScheduler();
		sche.scheduleJob(job, trigger);

		sche.start();

		System.in.read();

		sche.shutdown();
	}
}

@DisallowConcurrentExecution // 多个jobDetail实例可以实现并发
class DoNothingJob implements Job {
	
	@Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("do nothing");
    }

}
