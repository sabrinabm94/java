package sort.bubble;

public class Sort {
    public int sort(int[] vector) {
        int helper = 0, counter = 0;
        for(int i = 0; i < vector.length; i++){
            for(int j = i + 1;j < vector.length; j++){
                counter = counter + 1;
                if(vector[j] > vector[i]) {
                    helper = vector[i];
                    vector[i] = vector[j];
                    vector[j] = helper;
                }
            }
        }
        //Print.print("Number of instructions: " + counter);
        return counter;
    }
}
