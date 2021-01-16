package me.powerarc.eternalgg.account.request;

import lombok.*;
import me.powerarc.eternalgg.account.Account;
import me.powerarc.eternalgg.account.AccountType;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class AccountRegisterRequest {
    private String email;
    private String password;
    private String nickname;
    private AccountType accountType;

    @Override
    public String toString() {
        return "AccountRegisterRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", accountType=" + accountType +
                '}';
    }
}
