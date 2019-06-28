class Main {
  public static void main(String[] args) {
    long initialTime = System.currentTimeMillis();

    Knapsack knapsack = new Knapsack(3);
    BruteForceAlgorithm brute = new BruteForceAlgorithm();
    brute.execute(knapsack);

    long finishTime = System.currentTimeMillis();
    long dif = (finishTime - initialTime);
    System.out.println(String.format("%02d secunds  e %02d miliseconds", dif/60, dif%60));
  }
}