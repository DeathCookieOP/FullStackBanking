package com.example.demo.student;

import java.util.Date;

//to map this student to our database
//@Entity //for hibernate
//@Table //for table in database
public class Account {

//    these should be same name as name in html
    int id;
    String accType;
    double initialAmt;
    Date dateOpened;

//    removed id for now, database will generate it for us
    public Account(String accType, double initialAmt) {
//        this.id = id;
        this.accType = accType;
        this.initialAmt = initialAmt; //conv to a double
        this.dateOpened = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public double getInitialAmt() {
        return initialAmt;
    }

    public void setInitialAmt(double initialAmt) {
        this.initialAmt = initialAmt;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accType='" + accType + '\'' +
                ", initialAmt=" + initialAmt +
                ", dateOpened=" + dateOpened +
                '}';
    }
}
