package com.heritageandpolymorphism;

public sealed class Lead permits Manager {
  // classe sealed indica quais classes podem o herdar, que nesse caso é somente o
  // Manager

  private String leadName;
  public String leadType;
  protected String leadSquad;

  //métodos privados
  //Só podem ser visualizados dentro da classe (não em suas instâncias)
  private String getLeadName() {
    return leadName;
  }

  private void setLeadName(String leadName) {
    this.leadName = leadName;
  }

  //Métodos publicos
  //Podem ser acessados livremente mesmo por classes e instâncias fora do pacote
  public String getLeadType() {
    return leadType;
  }

  public void setLeadType(String leadType) {
    this.leadType = leadType;
  }

  //métodos protegidos
  //Acessados na classe definida, classes filhas e classes do mesmo pacote, e suas instâncias
  protected String getLeadSquad() {
    return leadSquad;
  }

  protected void setLeadSquad(String leadSquad) {
    this.leadSquad = leadSquad;
  }
}
