package tasks.task2.task2_5;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Egor on 31.08.2016.
 */
public class University {
    private HashMap<Discipline, Group> groups;

    public University() {
        groups = new HashMap<>();
        groups.put(Discipline.MATHEMATICS, new Group<Double>());
        groups.put(Discipline.ECONOMICS, new Group<Double>());
        groups.put(Discipline.JAVA_PROGRAMMING, new Group<Integer>());
        groups.put(Discipline.PHYSICAL_EDUCATION, new Group<Integer>());
    }

    public void addStudent(Discipline discipline, String student){
        if (!groups.get(discipline).hasStudent(student)) {
            groups.get(discipline).addStudent(student);
        }
    }

    public void addMarkByDiscipline(Discipline discipline, String student, double mark){
        if (!groups.get(discipline).hasStudent(student)){
            addStudent(discipline, student);
        }
        groups.get(discipline).addMark(student, mark);
    }

    public void printGroupsForStudent(String student) {
        Discipline[] disciplines = Discipline.values();

        System.out.println("Student " + student + " is in following groups:");
        for (Discipline discipline: disciplines) {
            if (groups.get(discipline).hasStudent(student)) {
                System.out.print(discipline + ", ");
            }
        }
        System.out.println("\n");
    }

    public Discipline getStudentMarks(String student){
        Discipline topDiscipline = null;
        double topAverageMark = 0;

        System.out.println("Student " + student + " has following marks:");

        Discipline[] disciplines = Discipline.values();
        for (Discipline discipline: disciplines) {
            double averageMark = 0;

            if (groups.get(discipline).hasStudent(student)) {
                ArrayList<Integer> currentDisciplineMarks = groups.get(discipline).getMarks(student);
                System.out.print(discipline + ":");

                if (currentDisciplineMarks.size() == 0) {
                    System.out.println(" NONE");
                } else {
                    for (Number mark : currentDisciplineMarks) {
                        averageMark += (double)mark;
                        System.out.print(" " + mark);
                    }
                    averageMark = averageMark / currentDisciplineMarks.size();
                    if (averageMark > topAverageMark) {
                        topAverageMark = averageMark;
                        topDiscipline = discipline;
                    }
                    System.out.println("\nAverage mark = " + averageMark);
                }
            }
        }

        if(topDiscipline != null) {
            System.out.println("Best discipline is " + topDiscipline + "\n");
        } else {
            System.out.println("Student does not have any marks");
        }
        return topDiscipline;
    }

    public boolean hasStudentInUniversity(String student){
        Discipline[] disciplines = Discipline.values();

        for (Discipline discipline: disciplines) {
            if (groups.get(discipline).hasStudent(student)){
                return true;
            }
        }
        return false;
    }
}
