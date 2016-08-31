package tasks.task2.task2_5;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Egor on 31.08.2016.
 */
public class Group<MarkType> {
    private HashMap<String, ArrayList<MarkType>> students;


    public Group() {
        this.students = new HashMap<>();
    }

    public void addStudent(String student){
        if (!students.containsKey(student)){
            students.put(student, new ArrayList<>());
        }
    }

    public boolean hasStudent(String student){
        return students.containsKey(student);
    }

    public void addMark(String student, MarkType mark){
        if (!students.containsKey(student)){
            students.put(student, new ArrayList<>());
        }
        students.get(student).add(mark);
    }

    public ArrayList<MarkType> getMarks(String student){
        return students.get(student);
    }
}
