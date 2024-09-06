import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testCalculateTotalSalary() {
        Employee[] employees = {
                new FullTimeEmployee("John", 30, 50000.0, 1000.0),
                new PartTimeEmployee("Jane", 25, 20000.0, 20.0),
                new FullTimeEmployee("Bob", 40, 60000.0, 2000.0)
        };

        double totalSalary = Main.calculateTotalSalary(employees);
        assertEquals(130000.0, totalSalary, 0.001);
    }

    @Test
    public void testFindHighestPaidEmployee() {
        Employee[] employees = {
                new FullTimeEmployee("John", 30, 50000.0, 1000.0),
                new PartTimeEmployee("Jane", 25, 20000.0, 20.0),
                new FullTimeEmployee("Bob", 40, 60000.0, 2000.0)
        };

        Employee highestPaid = Main.findHighestPaidEmployee(employees);
        assertEquals("Bob", highestPaid.getName());
    }
}