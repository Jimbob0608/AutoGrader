package sample;

/**
 * This is the Student class which extends the Person class.
 * It contains two constructors: one that takes in an age, name, student ID, and whether the user is a teacher or not,
 * and another that takes in an age, name, and whether the user is a teacher or not.
 * It also has a boolean variable to indicate if the student can upload submissions or not.
 */
public class Student extends Person {

    // The ID of the student
    private long studentID;

    // Whether the student can upload submissions or not
    protected boolean canUploadSubmission;

    // Whether the student can upload mark schemes or not
    protected boolean canUploadMarkScheme;

    /**
     * Constructor that takes in an age, name, student ID, and whether the user is a teacher or not.
     * It sets the age, name, isTeacher, studentID, and the boolean variables for uploading submissions and mark schemes.
     *
     * @param age       an int to represent the age of the user.
     * @param name      a string to represent the name of the user.
     * @param isTeacher a boolean to distinguish teachers from students.
     * @param studentID an int to represent the ID of the user.
     */
    public Student(int age, String name, boolean isTeacher, long studentID) {
        super(age, name, isTeacher);
        this.studentID = studentID;
        this.canUploadMarkScheme = false;
        this.canUploadSubmission = true;
    }

    /**
     * Constructor that takes in an age, name, and whether the user is a teacher or not.
     *
     * @param age       an int to represent the age of the user.
     * @param name      a string to represent the name of the user.
     * @param isTeacher a boolean to distinguish teachers from students.
     */
    public Student(int age, String name, boolean isTeacher) {
        super(age, name, isTeacher);
    }
}