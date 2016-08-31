package tasks.task2.task2_5;

import java.util.HashMap;

/**
 * Created by Egor on 31.08.2016.
 */
public class University {
    private HashMap<String, Student> students;

    public University() {
        this.students = new HashMap<>();
    }

    public void addStudent(String name){
        if (!students.containsKey(name)) {
            students.put(name, new Student());
        }
    }

    public void addMarkToStudent(String name, Discipline discipline, int mark){
        if (!students.containsKey(name)) {
            System.out.println("No such student!");
            return;
        }
        students.get(name).addMarkToDiscipline(discipline, mark);
    }

    public Discipline getStudentMarks(String name){
        if (!students.containsKey(name)) {
            System.out.println("No such student!");
            return null;
        }
        System.out.println("Student " + name + " has following marks:");
        return students.get(name).compareAndPrintMarks();
    }

    public boolean gotStudent(String name){
        return students.containsKey(name);
    }

}
