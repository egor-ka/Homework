package tasks.task1.task1_2;

import static java.util.Arrays.copyOf;

/**
 * Created by Egor on 11.08.2016.
 */
public class Sequence {

    public static int getIndex(double eps){

        if (eps <= 0) {
            return -1;
        }

        int index = 1;
        double element = 1 / (double)((index + 1) * (index + 1));

        for (; element >= eps; index++){
            System.out.println(element + " ");
            element = 1 / (double)((index + 1) * (index + 1));
        }
        return index;
    }
}
