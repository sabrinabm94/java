package com.objectorientation.heritageandpolymorphism;

public class Main {
  public static void main(String[] args) {
    // Employee employee = new Employee(); Employee não poder ser instânciada por
    // ser uma classe abstrata
    Salesman salesman = new Salesman();
    Gestor gestor = new Gestor();
    Manager manager = new Manager();

    /*
     * Polimorfismo: capacidade de um objeto em assumir diferentes características
     * de acordo com a hierarquia das classes que herdam.
     * Hierarquia:
     * 1 Employee (abstrato - não instanciável)
     * 2 Salesman (Herança: herda Employee)
     * 3 Gestor (Herança: herda Employee)
     * 4 Manager (Herança: herda lead e final - não pode ser extendida)
     * 5 Lead (Sealed: permite herança somente pelo Manager)
     */

    salesman.setSalesGoal(900);
    gestor.setName("Sabrina"); // Herança: Gestor usando propriedades de Employee
    gestor.setAge(35);

    /*
     * O Manager herda a classe Lead sealed
     * Todas as classes abaixo de lead devem ser classificadas como sealed, not
     * selead ou final
     */
    manager.setLeadType("Tech"); // Herança Sealed: Manager usando propriedade de Lead

    System.out.println("A meta de venda do vendedor é: " + salesman.getSalesGoal());
    System.out.println("O nome do gestor é: " + gestor.getName());
    System.out.println("O tipo de gerente é: " + manager.getlLeadType());
  }
}
