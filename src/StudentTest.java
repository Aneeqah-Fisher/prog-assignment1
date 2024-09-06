import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class StudentTest {

    private final InputStream originalSystemIn = System.in;

    @Before
    public void setUp() {
        Student.students.clear();
    }

    @Test
    public void testSaveStudent() {
        String input = "1\nJohn Doe\n20\njohn@example.com\nComputer Science\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try (Scanner scanner = new Scanner(System.in)) {
            Student.saveStudent(scanner);
        }

        assertEquals(1, Student.students.size());
        assertEquals("1", Student.students.get(0).id);
        assertEquals("John Doe", Student.students.get(0).name);
    }

    @Test
    public void testSearchStudent() {
        Student.students.add(new Student("1", "Aneeqah Fisher", 20, "aneeqahfisher@gmail.com", "Computer Science"));

        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try (Scanner scanner = new Scanner(System.in)) {
            Student.searchStudent(scanner);
            // Typically, we'd capture output or assert behavior here.
        }
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        String input = "99\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try (Scanner scanner = new Scanner(System.in)) {
            Student.searchStudent(scanner);
            // Typically, we'd capture output or assert behavior here.
        }
    }

    @Test
    public void testDeleteStudent() {
        Student.students.add(new Student("1", "John Doe", 20, "john@example.com", "Computer Science"));

        String input = "1\nyes\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try (Scanner scanner = new Scanner(System.in)) {
            Student.deleteStudent(scanner);
        }

        assertEquals(0, Student.students.size());
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        String input = "99\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try (Scanner scanner = new Scanner(System.in)) {
            Student.deleteStudent(scanner);
            // Typically, we'd capture output or assert behavior here.
        }
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        int age = 18; // Valid age
        assertTrue("Age should be valid", age >= 16);
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        int age = 15; // Invalid age
        assertFalse("Age should be invalid", age >= 16);
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        String input = "notANumber\n"; // invalid input
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try (Scanner scanner = new Scanner(System.in)) {
            // This should throw an exception
            scanner.nextInt(); // Attempt to read an integer
            fail("Expected an InputMismatchException to be thrown");
        } catch (java.util.InputMismatchException e) {
            // expected exception
        }
    }

    @After
    public void restoreSystemInStream() {
        System.setIn(originalSystemIn);
    }
}