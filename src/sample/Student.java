package sample;

public class Student extends Person {
    protected long teacherID;
    protected boolean canUploadMarkScheme;

    public Student(int age, String name, long teacherID, boolean canUploadMarkScheme, boolean canUploadSubmission) {
        super(age, name);
        this.teacherID = teacherID;
        this.canUploadMarkScheme = canUploadMarkScheme;
        this.canUploadSubmission = canUploadSubmission;
    }

    protected boolean canUploadSubmission;

    public Student(int age, String name) {
        super(age, name);
    }
}
