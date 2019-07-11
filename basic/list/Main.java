package list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javaRepositories.Print;

public class Main {
    public static void main(String[] args) {
        //lista não aceita tipos primitivos. Exp não aceita int e sim Integer
        List<String> names = new ArrayList<>();

        names.add("Sivy");
        names.add("Alexander");
        names.add("Liv");
        names.add("Rebeka");
        names.add("Erik");
        names.add("Alek");
        names.add(3, "Viktoria");

        print(names);
        removeByname(names, "Viktoria");
        print(names);

        Print.print("\nNames searched by first letter: " + getNamesByFirstLetter(names, 'A'));

        print(names);
        removeByFirstLetter(names, 'A');
        print(names);
    }

    public static void print(List<String> names) {
        Print.print("\nSize: " + names.size());
        Print.print("Names: ");
        //foreach
        for(String name: names) {
            Print.print(name);
        }
    }

    public static List<String> removeByname(List<String> list, String value) {
        list.remove(value);

        return list;
    }

    public static List<String> removeByFirstLetter(List<String> list, char value) {
        list.removeIf(name -> name.charAt(0) == value);

        return list;
    }

    public static List<String> getNamesByFirstLetter(List<String> list, char value) {
        return list.stream().filter(name -> name.charAt(0) == value).collect(Collectors.toList());
    }
}
