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
        university.addStudent("Petr Petrov");
        university.addStudent("Ivan Ivanov");
    }

    @Test
    public void gotStudentTest(){
        assertEquals("We found student which we do not got", false, university.gotStudent("Vasya Vasiliev"));
        assertEquals("We did not find student we have", true, university.gotStudent("Petr Petrov"));
    }

    @Test
    public void topDisciplineTest(){
        university.addMarkToStudent("Petr Petrov", Discipline.JAVA_PROGRAMMING, 5);
        university.addMarkToStudent("Petr Petrov", Discipline.JAVA_PROGRAMMING, 3);

        university.addMarkToStudent("Petr Petrov", Discipline.MATHEMATICS, 4);
        university.addMarkToStudent("Petr Petrov", Discipline.MATHEMATICS, 2);

        assertEquals("Wrong top discipline", Discipline.JAVA_PROGRAMMING, university.getStudentMarks("Petr Petrov"));

        university.addMarkToStudent("Petr Petrov", Discipline.PHYSICAL_EDUCATION, 5);
        university.addMarkToStudent("Petr Petrov", Discipline.PHYSICAL_EDUCATION, 5);

        assertEquals("Wrong top discipline", Discipline.PHYSICAL_EDUCATION, university.getStudentMarks("Petr Petrov"));
    }

}
