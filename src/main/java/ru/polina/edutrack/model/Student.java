package ru.polina.edutrack.model;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String className;

    public Student(int id, String firstName, String lastName, String className) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
