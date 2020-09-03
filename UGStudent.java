// UGStudent.java
// Simple Inheritance class
// Updated March 2020

// Inherits from Student.java
// No known subclasses
// Note use of "super()"
// Question: what attributes are part of a UGStudent object?

public class UGStudent extends Student {

    public UGStudent() {};

    public UGStudent(String yr, double grades) {
        super(1234567, "CSci");
        year = yr;
        gpa = grades;
    }

    public String year;
    public double gpa;

    public static void main(String[] args){
        UGStudent student = new UGStudent("Junior", 3.74);
        System.out.println(student.gpa);
        System.out.println(student.year);
        System.out.println(student.id);
        System.out.println(student.major);
    }
}
