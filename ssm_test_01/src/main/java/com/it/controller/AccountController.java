package com.it.controller;

import com.it.domain.Account;
import com.it.service.AccountService;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 账户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层，查询所有账户");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        for (Account  account: list) {
            System.out.println(account);
        }
        return "list";
    }
}
