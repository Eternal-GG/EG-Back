package me.powerarc.eternalgg.account;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;


    public boolean createAccount(String email, String password, String nickname) {
        Account account = new Account();
        account.setEmail(email);
        account.setPassword(password);
        account.setAccountType(AccountType.LOCAL);
        account.setNickname(nickname);
        try {
            accountRepository.save(account);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean passwordUpdate(String password, String replacePassword) {
        Optional<Account> byPassword = accountRepository.findByPassword(password);
        if (byPassword.isPresent()) {
            byPassword.get().setPassword(replacePassword);
            try {
                accountRepository.save(byPassword.orElse(null));
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean withdrawal(String password) {
        Optional<Account> byPassword = accountRepository.findByPassword(password);
        try {
            accountRepository.delete(byPassword.orElse(null));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
