package buoi6.bai1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
Supper class (lớp cha):
Employee:
thuộc tính: employeeId, fullName, address, phoneNumber
phương thức: calculateSalary(), displayInfo()
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String employeeId;
    private String fullName;
    private String address;
    private double phoneNumber;

    public int calculateSalary() {
        return 0;
    }

    public void displayInfo(){
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Full Name: " + fullName);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + (int)phoneNumber);
    }
}
