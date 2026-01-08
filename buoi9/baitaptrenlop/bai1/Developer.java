package buoi9.baitaptrenlop.bai1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

//Câu 3: Tạo lớp Developer (có mảng 1 chiều String[] skills) và lớp Tester (có int bugsFound). Cả hai kế thừa từ Employee.
//Câu 4: Ghi đè calculateSalary():
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Developer extends Employee {

    String[] skills;

    public Developer(int id, String name, double baseSalary,String[] skills) {
        super(id, name, baseSalary);
        this.skills = skills;
    }

    @Override
    public void doWork() {
        System.out.println(name + " đang lập trình...");
    }

    @Override
    public double calculateSalary() {
        return baseSalary * 1.5;
    }

    @Override
    public String toString() {
        return String.format(
                "Developer{id=%d, name='%s', baseSalary=%,.0f, skills=%s, salary=%,.0f}",
                id, name, baseSalary, Arrays.toString(skills), calculateSalary()
        );
    }
}
