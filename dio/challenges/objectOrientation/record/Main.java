public class Main {
  public static void main(String[] args) {
    var person = new Person("Sabrina", 31);
    String personName = person.name;
    System.out.println("O nome da pessoa é: ", personName);
    System.out.println("O nome da pessoa é: ", person.name());
  }
}
