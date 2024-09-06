public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee("Cole", 24, 50000.0, 1000.0);
        employees[1] = new PartTimeEmployee("Zaheer", 23, 20000.0, 20.0);
        employees[2] = new FullTimeEmployee("Suhail", 25, 60000.0, 2000.0);

        double totalSalary = calculateTotalSalary(employees);

        System.out.println("Employee Report:");
        System.out.println("------------------");

        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - Age: " + employee.getAge() + " - Salary: R" + employee.getSalary());
        }

        System.out.printf("Total Salary: R%.2f%n", totalSalary);
        System.out.printf("Average Salary: R%.2f%n", (totalSalary / employees.length));

        Employee highestPaidEmployee = findHighestPaidEmployee(employees);
        System.out.println("Employee with highest salary: " + highestPaidEmployee.getName());
    }

    public static double calculateTotalSalary(Employee[] employees) {
        double totalSalary = 0.0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public static Employee findHighestPaidEmployee(Employee[] employees) {
        Employee highestPaidEmployee = employees[0];

        for (Employee employee : employees) {
            if (employee.getSalary() > highestPaidEmployee.getSalary()) {
                highestPaidEmployee = employee;
            }
        }

        return highestPaidEmployee;
    }
}