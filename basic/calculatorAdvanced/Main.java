package calculatorAdvanced;

import javaRepositories.Print;

public class Main
{
    public static void main(String[] args)
    {
        Average average = new Average();
        Median median = new Median();
        Classification classification = new Classification();

        //lista com total de 6 posições - par
        double[] listEven = { 1, 2, 3, 4, 5, 6 };

        double resultAverageEven = average.calculateAverage(listEven);
        Print.print("Even list");
        Print.print("Average: " + resultAverageEven);

        double resultMedianEven = median.calculateMedian(listEven);
        Print.print("Value of median: " + resultMedianEven);

        String resultClassificationEven = classification.classificationConcept(resultMedianEven);
        Print.print("Classification: " + resultClassificationEven);
        Print.print("");

        //lista com total de 5 posições - impar
        double[] listOdd = { 1, 2, 3, 4, 5 };

        double resultAverageOdd = average.calculateAverage(listOdd);
        Print.print("Odd list");
        Print.print("Average: " + resultAverageOdd);

        double resultMedianOdd = median.calculateMedian(listOdd);
        Print.print("Value of median: " + resultMedianOdd);

        String resultClassificationOdd = classification.classificationConcept(resultMedianOdd);
        Print.print("Classification: " + resultClassificationOdd);
        Print.print("");
    }
}