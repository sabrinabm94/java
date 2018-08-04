public class Average
{
    public double calculateAverage(double[] vet)
    {
        double sum = 0;

        for (int i = 0; i < vet.length; i++)
        {
            sum += vet[i];
        }
        return sum / vet.length;
    }
}

