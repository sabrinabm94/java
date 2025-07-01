package com.objectorientation.heritageandpolymorphism;

public final class Manager extends Lead {
    // Manager herda as propriedades de Employee

    private String login;
    private String password;
    private double commission;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
}
