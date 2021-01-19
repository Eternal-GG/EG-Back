package me.powerarc.eternalgg.account;

import me.powerarc.eternalgg.account.request.AccountLoginRequest;
import me.powerarc.eternalgg.account.request.AccountRegisterRequest;
import me.powerarc.eternalgg.account.request.AccountUpdatePasswordRequest;
import me.powerarc.eternalgg.account.request.AccountWithdrawalRequest;
import me.powerarc.eternalgg.jwt.JwtTokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody AccountRegisterRequest request) {
        if (accountService.register(request)) {
            System.out.println(accountService.find(request.getEmail()).getRoles());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AccountLoginRequest request) {
        if (accountService.login(request)) {
            return ResponseEntity.ok().body(jwtTokenProvider.createToken(request.getEmail()));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/remove")
    public ResponseEntity withdrawal(@RequestBody AccountWithdrawalRequest password, HttpServletRequest request) {
        if (accountService.withdrawal(request, password.getPassword())) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/updatepassword")
    public ResponseEntity updatePassword(@RequestBody AccountUpdatePasswordRequest password, HttpServletRequest request) {
        if (accountService.passwordUpdate(request, password)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
