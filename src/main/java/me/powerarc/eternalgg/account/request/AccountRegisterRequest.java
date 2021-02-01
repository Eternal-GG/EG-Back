package me.powerarc.eternalgg.account.request;

import lombok.*;
import me.powerarc.eternalgg.account.Account;
import me.powerarc.eternalgg.account.AccountType;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class AccountRegisterRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String nickname;

    @NotNull
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
