package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class AccountController {

    @Autowired //to inject the dependency
    private AccountRepository accRepo;

    @Autowired
    AccountService accService;

    @RequestMapping(path = "/main")
    public String getAllEmployees(Model model) {
        System.out.println("getAllAccounts");
        List<Account> list = accService.getAllAccounts();
        model.addAttribute("account", list);
        return "main";
    }

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
        //saves the acc to our database using the repo
        Account accInserted = accRepo.save(account);

        System.out.println(account.toString());
        model.addAttribute("message", "Your Account ID: " + accInserted.getId());
        //looks at the html and changes that th:text="${accType}" to the
        //account type of the user
        model.addAttribute("fullName", account.getFullName());
        model.addAttribute("accType", account.getAccType());
        model.addAttribute("currBal", account.getInitialAmt());

        return "welcome";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editAccountByIO(Model model, @PathVariable("id") Optional<Integer> id) {
        System.out.println("editAccountByID: " + id);
        if(id.isPresent()) {
        }
        return "edit";
    }

    @RequestMapping(path = {"/remove/{id}"})
    public String deleteAccountByID(Model model, @PathVariable("id") int id) {
        System.out.println("deleteAccountByID: " + id);
        /**
         * can use accRepo here
         */
        accService.deleteById(id);
        return "redirect:/";
    }
//
    @RequestMapping(path = "/registers", method = RequestMethod.POST)
    public String createOrEditAccount(Account account) {
        accService.createAccount(account);
        return "redirect:/";
    }

}
