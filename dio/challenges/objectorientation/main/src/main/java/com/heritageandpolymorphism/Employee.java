package com.heritageandpolymorphism;

public abstract class Employee {
  // classe abstrada que não pode ser instanciada

  private String code;
  private String name;
  private String address;
  private int age;
  private int salary;

  protected String getCode() {
    return code;
  }

  protected void setCode(String code) {
    this.code = code;
  }

  protected String getName() {
    return name;
  }

  protected void setName(String name) {
    this.name = name;
  }

  protected String getAddress() {
    return address;
  }

  protected void setAddress(String address) {
    this.address = address;
  }

  protected int getAge() {
    return age;
  }

  protected void setAge(int age) {
    this.age = age;
  }

  protected int getSalary() {
    return salary;
  }

  protected void setSalary(int salary) {
    this.salary = salary;
  }
}
