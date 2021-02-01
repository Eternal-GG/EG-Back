package me.powerarc.eternalgg.account.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AccountUpdatePasswordRequest {

    @NotEmpty
    private String password;

    @NotEmpty
    private String replacePassword;

    @Override
    public String toString() {
        return "AccountUpdatePasswordRequest{" +
                "password='" + password + '\'' +
                ", replacePassword='" + replacePassword + '\'' +
                '}';
    }
}
