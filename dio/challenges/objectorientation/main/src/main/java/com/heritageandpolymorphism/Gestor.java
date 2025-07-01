package com.objectorientation.heritageandpolymorphism;

public final class Gestor extends Employee {
    // Gestor herda as propriedades de Employee

    private String squadName;

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }
}
