package com.heritageandpolymorphism;

public class Salesman extends Employee {

    private double salesGoal;

    protected double getSalesGoal() {
        return salesGoal;
    }

    protected void setSalesGoal(double salesGoal) {
        this.salesGoal = salesGoal;
    }
}
