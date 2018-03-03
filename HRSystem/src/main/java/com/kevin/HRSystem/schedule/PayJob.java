package com.kevin.HRSystem.schedule;

import com.kevin.HRSystem.service.EmpManagerService;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

public class PayJob extends QuartzJobBean {
    //判断作业是否执行的标志
    private boolean isRunning = false;

    private EmpManagerService empManagerService;

    public void setEmpManagerService(EmpManagerService empManagerService) {
        this.empManagerService = empManagerService;
    }

    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(!isRunning) {
            System.out.println("开始调度自动结算工资");
            isRunning = true;
            empManagerService.autoPay();
            isRunning = false;
        }
    }
}

