/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentTransfer;

/**
 *
 * @author yuanb
 */
public class main {

    public static void main(String[] args) {
        Classroom classA = new Classroom("Class A");
        Classroom classB = new Classroom("Class B");

        Student student1 = new Student("Alice", 101);
        Student student2 = new Student("Bob", 102);
        Student student3 = new Student("Charlie", 103);

        classA.addStudent(student1);
        classA.addStudent(student2);
        classA.addStudent(student3);

        System.out.println("\nBefore Transfer:");
        classA.displayStudents();
        classB.displayStudents();

        classA.transferStudent(student2, classB);

        System.out.println("\nAfter Transfer:");
        classA.displayStudents();
        classB.displayStudents();
    }
}
