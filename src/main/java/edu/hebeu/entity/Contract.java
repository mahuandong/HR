package edu.hebeu.entity;

import java.io.Serializable;

public class Contract implements Serializable {
    private Integer id;

    private String name;

    private Integer employeeNumber;

    private String laborContractTime;

    private Integer laborContractStaut;

    private String trainingContractTime;

    private Integer trainingContractStaut;

    private Integer secrecyStaut;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLaborContractTime() {
        return laborContractTime;
    }

    public void setLaborContractTime(String laborContractTime) {
        this.laborContractTime = laborContractTime == null ? null : laborContractTime.trim();
    }

    public Integer getLaborContractStaut() {
        return laborContractStaut;
    }

    public void setLaborContractStaut(Integer laborContractStaut) {
        this.laborContractStaut = laborContractStaut;
    }

    public String getTrainingContractTime() {
        return trainingContractTime;
    }

    public void setTrainingContractTime(String trainingContractTime) {
        this.trainingContractTime = trainingContractTime == null ? null : trainingContractTime.trim();
    }

    public Integer getTrainingContractStaut() {
        return trainingContractStaut;
    }

    public void setTrainingContractStaut(Integer trainingContractStaut) {
        this.trainingContractStaut = trainingContractStaut;
    }

    public Integer getSecrecyStaut() {
        return secrecyStaut;
    }

    public void setSecrecyStaut(Integer secrecyStaut) {
        this.secrecyStaut = secrecyStaut;
    }
}