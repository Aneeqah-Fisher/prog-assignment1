import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    static ArrayList<Student> students = new ArrayList<>();
    String id;
    String name;
    private int age;
    private String email;
    private String course;

    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public static void saveStudent(Scanner scanner) {
        System.out.println("***************************");
        System.out.println("Capture New Student");
        System.out.println("***************************");

        System.out.print("Enter the student id: ");
        String id = scanner.nextLine();
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Enter the student age: ");
            age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (age >= 16) {
                break;
            } else {
                System.out.println("Invalid age! Please re-enter the student age (must be 16 or older).");
            }
        }
        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, age, email, course));
        System.out.println("Student details have been successfully saved.");
    }

    public static void searchStudent(Scanner scanner) {
        System.out.println("***************************");
        System.out.println("Search Student");
        System.out.println("***************************");

        System.out.print("Enter student id to search: ");
        String id = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if (student.id.equals(id)) {
                System.out.println("-------------------------------------");
                System.out.println("Student ID: " + student.id);
                System.out.println("Student Name: " + student.name);
                System.out.println("Student Age: " + student.age);
                System.out.println("Student Email: " + student.email);
                System.out.println("Student Course: " + student.course);
                System.out.println("-------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID: " + id + " not found.");
        }
    }

    public static void deleteStudent(Scanner scanner) {
        System.out.println("***************************");
        System.out.println("Delete Student");
        System.out.println("***************************");

        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();
        Student studentToRemove = null;

        for (Student student : students) {
            if (student.id.equals(id)) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            System.out.print("Are you sure you want to delete this student? (yes/no): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes")) {
                students.remove(studentToRemove);
                System.out.println("Student with ID: " + id + " was deleted.");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Student with ID: " + id + " not found.");
        }
    }

    public static void studentReport() {
        System.out.println("***************************");
        System.out.println("View Student Report");
        System.out.println("***************************");

        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println("-------------------------------");
                System.out.println(student);
            }
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nAge: " + age + "\nEmail: " + email + "\nCourse: " + course;
    }
}

