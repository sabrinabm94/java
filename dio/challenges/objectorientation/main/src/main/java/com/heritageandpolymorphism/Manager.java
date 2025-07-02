package com.heritageandpolymorphism;

public final class Manager extends Lead {
    // Manager herda as propriedades de Employee

    private String login;
    private String password;
    private double commission;

    protected String getLogin() {
        return login;
    }

    protected void setLogin(String login) {
        this.login = login;
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected double getCommission() {
        return commission;
    }

    protected void setCommission(double commission) {
        this.commission = commission;
    }
}
