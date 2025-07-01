package com.objectorientation.record;

public record Person(String name, int age) {
  // todos os atributos declarados numa classe record são privadas e só podem ser
  // acessados por método
}
