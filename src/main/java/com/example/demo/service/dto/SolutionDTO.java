/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.service.dto;

import com.example.demo.domain.SolutionEntity;

public class SolutionDTO {
    private Integer id;
    private String solutionValue;
    private String testResult;

    public SolutionDTO() {
    }

    public SolutionDTO(SolutionEntity solution) {
        this.id = solution.getId();
        this.solutionValue = solution.getSolutionValue();
        if(solution.getTestResult() == true){
            this.testResult = "SUCCESS";
        }else{
            this.testResult = "UNSUCCESS";
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSolutionValue() {
        return solutionValue;
    }

    public void setSolutionValue(String solutionValue) {
        this.solutionValue = solutionValue;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
}
