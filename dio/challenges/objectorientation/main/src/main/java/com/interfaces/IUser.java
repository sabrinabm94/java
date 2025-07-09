package com.interfaces;

public interface IUser {
  // Todas as propriedades declaradas em uma interface são públicas finais e
  // estáticas
  // ou seja, pode ser acessado livremente pela definição de público, não pode ter
  // seu valor alterado pois é final e pode ser acessado diretamente pelo seu
  // tipo, por ser estático.
  String name = "";
  Integer age = 0;

  void startWorkingDay();

  void endWorkDay();
}
