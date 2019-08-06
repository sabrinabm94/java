package sort.bubbleBetter;

import javaRepositories.Print;
import javaRepositories.Populate;

public class Main {
    public static void main(String[] args) {
        Populate populate = new Populate();
        Sort sort = new Sort();

        for(int n = 1; n < 1000; n++){
            int[] crescent = new int [n];
            int[] decrescent = new int [n];
            int[] random = new int [n];

            populate.crescent(crescent);
            populate.decrescent(decrescent);
            populate.random(random);

            int crescentSort = sort.sort(crescent);

            int descrescentSort = sort.sort(decrescent);

            //minmax2r
            int randomSort = sort.sort(random);

            Print.print(n + ";" + crescentSort + ";" + descrescentSort + ";" + randomSort);
            //1;0;0;0;0;0
        }
    }
}
