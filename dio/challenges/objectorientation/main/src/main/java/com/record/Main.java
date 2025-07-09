package com.record;

public class Main {
  public static void main(String[] args) {
    var person = new Person("Sabrina", 31);
    // System.out.println("O nome da pessoa é: " + person.name); Classe Person do
    // tipo Record: os atributos não acessível diretamente (fora de método)
    System.out.println("O nome da pessoa é: " + person.name());
  }
}
