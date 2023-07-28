package com.example.lazic2.jobs;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
@DisallowConcurrentExecution //ovo samo googleaj i objasni da ako 2 trigera dodju i isto vrijeme da se ejdan po jedan izvrse
public class TimeSchedulerConfig {
    private static final String TIME_PRINT_JOB_IDENTITY = "timePrintJob";
    @Bean
    public JobDetail timePrintJobDetail(){
        return JobBuilder.newJob(TimePrintJob.class)
                .withIdentity(TIME_PRINT_JOB_IDENTITY)
                .storeDurably()
                .build();
    }
    // trigger.setCronExpression("0 0/10 * ? * *"); //svakih 10 sekundi
    // trigger.setCronExpression("0 0 0 ? * *"); //ponoc
    // trigger.setCronExpression("0 0 0 ? * 4#1"); //first wednestday
    // trigger.setCronExpression("0 0 12 1 * ?"); //every month
    // Sekunde(0-59) Minute(0-59) Sati(0-23) DanUMjesecu(1-31) Mjesec(1-12) DaniUTjedenu(1-7)
    @Bean
    public CronTriggerFactoryBean triggerTrigger(){
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(timePrintJobDetail());
        trigger.setCronExpression("* 0/10 0 1 * 4#1");
        return trigger;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(
                triggerTrigger().getObject()
        );
        return schedulerFactoryBean;
    }




}
