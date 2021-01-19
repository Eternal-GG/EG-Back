package me.powerarc.eternalgg.account.request;

import lombok.*;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AccountUpdatePasswordRequest {
    private String password;
    private String replacePassword;

    @Override
    public String toString() {
        return "AccountUpdatePasswordRequest{" +
                "password='" + password + '\'' +
                ", replacePassword='" + replacePassword + '\'' +
                '}';
    }
}
