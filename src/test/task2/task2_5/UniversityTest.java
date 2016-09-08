package test.task2.task2_5;

import org.junit.Before;
import org.junit.Test;
import tasks.task2.task2_5.DisciplineName;
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

        university.addStudent(DisciplineName.JAVA_PROGRAMMING, "Petr Petrov");
        university.addStudent(DisciplineName.MATHEMATICS, "Petr Petrov");
        university.addStudent(DisciplineName.PHYSICAL_EDUCATION, "Petr Petrov");
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
        university.addMarkByDiscipline(DisciplineName.JAVA_PROGRAMMING, "Petr Petrov", 5);
        university.addMarkByDiscipline(DisciplineName.JAVA_PROGRAMMING, "Petr Petrov", 3);

        university.addMarkByDiscipline(DisciplineName.MATHEMATICS, "Petr Petrov", 4.2);
        university.addMarkByDiscipline(DisciplineName.MATHEMATICS, "Petr Petrov", 2.7);

        assertEquals("Wrong top discipline", DisciplineName.JAVA_PROGRAMMING, university.getStudentMarks("Petr Petrov"));

        university.addMarkByDiscipline(DisciplineName.PHYSICAL_EDUCATION, "Petr Petrov", 5);
        university.addMarkByDiscipline(DisciplineName.PHYSICAL_EDUCATION, "Petr Petrov", 5);

        assertEquals("Wrong top discipline", DisciplineName.PHYSICAL_EDUCATION, university.getStudentMarks("Petr Petrov"));
    }


}
