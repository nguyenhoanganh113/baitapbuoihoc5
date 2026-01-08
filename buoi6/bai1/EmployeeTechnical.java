package buoi6.bai1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeTechnical extends Employee {
    private int completedProjects;

    public EmployeeTechnical(String employeeId, String fullName, String address, double phoneNumber, int completedProjects) {
        super(employeeId, fullName, address, phoneNumber);
        this.completedProjects = completedProjects;
    }


    @Override
    public int calculateSalary(){
        return completedProjects * 2000000;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  - Role: Office Employee");
        System.out.println("  - Working Days: " + completedProjects);
        System.out.println("  - Total Salary: " + String.format("%,d", calculateSalary()) + " VND");
    }


}
