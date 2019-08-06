package sort.merge;

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

            sort.mergeSort(decrescent, 0, decrescent.length);
            int worseCase = sort.counter;
            sort.counter = 0;

            sort.mergeSort(crescent, 0, crescent.length);
            int bestCase = sort.counter;
            sort.counter = 0;

            sort.mergeSort(random, 0, random.length);
            int middleCase = sort.counter;
            sort.counter = 0;

            Print.print(n + ";" + worseCase + ";" + bestCase + ";" + middleCase);
            //1;0;0;0;0;0
        }
    }
}
