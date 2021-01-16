package me.powerarc.eternalgg.account;

import lombok.AllArgsConstructor;
import me.powerarc.eternalgg.account.request.AccountLoginRequest;
import me.powerarc.eternalgg.account.request.AccountRegisterRequest;
import me.powerarc.eternalgg.account.request.AccountUpdatePasswordRequest;
import me.powerarc.eternalgg.jwt.JwtTokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    public boolean login(AccountLoginRequest request) {
        Optional<Account> account = accountRepository.findByEmail(request.getEmail());
        if (account.isPresent()) {
            if (passwordEncoder.matches(request.getPassword(), account.get().getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean register(AccountRegisterRequest request) {
        Account account = modelMapper.map(request, Account.class);
        account.setAccountType(AccountType.LOCAL);
        account.encodePassword(passwordEncoder);
        account.setRoles(Collections.singletonList("USER"));

        try {
            accountRepository.save(account);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean passwordUpdate(HttpServletRequest request, AccountUpdatePasswordRequest password) {
        String email = jwtTokenProvider.getUserEmail(jwtTokenProvider.resolveToken(request));
        Optional<Account> byEmail = accountRepository.findByEmail(email);
        if (byEmail.isPresent() && passwordEncoder.matches(password.getPassword(), byEmail.get().getPassword())) {
            byEmail.get().setPassword(password.getReplacePassword());
            byEmail.get().encodePassword(passwordEncoder);
            try {
                accountRepository.save(byEmail.orElse(null));
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean withdrawal(HttpServletRequest request, String password) {
        String email = jwtTokenProvider.getUserEmail(jwtTokenProvider.resolveToken(request));
        Optional<Account> byEmail = accountRepository.findByEmail(email);
        if (byEmail.isPresent()) {
            if (passwordEncoder.matches(password, byEmail.get().getPassword())) {
                try {
                    accountRepository.delete(byEmail.orElse(null));
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    public Account find(String email) {
        return accountRepository.findByEmail(email).get();
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return accountRepository.findByEmail(s)
                .orElseThrow(()->new UsernameNotFoundException("사용자를 찾을 수 없습니다"));

    }
}
