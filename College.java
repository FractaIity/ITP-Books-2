import java.util.Random; // for random class
import java.util.ArrayList;
/**
 * The college class creates a new college with the specified number of students and number of books,
 * creating an array for students and creating a new library which also creates an array of books
 * The methods in this class then describe the state of the college and library, the next step method
 * selects a random student and makes them "study" by taking out a book or reading a chapter of their book until
 * the college has no students left
 * @author Louis Pike 
 * @version 05/11/2019
 */
public class College
{
    // instance variables - replace the example below with your own
    //private Student[] students; commented out code ---
    private ArrayList<Student> students; //creates the arraylist Students
    private Library lib; //creates the library lib
    private Random rng; //random num generator

    /**
     * Constructor for objects of class College
     * @param numOfStudents The number of students in the college
     * @param numOfBooks The number of books for the library class
     */
    public College(int numOfStudents, int numOfBooks)
    {
        lib = new Library(numOfBooks); // makes lib a new Library class with an array of books the size numOfBooks parameter entered
        //students = new Student[NumOfStudents]; //commented out previous code (didnt set up arraylist properly)
        students = new ArrayList<Student>(numOfStudents); //creates new array list with the size numOfStudents paramater entered
        rng = new Random(); //rng = new random class
        for (int i = 0; i < numOfStudents; i++ ) {
            String stuname = "student_" + i;
            //students = new Student(stuname, lib); //commented out previous code
            students.add(new Student(stuname, lib));
        }
        //the for loop fills the students array list, creating new elements until NumOfStudents elements have been created

    }

    /**-
     * Describes the current state of the college and then calls on the describe method from the library
     */
    public void describe()
    {
        System.out.println("The college has currently " + students.size() + " hard-working students");
        lib.describe();
    }

    /** 
     *   Next step runs if there are students left in the students array, it calls upon the finishedStudies method in the Student class, if it returns true
     *   then removes the student from the array, else it calls on the study method from the Student class
     */

    private void nextStep()
    {
        if (students.size() > 0) { //First if loop checks that the array isn't empty , if it has elements it goes into the nested loop, if not it executes else
            Student randomStu = students.get(rng.nextInt(students.size())); //creates student variable randomStu and uses rng to select element from array
            if (randomStu.finishedStudies() == true) { //calls on finishedStudies method from student class for randomStu
                System.out.println("Student has left the college."); //if true prints line
                students.remove(randomStu); //and then removes student randomStu from the array
            }
            else {
                randomStu.study();   //
            }
        }
        else {
            System.out.println("Everything has gone quiet."); //prints line if the student array is empty
        }
    }

    /** 
     *   runCollege prints out the number of steps, describes the state of the college and the calls nextStep
     *   this is repeated nSteps times.
     *   @param nSteps The number of times that nextStep is executed
     */
    public void runCollege(int nSteps)
    {
        int i = 0; //setting index int to 0 for the for loop
        for (i = 0; i < nSteps; i++) { //loops from 0 to nSteps, incrementing in 1
            System.out.println("Step " + i); //prints what step it is currently on
            describe(); //describes the state of the college
            nextStep(); //executes nextStep
        }
    }

     /** 
     *   static void main string args
     *   This is to make the program standalone, parses the values for each int needed to create the College class and how many steps to do and then
     *   runs the college
     */
    public static void main(String[] args)
    {
        int numOfStudents = Integer.parseInt(args[0]); //first value entered in cmd 
        int numOfBooks = Integer.parseInt(args[1]); //second value entered in cmd
        int nSteps = Integer.parseInt(args[2]); //third value entered in cmd
        College standalone = new College(numOfStudents, numOfBooks); //uses values entered to create college
        standalone.runCollege(nSteps); //

    }
}
