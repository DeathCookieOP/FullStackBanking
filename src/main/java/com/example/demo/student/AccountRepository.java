package com.example.demo.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Integer will be our ID that we put with the account info
//This repo is so it takes data from our controller and inputs it into
//the database
@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
//    we dont really need anything cuz we will just use all the
//    functions from the CrudRepository
}
