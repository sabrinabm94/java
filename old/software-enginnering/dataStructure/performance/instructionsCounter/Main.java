package performance.instructionsCounter;

import javaRepositories.Print;
import javaRepositories.Populate;

public class Main {
    public static void main(String[] args) {
        Populate population = new Populate();
        Algorithm algorithm = new Algorithm();

        for(int n = 1; n < 100; n++){
            int[] crescent = new int [n];
            int[] decrescent = new int [n];
            int[] random = new int [n];

            population.crescent(crescent);
            population.decrescent(decrescent);
            population.random(random);

            int worseCaseCrescent = algorithm.worseCase(crescent);
            int mediumCaseCrescent = algorithm.mediumCase(crescent);
            int mediumCaseDecrecent = algorithm.mediumCase(decrescent);
            int mediumCaseRandom = algorithm.mediumCase(random);
            int bestCaseEvenCrescent = 0, bestCaseOddCrescent = 0;

            //even - odd error tratament
            if(n % 2 == 0) {
                bestCaseEvenCrescent = algorithm.bestCaseEven(crescent);
            } else {
                bestCaseOddCrescent = algorithm.bestCaseOdd(crescent);
            }

            Print.print(n + ";" + worseCaseCrescent + ";" + mediumCaseCrescent + ";" + mediumCaseDecrecent + ";" + mediumCaseRandom + ";" + bestCaseEvenCrescent + ";" + bestCaseOddCrescent);
            //1;0;0;0;0;0
        }
    }
}
