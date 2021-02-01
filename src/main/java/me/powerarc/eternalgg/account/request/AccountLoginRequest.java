package me.powerarc.eternalgg.account.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AccountLoginRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @Override
    public String toString() {
        return "AccountLoginRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
