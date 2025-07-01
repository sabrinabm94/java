package constructor;

public class Main {
    class people {
        public String name;
        private int age;

        public people() {
            //Chamada de outros constructores deve estar na primeira linha
            //this("without name");
            this("without name", 0);
            System.out.println("people creath !");
            //System.out.println("age: " + age);
        }

        public people(String name) { //constructor name
            //this.name = name;
            this(name, 0);
            System.out.println("name: " + name);
        }

        public people(int age) { //constructor age
            this("without name", age);
            System.out.println("age: " + age);
        }

        public people(String name, int age) {
            this.age = age;
            this.name = name;
            if(age < 0) {
                System.out.println("age less than zero");
                return;
            }
            System.out.println("constructor finished!");
        }
    }
}
