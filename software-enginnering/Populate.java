package javaRepositories;

public class Populate {
    public void crescent(int vector[]) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = i + 1;
            //Print.print("Crescent - added value: " + vetor[i]);
        }
    }
    public void decrescent(int vector[]) {
        int counterDescreasing = 0;
        for (int i = vector.length - 1; i >= 0; i--) {
            vector[counterDescreasing++] = i;
            //Print.print("Decreasing - added value: " + vetor[i]);
        }
    }
    public void random(int vector[]) {
        for(int i = 0; i < vector.length; i++) {
            vector[i] = (int)(Math.random() * 100);
            //Print.print("Random - added value: " + vetor[i]);
        }
    }
}
