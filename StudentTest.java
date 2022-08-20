

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest
{
    private Library library1;
    private Student student1;

    /**
     * Default constructor for test class StudentTest
     */
    public StudentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
        library1 = new Library(10);
        student1 = new Student("testStudentName", library1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testFinishedStudies()
    {
         Library library1 = new Library(10);
        Student student1 = new Student("testStudentName", library1);
        student1.describe();
        assertEquals(false, student1.finishedStudies());
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        student1.study();
        assertEquals(true, student1.finishedStudies());
    }

    @Test
    public void testStudentDescribe()
    {
        student1.describe();
        student1.study();
        student1.describe();
    }

    @Test
    public void testStudentStudy()
    {
        student1.study();
    }
}



