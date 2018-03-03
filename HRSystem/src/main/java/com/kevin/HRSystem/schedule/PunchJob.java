package com.kevin.HRSystem.schedule;

import com.kevin.HRSystem.service.EmpManagerService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

public class PunchJob extends QuartzJobBean {
    //判断作业是否执行的标志
    private boolean isRunning = false;

    private EmpManagerService empManagerService;

    public void setEmpManagerService(EmpManagerService empManagerService) {
        this.empManagerService = empManagerService;
    }

    public void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
        if(!isRunning) {
            System.out.println("开始调度自动打卡");
            isRunning = false;
            empManagerService.autoPunch();
            isRunning = true;
        }
    }
}
