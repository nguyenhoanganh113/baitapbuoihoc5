package buoi7.baitaptrenlop.ex1;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tester extends Employee
{
    int errorFounded;

    public Tester(String employeeId, String employeeName, double employeeSalary,int errorFounded)
    {
        super(employeeId, employeeName, employeeSalary);
        this.errorFounded = errorFounded;
    }

    @Override
    public double calculateSalary() {
        return (employeeSalary + (errorFounded * 50000));
    }
    @Override
    public String toString() {
        return "Tester | " + super.toString() +
                ", SoLoiPhatHien: " + errorFounded +
                ", TongLuong: " + calculateSalary();
    }
}
