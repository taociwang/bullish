package com.hy.crm.bo;

import java.io.Serializable;

public class Flowable implements Serializable {

    private Integer id;
    private String employee;
    private String nrOfHolidays;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getNrOfHolidays() {
        return nrOfHolidays;
    }

    public void setNrOfHolidays(String nrOfHolidays) {
        this.nrOfHolidays = nrOfHolidays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Flowable{" +
                "id=" + id +
                ", employee='" + employee + '\'' +
                ", nrOfHolidays='" + nrOfHolidays + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
