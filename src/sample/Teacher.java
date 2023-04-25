package sample;

public class Teacher extends Person {
    protected long teacherID;
    protected boolean canUploadMarkScheme;

    /**
     *
     * @param age an int to represent the age of the user.
     * @param name a string to represent the name of the user.
     * @param teacherID an int to represent the ID of the user.
     */
    public Teacher(int age, String name, long teacherID, boolean isTeacher) {
        super(age, name, isTeacher);
        this.teacherID = teacherID;
        this.canUploadMarkScheme = false;
    }

    /**
     *
     * @param age an int to represent the age of the user.
     * @param name a string to represent the name of the user.
     * @param isTeacher a boolean to distinguish teachers from students.
     */
    public Teacher(int age, String name, boolean isTeacher) {
        super(age, name, isTeacher);
    }
}
