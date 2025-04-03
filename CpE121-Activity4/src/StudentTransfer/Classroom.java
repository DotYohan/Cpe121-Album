/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentTransfer;

import java.util.ArrayList;

/**
 *
 * @author yuanb
 */
public class Classroom {
     private String className;
    private ArrayList<Student> students;  // List to store students

    // Constructor
    public Classroom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
    }

    // Add a student to the classroom
    public void addStudent(Student student) {
        students.add(student);
        System.out.println(student.getName() + " added to " + className);
    }

    // Remove a student from the classroom
    public boolean removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            System.out.println(student.getName() + " removed from " + className);
            return true;
        } else {
            System.out.println(student.getName() + " not found in " + className);
            return false;
        }
    }

    // Display all students in the classroom
    public void displayStudents() {
        System.out.println("\nClassroom: " + className);
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : students) {
                student.displayInfo();
            }
        }
    }

    // Transfer student to another classroom
    public void transferStudent(Student student, Classroom newClassroom) {
        if (removeStudent(student)) {  // Remove student from current class
            newClassroom.addStudent(student);  // Add student to new class
            System.out.println(student.getName() + " transferred from " + className + " to " + newClassroom.className);
        }
    }
}

