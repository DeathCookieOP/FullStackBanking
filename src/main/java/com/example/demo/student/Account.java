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

    double balance;
    Date dateOpened;

    public Account(String accType, double balance) {
        this.accType = accType;
        this.balance = balance; //conv to a double
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
        return balance;
    }

    public void setInitialAmt(double balance) {
        this.balance = balance;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "Account{" +
//                "id=" + id +
                ", accType='" + accType + '\'' +
                ", initialAmt=" + balance +
                ", dateOpened=" + dateOpened +
                '}';
    }
}
