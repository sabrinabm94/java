package sort.merge;

public class Sort {
    public static int counter = 0;
    public void merge(int[] vector, int first, int start, int end) {
        int[] vectorHelper = new int[start+end];
        int helper = 0, helperOne = 0, helperTwo = 0;

        while((helperOne < start) && (helperTwo < end)) {
            counter = counter + 1;
            if (vector[first + helperOne] < vector[first + start + helperTwo]) {
                vectorHelper[helper++] = vector[first + helperOne++];
            }
            else {
                vectorHelper[helper++] = vector[first + start + helperTwo++];
            }
        }

        while(helperOne < start) {
            counter = counter + 1;
            vectorHelper[helper++] = vector[first + helperOne++];
        }

        while(helperTwo < end) {
            counter = counter + 1;
            vectorHelper[helper++] = vector[first + start + helperTwo++];
        }

        for(int i = 0; i < start+end; i++) {
            counter = counter + 1;
            vector[first + i] = vectorHelper[i];
        }
    }

    public void mergeSort(int[] vector, int first, int last) {
        int start, end;

        if(last > 1) {
            start = last/2;
            end = last - start;

            mergeSort(vector, first, start); //método recursivo
            mergeSort(vector, first + start, end); //método recursivo
            merge(vector, first, start, end);
        }
    }
}
