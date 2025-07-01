package com.objectorientation.heritageandpolymorphism;
public sealed class Lead permits Manager {
  // classe sealed indica quais classes podem o herdar, que nesse caso é somente o Manager

  private String leadType;

  public String getlLeadType() {
    return leadType;
  }

  public void setLeadType(String leadType) {
    this.leadType = leadType;
  }
}
