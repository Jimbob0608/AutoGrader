package sample;


public class Person {
    protected int age;
    protected String name;
    protected boolean isTeacher;

    /**
     * @param Age       an int to represent the age of the user.
     * @param Name      a string to represent the name of the user.
     * @param IsTeacher a boolean to distinguish teachers from students.
     */
    public Person(int Age, String Name, boolean IsTeacher) {
        age = Age;
        name = Name;
        isTeacher = IsTeacher;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int Age) {
        age = Age;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

}
