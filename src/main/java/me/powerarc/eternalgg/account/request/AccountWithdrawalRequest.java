package me.powerarc.eternalgg.account.request;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AccountWithdrawalRequest {
    private String password;

    @Override
    public String toString() {
        return "AccountWithdrawalRequest{" +
                "password='" + password + '\'' +
                '}';
    }
}
