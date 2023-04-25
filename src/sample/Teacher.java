package sample;

public class Teacher extends Person {
    protected long teacherID;
    protected boolean canUploadMarkScheme;

    public Teacher(int age, String name, long teacherID, boolean canUploadMarkScheme) {
        super(age, name);
        this.teacherID = teacherID;
        this.canUploadMarkScheme = canUploadMarkScheme;
    }

    public Teacher(int age, String name) {
        super(age, name);
    }
}
