package com.example.lazic2.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimePrintJob extends QuartzJobBean {
    private Logger log = LoggerFactory.getLogger(TimePrintJob.class);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        Date currentTime = new Date();
        log.info("Current time -> "+ dateFormat.format(currentTime));
    }
}
