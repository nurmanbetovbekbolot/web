package kg.itacademy.services;

import kg.itacademy.entities.Account;
import kg.itacademy.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(new Account());
    }

    @Override
    public Account update(Account a) {
        return accountRepository.save(a);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
        System.out.println("Successfully created");

    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
        System.out.println("Customer with id " + id + " has been deleted");
    }

    @Override
    public BigDecimal getMoneyAmount(Account account) {
        return account.getBalance();
    }

}
