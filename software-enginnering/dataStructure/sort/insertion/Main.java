package sort.insertion;

import javaRepositories.Print;
import javaRepositories.Populate;

public class Main {
    public static void main(String[] args) {
        Populate population = new Populate();
        Sort sort = new Sort();

        for(int n = 1; n < 1000; n++) {
            int[] crescent = new int [n];
            int[] decrescent = new int [n];
            int[] random = new int [n];

            population.crescent(crescent);
            population.decrescent(decrescent);
            population.random(random);

            int crescentSort = sort.sort(crescent);

            int descrescentSort = sort.sort(decrescent);

            int randomSort = sort.sort(random);

            Print.print(n + ";" + crescentSort + ";" + descrescentSort + ";" + randomSort);
            //1;0;0;0;0;0
        }
    }
}
