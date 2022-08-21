package com.example.demo.student;

import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accRepo;

    public List<Account> getAllAccounts() {
        System.out.println("getAllAccounts");
        List<Account> result = (List<Account>) accRepo.findAll();

        if(result.size() > 0) return result;
        else return new ArrayList<Account>();
    }

    public Account getAccountByID(int id) throws Exception {
        System.out.println("getEmployeeByID");
        Optional<Account> account = accRepo.findById(id);

        if(account.isPresent()) return account.get();
        else throw new Exception("No account found");
    }

    public Account createAccount(Account account) {
        System.out.println("createAccount");
//        if(account.getId().)
        account = accRepo.save(account);
        return account;
    }

    public Account editAccount(Account account) {
        System.out.println("editAccount");
        Optional<Account> bankAcc = accRepo.findById(account.getId());
        if(bankAcc.isPresent()) {
            Account newAccount = bankAcc.get();
            newAccount.setFullName(account.getFullName());
            newAccount.setAccType(account.getAccType());
            newAccount.setDateOpened(account.getDateOpened());
            newAccount.setInitialAmt(account.getInitialAmt());

            newAccount = accRepo.save(newAccount);
            return newAccount;
        }
        else{
            account = accRepo.save(account);
            return account;
        }
    }


    public void deleteById(int id) throws Exception {
        System.out.println("deleteByID");
        Optional<Account> account = accRepo.findById(id);

        if(account.isPresent()) accRepo.deleteById(id);
        else throw new Exception("No account in our records");
    }




}
