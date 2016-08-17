package tasks.task1.task1_4;

/**
 * Created by Egor on 11.08.2016.
 */
public class MaxSum {

    public static int getLeftMaxSumIndex(double[] array){
        int indexMax = 0;
        int arraySize;
        double maxSum;
        int pairCount;

        arraySize = array.length;
        pairCount = arraySize / 2;
        maxSum = array[0] + array[arraySize - 1];

        for(int i = 1; i < pairCount; i++){
            double currentSum;
            currentSum = array[i] + array[arraySize - i];

            if (currentSum > maxSum){
                maxSum = currentSum;
                indexMax = i;
            }
        }

        return indexMax;
    }

    public static void printMaxSum(double[] array){
        int arraySize;
        int leftIndex;

        leftIndex = getLeftMaxSumIndex(array);
        arraySize = array.length;
        System.out.println("max sum = " + (array[leftIndex] + array[arraySize - leftIndex - 1]) +
                ", left index = " + leftIndex +
                ", rightIndex = " + (arraySize - leftIndex - 1));
    }
}
