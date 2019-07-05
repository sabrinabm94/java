package sort.insertion;

public class Sort {
    public int sort(int[] vector) {
        int i, j, pivot, counter = 0;

        for(i = 1; i < vector.length; i++) { //controla o pivo e faz as trocas do menor para esquerda e maior para direita
            pivot = vector[i];
            for(j = i - 1; j >= 0; j--) { //come�o do pivo para os valores que tiver a esquerda, enquanto o 0 n�o for 0, caminhar� at� o in�cio do vetor
                counter = counter + 1;
                if(pivot < vector[j]) {
                    vector[j + 1] = vector[j]; //deslocamento do pivo
                } else {
                    break;
                }
            }

            vector[j + 1] = pivot; //deslocamento
            counter = counter + 1;
        }

        //Print.print("Number of instructions: " + counter);
        return counter;
    }
}
