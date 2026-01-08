package buoi6.bai1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeSales extends Employee {
    private int salesAmount;

    public EmployeeSales(String employeeId, String fullName, String address, double phoneNumber, int salesAmount) {
        super(employeeId, fullName, address, phoneNumber);
        this.salesAmount = salesAmount;
    }

    @Override
    public int calculateSalary() {
        return salesAmount * 200000;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  - Role: Sale Employee");
        System.out.println("  - Working Days: " + salesAmount);
        System.out.println("  - Total Salary: " + String.format("%,d", calculateSalary()) + " VND");
    }
}
