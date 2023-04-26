package sample;


/**
 * This class represents a Person with an age, name, and teacher status.
 * It contains methods to get and set the age, name, and teacher status of the person.
 */
public class Person {

    // The age of the Person.
    protected int age;

    // The name of the Person.
    protected String name;

    // Whether the Person is a teacher or not.
    protected boolean isTeacher;

    /**
     * Constructor to create a new Person object.
     *
     * @param age       An int representing the age of the user.
     * @param name      A string representing the name of the user.
     * @param isTeacher A boolean representing whether the user is a teacher or not.
     */
    public Person(int age, String name, boolean isTeacher) {
        this.age = age;
        this.name = name;
        this.isTeacher = isTeacher;
    }

    /**
     * Returns the age of the user.
     *
     * @return An int representing the age of the user.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the user.
     *
     * @param age An int representing the age of the user.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the name of the user.
     *
     * @return A string representing the name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name A string representing the name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns whether the user is a teacher or not.
     *
     * @return A boolean representing whether the user is a teacher or not.
     */
    public boolean isTeacher() {
        return isTeacher;
    }

    /**
     * Sets whether the user is a teacher or not.
     *
     * @param isTeacher A boolean representing whether the user is a teacher or not.
     */
    public void setTeacher(boolean isTeacher) {
        this.isTeacher = isTeacher;
    }
}