package buoi9.baitaptrenlop.bai1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

//Câu 3: Tạo lớp Developer (có mảng 1 chiều String[] skills) và lớp Tester (có int bugsFound). Cả hai kế thừa từ Employee.
//Tester: baseSalary + (bugsFound x 100,000).
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter

public class Tester extends Employee {

    private int bugsFound;

    public Tester(int id, String name, double baseSalary, int bugsFound) {
        super(id, name, baseSalary);
        this.bugsFound = bugsFound;
    }

    @Override
    public void doWork() {
        System.out.println(name + " đang test phần mềm...");
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (bugsFound * 100_000);
    }

    @Override
    public String toString() {
        return String.format(
                "Tester{id=%d, name='%s', baseSalary=%,.0f, bugsFound=%d, salary=%,.0f}",
                id, name, baseSalary, bugsFound, calculateSalary()
        );
    }

}
