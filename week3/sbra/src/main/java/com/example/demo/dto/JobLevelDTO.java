package com.example.demo.dto;

import com.example.demo.entity.JobLevel;
import com.example.demo.interfaces.DtoToEntityConverter;

public class JobLevelDTO implements DtoToEntityConverter<JobLevel> {
    private int jobLevelId;
    private String jobLevelName;
    private long basePay;

    public JobLevelDTO() {
        super();
    }

    public JobLevelDTO(int jobLevelId, String jobLevelName, long basePay) {
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
    public JobLevel toEntity() {
        return new JobLevel(this.getJobLevelId(), this.getJobLevelName(), this.getBasePay());
    }

    @Override
    public String toString() {
        return "JobLevelDTO{" +
                "jobLevelId=" + jobLevelId +
                ", jobLevelName='" + jobLevelName + '\'' +
                ", basePay=" + basePay +
                '}';
    }
}
