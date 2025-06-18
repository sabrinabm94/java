package performance.instructionsCounter;

import javaRepositories.Print;

public class Algorithm {
    public int worseCase(int v[]) {
        int counter = 0;
        int min = v[0];
        int max = v[0];

        for (int i = 1; i < v.length; i++) {
            counter = counter +1;
            if (v[i] > max) {
                counter = counter +1;
                max = v[i];
            }
            counter = counter +1;
            if (v[i] < min) {
                counter = counter +1;
                min = v[i];
            }
        }

        //Print.print("Number of instructions: " + counter);
        return counter;
    }

    public int mediumCase(int v[]) {
        int counter = 0;
        int min = v[0];                     // 1
        int max = v[0];

        for (int i = 1; i < v.length; i++) {
            counter = counter +1;
            if (v[i] > max) {
                counter = counter +1;
                max = v[i];
            }
            else {
                counter = counter +1;
                if(v[i] < min) {
                    counter = counter +1;
                    min = v[i];
                }
            }
        }

        //Print.print("Number of instructions: " + counter);
        return counter;
    }
    public int bestCaseEven(int v[]) {
        int counter = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int a, b;

        for (int i = 0; i < v.length; i += 2) {
            counter = counter +1;
            if (v[i] < v[i + 1]) {
                counter = counter +2;
                a = i;
                b = i + 1;
            } else {
                counter = counter +2;
                a = i + 1;
                b = i;
            }
            counter = counter +1;
            if(v[a] < min) {
                counter = counter +1;
                min = v[a];
            }
            counter = counter +1;
            if(v[b] > max) {
                counter = counter +1;
                max = v[b];
            }

        }

        //Print.print("Number of instructions:" + counter);
        return counter;
    }
    public int bestCaseOdd(int v[]) {
        int counter = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int a, b;

        for (int i = 0; i < v.length - 1; i += 2) {
            counter = counter +1;
            if (v[i] < v[i + 1]) {
                counter = counter +2;
                a = i;
                b = i + 1;
            } else {
                counter = counter +2;
                a = i + 1;
                b = i;
            }

            counter = counter +1;
            if(v[a] < min) {
                counter = counter +1;
                min = v[a];
            }

            counter = counter +1;
            if(v[b] > max) {
                counter = counter +1;
                max = v[b];
            }

            counter = counter +1;
            if(v[v.length-1] < min) {
                counter = counter +1;
                min = v[v.length-1];
            }

            counter = counter +1;
            if(v[v.length-1] > max) {
                counter = counter +1;
                max = v[v.length-1];
            }
        }

        //Print.print("Number of instructions: " + counter);
        return counter;
    }
}
