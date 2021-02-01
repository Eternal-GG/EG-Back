package me.powerarc.eternalgg.account.request;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotEmpty;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AccountWithdrawalRequest {

    @NotEmpty
    private String password;

    @Override
    public String toString() {
        return "AccountWithdrawalRequest{" +
                "password='" + password + '\'' +
                '}';
    }
}
