public class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String name, int age, double salary, double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
