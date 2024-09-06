import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*****************************************");
        System.out.println("Enter 1 to launch the menu or any other key to exit");
        String input = scanner.nextLine();

        if ("1".equals(input)) {
            while (true) {
                System.out.println("Please select one of the following menu items:");
                System.out.println("1. Capture New Student");
                System.out.println("2. Search Student");
                System.out.println("3. Delete Student");
                System.out.println("4. View Student Report");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        Student.saveStudent(scanner);
                        break;
                    case 2:
                        Student.searchStudent(scanner);
                        break;
                    case 3:
                        Student.deleteStudent(scanner);
                        break;
                    case 4:
                        Student.studentReport();
                        break;
                    case 5:
                        System.out.println("Exiting application...");
                        return;
                    default:
                        System.out.println("Invalid input. Please try again.");
                }
            }
        } else {
            System.out.println("Exiting application...");
        }
    }
}

