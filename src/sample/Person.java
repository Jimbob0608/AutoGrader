package sample;


public class Person {
    protected int Age;
    protected String Name;
    protected boolean isTeacher;

    /**
     *
     * @param age an int to represent the age of the user.
     * @param name a string to represent the name of the user.
     * @param isTeacher a boolean to distinguish teachers from students.
     */
    public Person(int age, String name, boolean isTeacher) {
        Age = age;
        Name = name;
        isTeacher = isTeacher;
    }
}
