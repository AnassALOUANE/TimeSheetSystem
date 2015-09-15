/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.model;

/**
 *
 * @author karim
 */
public class OverallReport {
    private String name;
    private Long paid;
    private Long unpaid;
    private Long approved;
    private Long disapproved;
    private Long totalHours;

    public OverallReport() {
    }

    public OverallReport(String name, Long paid, Long unpaid, Long approved, Long disapproved, Long totalHours) {
        this.name = name;
        this.paid = paid;
        this.unpaid = unpaid;
        this.approved = approved;
        this.disapproved = disapproved;
        this.totalHours = totalHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPaid(Long paid) {
        this.paid = paid;
    }

    public void setUnpaid(Long unpaid) {
        this.unpaid = unpaid;
    }

    public void setApproved(Long approved) {
        this.approved = approved;
    }

    public void setDisapproved(Long disapproved) {
        this.disapproved = disapproved;
    }

    public void setTotalHours(Long totalHours) {
        this.totalHours = totalHours;
    }

    public String getName() {
        return name;
    }

    public Long getPaid() {
        return paid;
    }

    public Long getUnpaid() {
        return unpaid;
    }

    public Long getApproved() {
        return approved;
    }

    public Long getDisapproved() {
        return disapproved;
    }

    public Long getTotalHours() {
        return totalHours;
    }

    
    
}
