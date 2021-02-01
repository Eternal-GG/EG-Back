package me.powerarc.eternalgg.account;

import me.powerarc.eternalgg.account.request.AccountLoginRequest;
import me.powerarc.eternalgg.account.request.AccountRegisterRequest;
import me.powerarc.eternalgg.account.request.AccountUpdatePasswordRequest;
import me.powerarc.eternalgg.account.request.AccountWithdrawalRequest;
import me.powerarc.eternalgg.jwt.JwtTokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody @Valid AccountRegisterRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        if (!accountService.register(request)) {
            errors.reject("wrongValues", "Values are wrong");
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AccountLoginRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }
        if (!accountService.login(request)) {
            errors.reject("wrongValues", "Values are wrong");
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok().body(jwtTokenProvider.createToken(request.getEmail()));

    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity withdrawal(@RequestBody @Valid AccountWithdrawalRequest password, HttpServletRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        if (!accountService.withdrawal(request, password.getPassword())) {
            errors.reject("wrongValues", "Values are wrong");
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/updatepassword")
    @ResponseBody
    public ResponseEntity updatePassword(@RequestBody @Valid AccountUpdatePasswordRequest password, HttpServletRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        if (!accountService.passwordUpdate(request, password)) {
            errors.reject("wrongValues", "Values are wrong");
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/check-email-token/{token}/{email}")
    public String checkEmail(@PathVariable String token,@PathVariable String email) {
        if (!accountService.checkEmailToken(token, email)) {
            return "redirect:https://cafe.naver.com/joonggonara";
        }

        return "redirect:https://naver.com";

    }

}
