

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CollegeTest.
 *
 * @author  Louis Pike
 * @version 10/12/2019
 */
public class CollegeTest
{
    private College college1;

    /**
     * Default constructor for test class CollegeTest
     */
    public CollegeTest()
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
        
        college1 = new College(2, 10);
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
    public void testrunCollege()
    {
        College college1 = new College(2, 10);
        college1.describe();
        college1.runCollege(100);
    }
    
    @Test
    public void testDescribeCollege()
    {
        college1.describe();
        college1.runCollege(2);
        college1.describe();
    }
}

