package sort.selection;

public class Sort {
    public int sort(int[] vector) {
        int i, j, minPosition, helper, counter = 0;

        for(i = 0; i < vector.length; i++) { //controla a variável min
            minPosition  = i;
            for(j = i + 1; j < vector.length; j++) { //da posição min para frente quem é o menor?, faz a ordenação
                counter = counter +1;
                if(vector[j] < vector[minPosition]) {
                    minPosition = j;
                }
            }

            counter = counter +1;

            if(vector[i] != vector[minPosition]) {
                counter = counter +1;
                helper = vector[i];
                vector[i] = vector[minPosition];
                vector[minPosition] = helper;
            }
        }
        return counter;
        //Print.print("Number of instructions: " + counter);
    }
}
