package com.example.demo.student;

import javax.persistence.*;
import java.util.Date;

//to map this student to our database
@Entity //for hibernate
@Table() //for table in database
public class Account {

//    adding this to the database so it generates it for us
    @Id
    @GeneratedValue
//    @Column(name = "ID")
    int id;

//    these should be same name as name in html
//    @Column(name = "Account Type") (do this for all vars if you want)
    String accType;
    String fullName;

    double initialAmt;
    Date dateOpened;

    public Account() {
        this.accType = "checkingsAcc";
        this.initialAmt = 10;
        this.dateOpened = new Date();
    }

    public Account(String accType, double initialAmt) {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public void withdraw(double amount) {
        this.initialAmt -= amount;
    }

    public void deposit(double amount) {
        this.initialAmt += amount;
    }

    @Override
    public String toString() {
        return "Account{" +
//                "id=" + id +
                ", accType='" + accType + '\'' +
                ", initialAmt=" + initialAmt +
                ", dateOpened=" + dateOpened +
                '}';
    }
}
