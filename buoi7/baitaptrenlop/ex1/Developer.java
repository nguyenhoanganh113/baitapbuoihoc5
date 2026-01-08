package buoi7.baitaptrenlop.ex1;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class Developer extends Employee {

    double overtimeSalary;

    public Developer(String employeeId, String employeeName, double employeeSalary, double overtimeSalary)
    {
        super(employeeId, employeeName, employeeSalary);
        this.overtimeSalary = overtimeSalary;
    }

    @Override
    public double calculateSalary() {
        return (employeeSalary + overtimeSalary);
    }

    @Override
    public String toString() {
        return "Developer | " + super.toString() +
                ", TienOvertime: " + overtimeSalary +
                ", TongLuong: " + calculateSalary();
    }
}
