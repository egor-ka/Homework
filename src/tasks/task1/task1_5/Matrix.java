package tasks.task1.task1_5;

/**
 * Created by Egor on 17.08.2016.
 */
public class Matrix {

    public static int[][] getCrossMatrix(int size){
        int[][] matrix = new int[size][size];

        for(int i = 0; i < size; i++){
            matrix[i][i] = 1;
            matrix[i][size - i - 1] = 1;
        }

        return matrix;
    }

}
