package sort.bubble;

import javaRepositories.Print;
import javaRepositories.Populate;

public class Main {
    public static void main(String[] args) {
        Populate population = new Populate();
        Sort sort = new Sort();

        for (int i = 1; i < 1000; i++) {
            int[] crescent = new int[i];
            int[] decrescent = new int[i];
            int[] random = new int[i];

            population.crescent(crescent);
            population.decrescent(decrescent);
            population.random(random);

            int crescentSort = sort.sort(crescent);
            int descrescentSort = sort.sort(decrescent);
            int randomSort = sort.sort(random);

            Print.print(i + ";" + crescentSort + ";" + descrescentSort + ";" + randomSort);
            //1;0;0;0;0;0
        }
    }
}
