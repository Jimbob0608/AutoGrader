package sample;

/**
 * This is the Teacher class which extends the Person class and represents a teacher user.
 * It contains two constructors: one that takes an age, name, teacher ID, and a boolean value that indicates
 * whether the user is a teacher or not; and another one that takes an age, name, and a boolean value that
 * indicates whether the user is a teacher or not.
 */
public class Teacher extends Person {

    // The ID of the teacher.
    private long teacherID;

    // Whether the student can upload mark schemes or not
    protected boolean canUploadMarkScheme;

    /**
     * Constructor for creating a Teacher object with a specified age, name, teacher ID, and a boolean
     * value that indicates whether the user is a teacher or not.
     *
     * @param age       an integer value to represent the age of the teacher.
     * @param name      a string value to represent the name of the teacher.
     * @param teacherID a long value to represent the teacher ID of the teacher.
     * @param isTeacher a boolean value that indicates whether the user is a teacher or not.
     */
    public Teacher(int age, String name, long teacherID, boolean isTeacher) {
        super(age, name, isTeacher);
        this.teacherID = teacherID;
        this.canUploadMarkScheme = false;
    }

    /**
     * Constructor for creating a Teacher object with a specified age, name, and a boolean value that
     * indicates whether the user is a teacher or not.
     *
     * @param age       an integer value to represent the age of the teacher.
     * @param name      a string value to represent the name of the teacher.
     * @param isTeacher a boolean value that indicates whether the user is a teacher or not.
     */
    public Teacher(int age, String name, boolean isTeacher) {
        super(age, name, isTeacher);
    }
}