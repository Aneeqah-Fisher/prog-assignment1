public class PartTimeEmployee extends Employee {
    private double hourlyRate;

    public PartTimeEmployee(String name, int age, double salary, double hourlyRate) {
        super(name, age, salary);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}