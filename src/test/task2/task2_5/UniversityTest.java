package test.task2.task2_5;

import org.junit.Before;
import org.junit.Test;
import tasks.task2.task2_5.Discipline;
import tasks.task2.task2_5.University;

import static org.junit.Assert.assertEquals;

/**
 * Created by Egor on 31.08.2016.
 */
public class UniversityTest {
    University university;

    @Before
    public void setUp(){
        university = new University();

        university.addStudent(Discipline.JAVA_PROGRAMMING, "Petr Petrov");
        university.addStudent(Discipline.MATHEMATICS, "Petr Petrov");
        university.addStudent(Discipline.PHYSICAL_EDUCATION, "Petr Petrov");
    }

    @Test
    public void gotStudentTest(){
        assertEquals("We found student we do not have", false, university.hasStudentInUniversity("Vasya Vasiliev"));

        assertEquals("We did not find student we have", true, university.hasStudentInUniversity("Petr Petrov"));
    }

    @Test
    public void printGroupsForStudentTest(){
        university.printGroupsForStudent("Petr Petrov");
    }

    @Test
    public void topDisciplineTest(){
        university.addMarkByDiscipline(Discipline.JAVA_PROGRAMMING, "Petr Petrov", 5);
        university.addMarkByDiscipline(Discipline.JAVA_PROGRAMMING, "Petr Petrov", 3);

        university.addMarkByDiscipline(Discipline.MATHEMATICS, "Petr Petrov", 4.2);
        university.addMarkByDiscipline(Discipline.MATHEMATICS, "Petr Petrov", 2.7);

        assertEquals("Wrong top discipline", Discipline.JAVA_PROGRAMMING, university.getStudentMarks("Petr Petrov"));

        university.addMarkByDiscipline(Discipline.PHYSICAL_EDUCATION, "Petr Petrov", 5);
        university.addMarkByDiscipline(Discipline.PHYSICAL_EDUCATION, "Petr Petrov", 5);

        assertEquals("Wrong top discipline", Discipline.PHYSICAL_EDUCATION, university.getStudentMarks("Petr Petrov"));
    }


}
