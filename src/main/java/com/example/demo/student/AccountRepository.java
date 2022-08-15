package com.example.demo.student;

import org.springframework.data.repository.CrudRepository;

//Integer will be our ID that we put with the account info
//This repo is so it takes data from our controller and inputs it into
//the database
public interface AccountRepository extends CrudRepository<Account, Integer> {

}
