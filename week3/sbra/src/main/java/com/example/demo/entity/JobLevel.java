package com.example.demo.entity;

import com.example.demo.dto.JobLevelDTO;
import com.example.demo.interfaces.EntityToDtoConverter;

//import javax.persistence.*;
import jakarta.persistence.*;
@Entity
public class JobLevel implements EntityToDtoConverter<JobLevelDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobLevelId;
    private String jobLevelName;
    private Long basePay;

    public JobLevel() {
        super();
    }

    public JobLevel(int jobLevelId, String jobLevelName, long basePay) {
        this.jobLevelId = jobLevelId;
        this.jobLevelName = jobLevelName;
        this.basePay = basePay;
    }

    public int getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(int jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    public String getJobLevelName() {
        return jobLevelName;
    }

    public void setJobLevelName(String jobLevelName) {
        this.jobLevelName = jobLevelName;
    }

    public long getBasePay() {
        return basePay;
    }

    public void setBasePay(long basePay) {
        this.basePay = basePay;
    }

    @Override
    public JobLevelDTO toDto() {
        return new JobLevelDTO(
                this.getJobLevelId(),
                this.getJobLevelName(),
                this.getBasePay()
        );
    }
}