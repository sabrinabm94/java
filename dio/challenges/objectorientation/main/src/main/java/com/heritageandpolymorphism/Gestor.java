package com.heritageandpolymorphism;

public final class Gestor extends Employee {
    // Gestor herda as propriedades de Employee, no java não temos suporte a herança multipla

    private String squadName;

    protected String getSquadName() {
        return squadName;
    }

    protected void setSquadName(String squadName) {
        this.squadName = squadName;
    }
}
