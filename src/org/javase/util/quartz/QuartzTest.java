package org.javase.util.quartz;

import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.triggers.CronTriggerImpl;

/**
 Quartz是一个任务调度框架。比如你遇到这样的问题
    想每月25号，信用卡自动还款
    想每年4月1日自己给当年暗恋女神发一封匿名贺卡
    想每隔1小时，备份一下自己的爱情动作片 学习笔记到云盘

 * @author kevin
 *
 */
public class QuartzTest {

	public static void main3(String[] args) {
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			
			@SuppressWarnings("deprecation")
			JobDetail jd = new JobDetailImpl("test", "test_group", HelloQuartz.class);// HelloQuartz类里是真正的任务
			
			@SuppressWarnings("deprecation")
			CronTriggerImpl ct = new CronTriggerImpl("test", "test_group");
			
			// 你修改下面的 表达式 就能满足了
			// 时间格式: <!-- s m h d m w(?) y(?) -->, 分别对应: 秒>分>小时>日>月>周>年
			ct.setCronExpression("0/2 * * * * ?");// 每两秒执行一次任务

			scheduler.scheduleJob(jd, ct);
			System.out.println("Scheduler started at " + new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void main1(String[] args) {
        try {
            //创建scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            //定义一个Trigger
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") // 定义name/group
					.startNow()// 一旦加入scheduler，立即生效
					.withSchedule(SimpleScheduleBuilder.simpleSchedule() // 使用SimpleTrigger
					.withIntervalInSeconds(1) // 每隔一秒执行一次
					.repeatForever()) // 一直执行，奔腾到老不停歇
					.build();

            //定义一个JobDetail
            JobDetail job = JobBuilder.newJob(HelloQuartz.class) //定义Job类为HelloQuartz类，这是真正的执行逻辑所在
                .withIdentity("job1", "group1") //定义name/group
                .usingJobData("name", "quartz") //定义属性
                .build();

            //加入这个调度
            scheduler.scheduleJob(job, trigger);

            //启动之
            scheduler.start();

            //运行一段时间后关闭
            Thread.sleep(10000);
            scheduler.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}