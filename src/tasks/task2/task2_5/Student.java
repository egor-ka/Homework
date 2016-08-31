package tasks.task2.task2_5;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * Created by Egor on 31.08.2016.
 */
public class Student {
    private EnumMap<Discipline, ArrayList<Integer>> disciplineListWithMarks;

    public Student() {
        this.disciplineListWithMarks = new EnumMap<Discipline, ArrayList<Integer>>(Discipline.class);
    }

    public void addDiscipline(Discipline discipline){
        if (!disciplineListWithMarks.containsKey(discipline)){
            disciplineListWithMarks.put(discipline, new ArrayList<Integer>());
        }
    }

    public void addMarkToDiscipline(Discipline discipline, int mark){
        if (!disciplineListWithMarks.containsKey(discipline)){
            disciplineListWithMarks.put(discipline, new ArrayList<Integer>());
        }
        disciplineListWithMarks.get(discipline).add(mark);
    }

    public Discipline compareAndPrintMarks(){
        Discipline topDiscipline = Discipline.MATHEMATICS;
        double topAverageMark = 0;

        Discipline[] disciplines = Discipline.values();
        for (Discipline discipline: disciplines) {

            if (disciplineListWithMarks.containsKey(discipline)) {
                double averageMark = 0;
                ArrayList<Integer> currentDisciplineMarks = disciplineListWithMarks.get(discipline);
                System.out.print(discipline + ":");

                if (currentDisciplineMarks == null){
                    System.out.println(" NONE");
                } else {
                    for (int mark : currentDisciplineMarks) {
                        averageMark += mark;
                        System.out.print(" " + mark);
                    }
                    averageMark = averageMark / currentDisciplineMarks.size();
                    if (averageMark > topAverageMark) {
                        topAverageMark = averageMark;
                        topDiscipline = discipline;
                    }
                }
                System.out.println("\nAverage mark = " + averageMark);
            }
        }

        System.out.println("Best discipline is " + topDiscipline);
        return topDiscipline;
    }
}
