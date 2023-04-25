package sample;

public class Student extends Person {
    protected long studentID;
    protected boolean canUploadMarkScheme;

    /**
     *
     * @param age an int to represent the age of the user.
     * @param name a string to represent the name of the user.
     * @param studentID an int to represent the ID of the user.
     */
    public Student(int age, String name, boolean isTeacher, long studentID) {
        super(age, name, isTeacher);
        this.studentID = studentID;
        this.canUploadMarkScheme = false;
        this.canUploadSubmission = true;
    }

    protected boolean canUploadSubmission;

    /**
     *
     * @param age an int to represent the age of the user.
     * @param name a string to represent the name of the user.
     * @param isTeacher a boolean to distinguish teachers from students.
     */
    public Student(int age, String name, boolean isTeacher) {
        super(age, name, isTeacher);
    }
}
