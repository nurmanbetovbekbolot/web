package kg.itacademy.controllers;

import kg.itacademy.entities.Account;
import kg.itacademy.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Account getById(@PathVariable("id")Long id) {
        return accountService.getById(id);
    }

    @PutMapping
    public Account update(@RequestBody Account a) {
        return accountService.update(a);
    }

    @PostMapping
    public void create(@RequestBody Account account) {
        accountService.save(account);
    }

    @DeleteMapping
    public void deleteById(Long id) {
       accountService.deleteById(id);
    }
}
