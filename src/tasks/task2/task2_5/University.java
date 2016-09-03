package tasks.task2.task2_5;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * Created by Egor on 31.08.2016.
 */
public class University {
    private EnumMap<DisciplineName, Group> groups;
    ArrayList<Discipline> disciplines = new ArrayList<>();

    public University() {
        disciplines.add(new Discipline<Double>(DisciplineName.ECONOMICS));
        disciplines.add(new Discipline<Integer>(DisciplineName.JAVA_PROGRAMMING));
        disciplines.add(new Discipline<Double>(DisciplineName.MATHEMATICS));
        disciplines.add(new Discipline<Integer>(DisciplineName.PHYSICAL_EDUCATION));

        groups = new EnumMap<>(DisciplineName.class);
        for (Discipline discipline: disciplines) {
            groups.put(discipline.getDisciplineName(), discipline.createGroup());
        }
    }

    public void addStudent(DisciplineName disciplineName, String student){
        if (!groups.get(disciplineName).hasStudent(student)) {
            groups.get(disciplineName).addStudent(student);
        }
    }

    public void addMarkByDiscipline(DisciplineName disciplineName, String student, Number mark){
        if (!groups.get(disciplineName).hasStudent(student)){
            addStudent(disciplineName, student);
        }
        groups.get(disciplineName).addMark(student, mark);
    }

    public void printGroupsForStudent(String student) {
        DisciplineName[] disciplineNames = DisciplineName.values();

        System.out.println("Student " + student + " is in following groups:");
        for (DisciplineName disciplineName : disciplineNames) {
            if (groups.get(disciplineName).hasStudent(student)) {
                System.out.print(disciplineName + ", ");
            }
        }
        System.out.println("\n");
    }

    public DisciplineName getStudentMarks(String student){
        DisciplineName topDisciplineName = null;
        double topAverageMark = 0;

        System.out.println("Student " + student + " has following marks:");

        DisciplineName[] disciplineNames = DisciplineName.values();
        for (DisciplineName disciplineName : disciplineNames) {
            double averageMark = 0;

            if (groups.get(disciplineName).hasStudent(student)) {
                ArrayList<Number> currentDisciplineMarks = groups.get(disciplineName).getMarks(student);
                System.out.print(disciplineName + ":");

                if (currentDisciplineMarks.size() == 0) {
                    System.out.println(" NONE");
                } else {
                    for (Number mark : currentDisciplineMarks) {
                        averageMark += mark.doubleValue();
                        System.out.print(" " + mark);
                    }
                    averageMark = averageMark / currentDisciplineMarks.size();
                    if (averageMark > topAverageMark) {
                        topAverageMark = averageMark;
                        topDisciplineName = disciplineName;
                    }
                    System.out.println("\nAverage mark = " + averageMark);
                }
            }
        }

        if(topDisciplineName != null) {
            System.out.println("Best discipline is " + topDisciplineName + "\n");
        } else {
            System.out.println("Student does not have any marks");
        }
        return topDisciplineName;
    }

    public boolean hasStudentInUniversity(String student){
        DisciplineName[] disciplineNames = DisciplineName.values();

        for (DisciplineName disciplineName : disciplineNames) {
            if (groups.get(disciplineName).hasStudent(student)){
                return true;
            }
        }
        return false;
    }
}
