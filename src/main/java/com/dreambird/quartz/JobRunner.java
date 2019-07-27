package com.dreambird.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @ClassName JobRunner
 * @Description TODO
 * @author 陈浩良
 * @date Apr 26, 2017 3:31:26 PM
 */
@javax.servlet.annotation.WebListener()
public class JobRunner implements ServletContextListener {
	

	public static final int STRATEGY_RULE_ONE = 0;
	public static final int STRATEGY_RULE_INTERVAL = 1;
	public static final int STRATEGY_RULE_NOW = 2;
	public static SchedulerFactory sf;
	private static String scheName;

	public static String getScheName() {
		return scheName;
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		Scheduler scheduler;
		try {
			scheduler = JobRunner.sf.getScheduler();
			JobRunner.scheName = scheduler.getSchedulerName();
			scheduler.shutdown();// 容器关闭
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description 启动定时任务调度容器
	 * @Author 陈浩良
	 * @date May 9, 2017 4:46:46 PM
	 * @param arg0
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			System.out.println(scheName+"--【定时任务调度器】启动成功");
			sf = new StdSchedulerFactory();
			Scheduler scheduler = JobRunner.sf.getScheduler();
			JobRunner.scheName = scheduler.getSchedulerName();
			scheduler.start(); // 容器启动
			System.out.println(scheName+"--【定时任务调度器】启动成功");
			TestJob.getTestJob().test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description 启动任务
	 * @Author 陈浩良
	 * @date Apr 28, 2017 9:31:06 AM
	 * @param className
	 *            启动类名
	 * @param jobId
	 *            启动任务name
	 * @param jobType
	 *            任务类型(一次、重复、立即)
	 * @param cronReg
	 *            定时器规则
	 * @param date
	 * @return
	 */
	public static boolean startJob(String className, String jobId, int jobType, String cronReg, Date date) {

		boolean successFlag = false;
		try {
			// 任务全部使用同一个调度器
			String scheName = JobRunner.getScheName();
			Scheduler scheduler = null;

			// 获取调度器
			scheduler = JobRunner.sf.getScheduler(scheName);
			Class forName = Class.forName(className);
			JobDetail jobDetail = newJob(forName).withIdentity(jobId.toString()).build();
			jobDetail.getJobDataMap().put("jobKey", jobId.toString());
			switch (jobType) {
			case STRATEGY_RULE_ONE:
				SimpleTrigger sTrigger = (SimpleTrigger) newTrigger().startAt(date) // 设定5分钟后运行
						.build();
				scheduler.scheduleJob(jobDetail, sTrigger);
				successFlag = true;
				break;
			case STRATEGY_RULE_INTERVAL:
				CronTrigger cTrigger = newTrigger().withSchedule(cronSchedule(cronReg)).build();

				// 添加到调度器
				scheduler.scheduleJob(jobDetail, cTrigger);
				successFlag = true;
				break;
			case STRATEGY_RULE_NOW:
				jobDetail = newJob(forName).withIdentity(jobId.toString()).storeDurably().build();
				
				jobDetail.getJobDataMap().put("jobKey", jobId.toString());
				jobDetail.getJobDataMap().put("jobType", STRATEGY_RULE_NOW);
				// 添加到调度器
				scheduler.addJob(jobDetail, true);
				// 直接触发
				scheduler.triggerJob(JobKey.jobKey(jobId.toString()));
				
				successFlag = true;
				break;
			default:

				successFlag = false;
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			successFlag = false;
		}
		return successFlag;
	}

	/**
	 * 
	 * @Description 停止任务
	 * @Author 陈浩良
	 * @date Apr 28, 2017 10:11:02 AM
	 * @param jobId
	 * @return
	 */
	public static boolean shutDownJob(String jobId) {
		try {
			// 任务全部使用同一个调度器
			String scheName = JobRunner.getScheName();
			Scheduler scheduler = null;

			// 获取调度器
			scheduler = JobRunner.sf.getScheduler(scheName);

			JobKey jobKey = JobKey.jobKey(jobId);

			// 添加到调度器
			scheduler.deleteJob(jobKey);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @Description 从数据库格式转换到cron表达式
	 * @Author 陈浩良
	 * @date May 9, 2017 6:34:15 PM
	 * @param runTime
	 * @return
	 */
	public static String stringToCron(String runTime) {
		// YYYYMMDDWW12:12:00
		String yyyy = runTime.substring(0, 4);
		String mm = runTime.substring(4, 6);
		String dd = runTime.substring(6, 8);
		String ww = runTime.substring(8, 10);
		String hh = runTime.substring(10, 12);
		String MM = runTime.substring(13, 15);
		String ss = runTime.substring(16, 18);
		StringBuilder sBuilder = new StringBuilder();
		if (ss.equals("SS")) {
			sBuilder.append("* ");
		} else {
			sBuilder.append(ss).append(" ");
		}
		if (MM.equals("MM")) {
			sBuilder.append("* ");
		} else {
			sBuilder.append(MM).append(" ");
		}
		if (hh.equals("HH")) {
			sBuilder.append("* ");
		} else {
			sBuilder.append(hh).append(" ");
		}
		if (dd.equals("DD")) {
			sBuilder.append("* ");
		} else {
			sBuilder.append(dd).append(" ");
		}
		if (mm.equals("MM")) {
			sBuilder.append("* ");
		} else {
			sBuilder.append(mm).append(" ");
		}
		if (ww.equals("WW")) {
			sBuilder.append("? ");
		} else {
			String weekday = ww.substring(1, 2);
			if (weekday.equals("7")) {
				sBuilder.append("1 ");
			} else {
				sBuilder.append(Integer.parseInt(weekday) + 1).append(" ");
			}
		}
		if (!yyyy.equals("YYYY")) {
			sBuilder.append(yyyy);
		}

		return sBuilder.toString();
	}
}
