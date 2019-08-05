package objectOriented.carRental.service;

public interface TaxService {
    /*
    Interfaces clássicas: não tem implementação de métodos
    carRental java 8+: podem ter implementação de métodos

    É um tipo que define um conjunto de operações que uma classe deverá implementar.
    Estabelecando um contrato que a classe deve cumprir.
    É utilizado para criar sistemas com baixo acoplamento de flexíveis.
    */

    double tax(double amount);
}
