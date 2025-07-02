package com.heritageandpolymorphism;

public class Main {
  // Método estático é um método chamado automaticamente ao instanciar uma classe
  public static void main(String[] args) {
    // Employee employee = new Employee(); Employee não poder ser instânciada por
    // ser uma classe abstrata
    Salesman salesman = new Salesman();
    Gestor gestor = new Gestor();
    Manager manager = new Manager();
    Lead lead = new Lead();
    /*
     * Polimorfismo: capacidade de um objeto em assumir diferentes características
     * de acordo com a hierarquia das classes que herdam.
     * Hierarquia:
     * 1 Employee (abstrato - não instanciável)
     * 2 Salesman (Herança: herda Employee)
     * 3 Gestor (Herança: herda Employee)
     * 4 Manager (Herança: herda lead e final - não pode ser extendida pois é a
     * ultima da hierarquia)
     * 5 Lead (Sealed: permite herança somente pelo Manager)
     */

    salesman.setSalesGoal(900);
    gestor.setName("Sabrina"); // Herança: Gestor usando propriedades de Employee
    gestor.setAge(35);

    /*
     * O Manager herda a classe Lead sealed
     * Todas as classes abaixo de lead devem ser classificadas como sealed, no
     * selead ou final
     * A classe sealed só pode ser entendida pelas classes definidas em permits
     */
    manager.setLeadType("Tech"); // Herança Sealed: Manager usando propriedade de Lead
    // manager.setLeadName("Tech lead"); não é possivel ver o método privado fora
    // da sua classe, nem pela instância de uma filha
    // lead.setLeadName("Tech lead"); não é possivel ver o método privado fora da
    // sua classe, nem por sua instância
    manager.setLeadSquad("Plataform");
    lead.setLeadSquad("Data");

    System.out.println("\n\nInformações de cargos... ");

    System.out.println("A meta de venda do vendedor é: " + salesman.getSalesGoal());
    System.out.println("O nome do gestor é: " + gestor.getName());

    System.out.println("\nGerente... ");
    System.out.println("O tipo de gerente é: " + manager.getLeadType());
    System.out.println("A equipe do gerente é: " + manager.getLeadSquad());

    System.out.println("\nLider... ");
    System.out.println("A equipe do lider é: " + lead.getLeadSquad());
  }
}
