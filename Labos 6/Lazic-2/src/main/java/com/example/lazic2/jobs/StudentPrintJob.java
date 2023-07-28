package com.example.lazic2.jobs;

import com.example.lazic2.domain.Student;
import com.example.lazic2.repository.StudentRepository;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.Set;

public class StudentPrintJob extends QuartzJobBean {

    private Logger log = LoggerFactory.getLogger(StudentPrintJob.class);

    private final StudentRepository studentRepository;

    public StudentPrintJob(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        final List<Student> studentList = studentRepository.findAll();

        if(!studentList.isEmpty()){
            log.info("Ovo su trenutno upisani studenti");
            log.info("--------------------------------");
            studentList.forEach(
                    student->log.info(student.toString())
            );
            log.info("--------------------------------");
        }
        else{
            log.info("Trenutno nema upisanih studenata");
        }
    }
}
