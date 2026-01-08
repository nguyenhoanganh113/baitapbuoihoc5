package buoi9.baitaptrenlop.bai1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

//Câu 2: Tạo lớp trừu tượng Employee triển khai IWorkable. Có thuộc tính id, name, baseSalary.
@FieldDefaults(level= AccessLevel.PROTECTED)
@AllArgsConstructor
public abstract class Employee implements IWorkable {

    int id;
    String name;
    double baseSalary;

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee{id=" + id +
                ", name='" + name + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
