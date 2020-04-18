package kg.itacademy.services;

import kg.itacademy.entities.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

List<Account> getAll();
Account getById(Long id);
Account update(Account account);
void save(Account account);
void deleteById(Long id);
BigDecimal getMoneyAmount(Account account);

}
