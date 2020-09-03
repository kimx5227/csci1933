// GradStudent.java
// Simple Inheritance class
// Updated March 2020

// No known subclasses
// Question:  what attributes are part of a GradStudent object?

public class GradStudent extends Student {

    public GradStudent() {};

    public GradStudent(String degree, boolean plan) {
        degreeSought = degree;
        GradPlanFiled = plan;
        major = "CSci";
        first = "first-name-here";
        last = "last-name-here";
    }

    public String degreeSought;
    public boolean GradPlanFiled;

    public static void main(String[] args){
        GradStudent student = new GradStudent("CSCI", true);
        System.out.println(student.degreeSought);
        System.out.println(student.GradPlanFiled);
        System.out.println(student.first);
        System.out.println(student.last);
        System.out.println(student.major);
    }
}
