package buoi9.baitaptrenlop.bai3;

import buoi9.baitaptrenlop.bai1.Employee;

/*
Câu 8 : Tạo một Interface @FunctionalInterface tên là SalaryBonus có một phương thức double calculate(Employee e).
*/
@FunctionalInterface
public interface SalaryBonus {
    double calculate(Employee e);
}
