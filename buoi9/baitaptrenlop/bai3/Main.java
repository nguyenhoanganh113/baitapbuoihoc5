package buoi9.baitaptrenlop.bai3;

import buoi9.baitaptrenlop.bai1.Developer;
import buoi9.baitaptrenlop.bai1.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
•	Câu 8 (Tự tạo Functional Interface): Tạo một Interface @FunctionalInterface tên là SalaryBonus
        có một phương thức double calculate(Employee e).
•	Câu 9 (Sử dụng Lambda): Viết chương trình sử dụng Lambda để định nghĩa các loại thưởng khác nhau mà không cần tạo lớp mới:
	    Thưởng Tết: Trả về 10% của calculateSalary().
	    Thưởng dự án: Trả về một con số cố định (ví dụ: 5,000,000).
•	Câu 10 (Sử dụng Interface có sẵn): Sử dụng java.util.function.Predicate<Employee> và Lambda để viết hàm lọc nhân viên:
	    Lọc những nhân viên có lương > 20,000,000.
	    Lọc những Developer có kỹ năng là "Java".

 */
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Developer(1, "Linh", 30_000_000, new String[]{"C#", "Spring"}));
        employees.add(new Developer(2, "Minh", 5_000_000, new String[]{"Java", "SQL"}));
        employees.add(new Developer(3, "Hoàng", 22_000_000, new String[]{"Java"}));

        SalaryBonus tetBonus = e -> e.calculateSalary() * 0.10;     // 10%
        SalaryBonus projectBonus = e -> 5_000_000;                  // cố định

        System.out.println("=== THƯỞNG ===");
        for (Employee e : employees) {
            System.out.println(e);
            System.out.println("→ Thưởng Tết: " + tetBonus.calculate(e));
            System.out.println("→ Thưởng dự án: " + projectBonus.calculate(e));
            System.out.println("------------------------------------");
        }

        Predicate<Employee> salaryOver20m = e -> e.calculateSalary() > 20_000_000;
        Predicate<Employee> devHasJava = e ->{
            if(!(e instanceof Developer)){
                return false;
            }
            Developer dev = (Developer)e;
            for(String skill : dev.getSkills()){
                if(skill.equalsIgnoreCase("Java")){
                    return true;
                }
            }
            return false;
        };

        System.out.println("\n=== Lọc lương > 20 triệu ===");
        employees.stream().
                filter(salaryOver20m).
                forEach(System.out::println);

        System.out.println("\n=== Lọc Developer biết Java ===");
        employees.stream().
                filter(devHasJava).
                forEach(System.out::println);
    }
}
