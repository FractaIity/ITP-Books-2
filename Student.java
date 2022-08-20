
/**
 * The Student class is responsible for creating Student objects using a name and library assigned to it, along with calling on the Library class' issue card
 * to assign the student a LibraryCard element, it also assigns the student to hold a TextBook element.
 * The methods then allow the user to see if the student has finished their studies by checking if they hold a book currently and the status of their library card
 * The study method checks if the Student already has a book and if not assigns them one and makes them study it. The describe method describes the status of the
 * current Student object
 *
 * @author Louis Pike
 * @version 03/11/2019
 */
public class Student
{
    // instance variables - replace the example below with your own
    private String stuName;
    private Library stuLibrary;
    private LibraryCard stuCard;
    private TextBook stuBook;

    /**
     * Constructor for objects of class Student, creates Student with a name, assigns a Library class and LibraryCard class and set the book to null.
     * @param name The name for the student
     * @param library The library for the student
     * 
     */
    public Student(String name, Library library)
    {
        stuName= name; // stuName set to name parameter
        stuLibrary = library; // stuLibrary set to the library parameter
        stuCard = library.issueCard(); //same library used to create the card
        stuBook = null; //book is set to null - so student doesnt have a current book
    }

    /**
     * finishedStudies check if the student's library card has expired by calling on the expired method from the LibraryCard class and if the student has a 
     * current book. Needs book to be null and the library card to be expired to be true, else false.
     * @return boolean result of stuCard.expired
     * 
     */
    public boolean finishedStudies()
    {
        boolean finished = false; //sets finished to false
        if ((stuBook == null) & stuCard.expired()) { //needs the students book to be null and the stuCard library card to be expired
            finished = true; //sets finished to true
        }
        return finished; //returns the boolean value of finished
    }

     /**
     *  study checks if the student has a book, if not it borrows one using the borrowBook method from the Library class. If the student has a book it uses the readNextChapter method from the TextBook Class
     * if the book is finished it calls the closeBook method from the TextBook class
     */
    public void study()
    {
        if (stuBook == null) { //if tihe student doesnt have a book
             stuBook = stuLibrary.borrowBook(stuCard); //borrows a book using the borrowBook method from Library class using the library card assigned to the student
        }
        else if (stuBook.isFinished() == false) {
            stuBook.readNextChapter();
        }
        else{
            stuLibrary.returnBook(stuBook);
            stuBook.closeBook(); //closes book / changes chapts read to 0
            stuBook = null;
        }
    }
    
     /**
     * Describe tells the user the current state of the student object, letting the user know the students name, if they have a book and the status of their
     * library card
     */
    public void describe()
    {
        System.out.print("Student " + stuName); //prints out student name
        if (stuBook == null) { //if the student does not have a book
         System.out.print(" Does not have a book ");  
         System.out.print("and ");
         stuCard.describe(); //prints the lines above with the description of the librarycard, calls the describe method from the LibraryCard class
        }
        else if (stuBook != null) { //if student DOES have a book
        System.out.print(" has book ");
        stuBook.describe(); //calls the describe method from the TextBook class
        System.out.print(" and ");
        stuCard.describe(); //prints line informing user that the student has a book, and prints the line by finishing describing the library card
        }
}
}
