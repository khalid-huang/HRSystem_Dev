package com.kevin.HRSystem.schedule;

import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class PayJob extends QuartzJobBean {
    //判断作业是否执行的标志
    private boolean isRunning = false;

    public PayJob() {
        super();
    }

    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}

