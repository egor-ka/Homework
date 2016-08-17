package tasks.task1.task1_2;

import static java.util.Arrays.copyOf;

/**
 * Created by Egor on 11.08.2016.
 */
public class Sequence {

    private static int arraySize = 1;
    private static int arrayCapacity = 100;
    private static double[] array = new double[100];

    public static double getElementByIndex(int index){

        return array[index];
    }

    public static int getIndex(double eps){

        int index = arraySize;
        array[0] = 1;

        for(; array[index - 1] >= eps; index++){
            if(index >= arrayCapacity) {
                arrayCapacity = arrayCapacity * 2;
                array = copyOf(array, arrayCapacity);
            }
                array[index] = 1 / (double)((index + 1) * (index + 1));
                arraySize++;
        }
        return index;
    }

    public static void printSequence(int index) {
        if (index > arraySize) {
            System.out.println("index out of bound");
        } else {
            for (int i = 1; i < index; i++){
                System.out.println(array[i]);
            }

        }
    }

}
