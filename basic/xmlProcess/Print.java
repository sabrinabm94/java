package sabrina.bootcamp;

public class Print {
    public static void print(String text) {
        System.out.print(text);
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void printf(String text) {
        System.out.printf(text);
    }

    public static void clear() {
        System.out.flush();
    }
    
    public static void printErrorMessage(String error) {
        Print.println("Error: " + error);
    }
}