package org.scaler.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class LogOutRequestDto {
    private String tokenValue;

    public String getTokenValue() {
        return tokenValue;
    }
    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

}
