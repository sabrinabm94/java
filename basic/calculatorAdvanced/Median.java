package basic.calculatorAdvanced;

public class Median
{
    public double calculateMedian(double[] vet)
    {
        int left = 0;
        int right = vet.length;
        double haft = 0;

        if (right % 2 == 0)
        { //método para listas pares
            double firstHaft = (left + right) / 2;
            double secondHaft = firstHaft - 1;

            print("Position of median: " + (firstHaft + secondHaft) / 2);

            return (vet[(int)firstHaft] + vet[(int)secondHaft]) / 2;
        }
        else
        { //método para listas ímpares
            haft = (left + right) / 2;
            print("Position of median: " + haft);

            return vet[(int)haft];
        }
    }

    public static void print(String text) {
        System.out.println();
    }
}
