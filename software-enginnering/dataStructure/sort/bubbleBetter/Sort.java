package sort.bubbleBetter;

public class Sort {
    public int sort(int[] vector) {
        int i, j, helper, counter = 0;
        boolean changed = true;
        int firstChange = -1;

        while(changed) {
            changed = false;
            i = firstChange + 1;

            while(i < vector.length - 1) {
                counter = counter + 1;

                if(vector[i] > vector[i+1]) {
                    counter = counter + 1;
                    helper = vector[i];
                    vector[i] = vector[i+1];
                    vector[i+1] = helper;
                    changed = true;

                    if(!changed) {
                        counter = counter + 1;
                        firstChange = i;
                    }
                }
                i++;
            }
        }
        //Print.print("Number of instructions: " + counter);
        return counter;
    }
}
