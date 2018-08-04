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
        System.out.println("Even list");
        System.out.println("Average: " + resultAverageEven);

        double resultMedianEven = median.calculateMedian(listEven);
        System.out.println("Value of median: " + resultMedianEven);

        String resultClassificationEven = classification.classificationConcept(resultMedianEven);
        System.out.println("Classification: " + resultClassificationEven);
        System.out.println("");

        //lista com total de 5 posições - impar 
        double[] listOdd = { 1, 2, 3, 4, 5 };

        double resultAverageOdd = average.calculateAverage(listOdd);
        System.out.println("Odd list");
        System.out.println("Average: " + resultAverageOdd);

        double resultMedianOdd = median.calculateMedian(listOdd);
        System.out.println("Value of median: " + resultMedianOdd);

        String resultClassificationOdd = classification.classificationConcept(resultMedianOdd);
        System.out.println("Classification: " + resultClassificationOdd);
        System.out.println("");
    }
}
