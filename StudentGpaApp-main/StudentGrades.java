import java.util.Scanner;
import java.io.FileWriter;
import java.util.LinkedList;
import java.io.IOException;
import java.util.Collections;
import java.io.BufferedWriter;

public class StudentGrades {
    public static void main(String[] args) {
        LinkedList<Student> studentsList = new LinkedList<>();

        // Ask user for student data
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Student name or 'exit': ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("Address: ");
                String address = scanner.nextLine();

                double gpa = getValidGPA(scanner);

                // Add Student Object to the linked list
                studentsList.add(new Student(name, address, gpa));
            }
        }

        // Sort the student list by name
        Collections.sort(studentsList, (s1, s2) -> s1.getName().compareTo(s2.getName()));

        // Write student data to a text file
        writeToFile(studentsList, "students.txt");
    }

    // Validate Student GPA
    private static double getValidGPA(Scanner scanner) {
        while (true) {
            System.out.print("GPA: ");
            try {
                double gpa = Double.parseDouble(scanner.nextLine());
                if (gpa < 0 || gpa > 4.5) {
                    throw new IllegalArgumentException("Must be between 0 and 4.5");
                }
                return gpa;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid GPA input. Enter a number between 0 and 4.5.");
            }
        }
    }

    // Write to a text file
    private static void writeToFile(LinkedList<Student> studentsList, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : studentsList) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Student data written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

// Student class
class Student {
    private String name;
    private String address;
    private double gpa;

    // Constructor to initialize student object with name, address, and GPA
    public Student(String name, String address, double gpa) {
        this.name = name;
        this.address = address;
        this.gpa = gpa;
    }

    // Get student name
    public String getName() {
        return name;
    }

    // Override toString method to format student data as a string
    @Override
    public String toString() {
        return "Student: " + name + ", Address: " + address + ", Verified GPA: " + gpa;
    }
}