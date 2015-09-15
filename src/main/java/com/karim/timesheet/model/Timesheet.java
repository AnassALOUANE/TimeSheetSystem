package com.karim.timesheet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat ;
import org.springframework.format.annotation.NumberFormat .Style;

@Entity
@Table(name = "timesheet")
public class Timesheet implements Serializable {

    private static final long serialVersionUID = 5165L;

    @Id	
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "id_timesheet")
    private Integer id_timesheet;


    @Column(name = "hoursMon")
    @NumberFormat(style = Style.NUMBER)
    @Max(value = 16, message = "Daily hours cannot exceed 16 hours.")
    private Integer hoursMon = 0;
	
    @Column(name = "hoursTue")
    @NumberFormat(style = Style.NUMBER)
    @Max(value = 16, message = "Daily hours cannot exceed 16 hours.")
    private Integer hoursTue = 0;
	
    @Column(name = "hoursWed")
    @NumberFormat(style = Style.NUMBER)
    @Max(value = 16, message = "Daily hours cannot exceed 16 hours.")
    private Integer hoursWed = 0;
	
    @Column(name = "hoursThu")
    @NumberFormat(style = Style.NUMBER)
    @Max(value = 16, message = "Daily hours cannot exceed 16 hours.")
    private Integer hoursThu = 0;
	
    @Column(name = "hoursFri")
    @NumberFormat(style = Style.NUMBER)
    @Max(value = 16, message = "Daily hours cannot exceed 16 hours.")
    private Integer hoursFri = 0;
	
    @Column(name = "hoursSat")
    @NumberFormat(style = Style.NUMBER)
    @Max(value = 16, message = "Daily hours cannot exceed 16 hours.")
    private int hoursSat = 0;
	
    @Column(name = "hoursSun")
    @NumberFormat(style = Style.NUMBER)
    @Max(value = 16, message = "Daily hours cannot exceed 16 hours.")
    private int hoursSun = 0;
	
    @Column(name = "statusCode")
    private String statusCode;
	
    @Column(name = "periodEndingDate")
    private Date periodEndingDate;
	
    @Column(name = "paid")
    private Boolean paid;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="id_u")
    private User employee;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="id_dept")
    private Department department;

    public Timesheet() {
    }

    public Timesheet(Integer id_timesheet, String statusCode, Date periodEndingDate, Boolean paid) {
        this.id_timesheet = id_timesheet;
        this.statusCode = statusCode;
        this.periodEndingDate = periodEndingDate;
        this.paid = paid;
    }

    public void setId_timesheet(Integer id_timesheet) {
        this.id_timesheet = id_timesheet;
    }

    public void setHoursMon(Integer hoursMon) {
        this.hoursMon = hoursMon;
    }

    public void setHoursTue(Integer hoursTue) {
        this.hoursTue = hoursTue;
    }

    public void setHoursWed(Integer hoursWed) {
        this.hoursWed = hoursWed;
    }

    public void setHoursThu(Integer hoursThu) {
        this.hoursThu = hoursThu;
    }

    public void setHoursFri(Integer hoursFri) {
        this.hoursFri = hoursFri;
    }

    public void setHoursSat(int hoursSat) {
        this.hoursSat = hoursSat;
    }

    public void setHoursSun(int hoursSun) {
        this.hoursSun = hoursSun;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setPeriodEndingDate(Date periodEndingDate) {
        this.periodEndingDate = periodEndingDate;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId_timesheet() {
        return id_timesheet;
    }

    public Integer getHoursMon() {
        return hoursMon;
    }

    public Integer getHoursTue() {
        return hoursTue;
    }

    public Integer getHoursWed() {
        return hoursWed;
    }

    public Integer getHoursThu() {
        return hoursThu;
    }

    public Integer getHoursFri() {
        return hoursFri;
    }

    public int getHoursSat() {
        return hoursSat;
    }

    public int getHoursSun() {
        return hoursSun;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public Date getPeriodEndingDate() {
        return periodEndingDate;
    }

    public Boolean getPaid() {
        return paid;
    }

    public User getEmployee() {
        return employee;
    }

    public Department getDepartment() {
        return department;
    }

    
    
    @NumberFormat(style = Style.NUMBER)
    @Max(value = 96, message = "Daily hours cannot exceed 96 hours.")
    public int getTotalHours()
    {
        return (hoursMon + hoursTue + hoursWed + hoursThu
                + hoursFri + hoursSat + hoursSun);
    }

   

    @Override
    public String toString() {
        return "Timesheet{" + "id_timesheet=" + id_timesheet + ", hoursMon=" + hoursMon + ", hoursTue=" + hoursTue + ", hoursWed=" + hoursWed + ", hoursThu=" + hoursThu + ", hoursFri=" + hoursFri + ", hoursSat=" + hoursSat + ", hoursSun=" + hoursSun + ", statusCode=" + statusCode + ", periodEndingDate=" + periodEndingDate + ", paid=" + paid + ", employee=" + employee + ", department=" + department + '}';
    }

    
    
    
	     
}
