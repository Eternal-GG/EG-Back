package me.powerarc.eternalgg.account.request;

import lombok.*;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AccountLoginRequest {
    private String email;
    private String password;

    @Override
    public String toString() {
        return "AccountLoginRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
