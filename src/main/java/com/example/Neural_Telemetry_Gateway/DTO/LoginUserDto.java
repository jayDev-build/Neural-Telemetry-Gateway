package com.example.Neural_Telemetry_Gateway.DTO;

public class LoginUserDto {
    private String mailaddress;

    private String password;

    public String getMailaddress() {
        return mailaddress;
    }

    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
