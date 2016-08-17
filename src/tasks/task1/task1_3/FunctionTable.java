package tasks.task1.task1_3;

import static java.lang.Math.tan;

/**
 * Created by Egor on 11.08.2016.
 */
public class FunctionTable {

    /**
     *
     * @param angle - angle in radians
     * @return function value
     */
    public static double function(double angle){
        return tan(2 * angle) - 3;
    }

    public static void printTable(double leftBound, double rightBound, double step){
        double currentArgument = leftBound;

        System.out.println("----------------------");
        for(; currentArgument < rightBound; currentArgument += step){
            System.out.printf("|%10f|%10f|%n", currentArgument, function(currentArgument));
            System.out.println("----------------------");
        }
        System.out.printf("|%10f|%10f|%n", rightBound, function(rightBound));
        System.out.println("----------------------");
    }
}
