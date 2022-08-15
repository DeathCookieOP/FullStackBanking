package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Controller
public class AccountController {
    //mapping url to it
    //localhost:8080/books
//    @GetMapping("/books")
//    public List<Account> getAllBooks() {
//        return Arrays.asList(new Account(1, "Checkings", 1000));
//    }

    @Autowired //to inject the dependency
    private AccountRepository accRepo;

    //mapping url to it
    //localhost:8080/
    @GetMapping("/")
    public String index() {
        return "index";
    }

    //    this is the endpoint /register
    @PostMapping("/register")
    //ModelAttribute binds the ui component to model
    public String userRegistration(@ModelAttribute Account account, Model model) {
        System.out.println(account.toString());
        //looks at the html and changes that th:text="${accType}" to the
        //account type of the user
        model.addAttribute("accType", account.getAccType());
        model.addAttribute("currBal", account.getInitialAmt());

        //saves the acc to our database using the repo
        Account accInserted = accRepo.save(account);
        //change this to id later instead of getDateOpened
        model.addAttribute("message", accInserted.getDateOpened() + " inserted");


        return "welcome";
    }
}
