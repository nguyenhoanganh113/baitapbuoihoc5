package buoi2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Employee {

    private String name;
    private double grossSalary;

    public void calculateNetSalary() {
        double taxRate = 0;

        if (this.grossSalary > 20000000) {
            taxRate = 0.20; // 20%
        } else if (this.grossSalary >= 10000000) {
            taxRate = 0.10; // 10%
        } else {
            taxRate = 0;    // 0%
        }

        double taxAmount = this.grossSalary * taxRate;

        double netSalary = this.grossSalary;
        netSalary -= taxAmount;

        System.out.println("Nhân viên: " + name);
        System.out.println("Lương Gross: " + String.format("%,.0f", grossSalary) + " VND");
        System.out.println("Thuế phải nộp(" + (taxRate * 100) + "%): " + String.format("%,.0f", taxAmount) + " VND");
        System.out.println("Lương Net nhận được (Sau khi trừ đi thuế): " + String.format("%,.0f", netSalary) + " VND");
        System.out.println("---------------------------------------");
    }
    public static void main(String[] args) {
        Employee emp1 = new Employee("Nguyen Van A", 25000000); // Thue 20%
        Employee emp2 = new Employee("Tran Thi B", 15000000);   // Thue 10%
        Employee emp3 = new Employee("Le Van C", 8000000);      // Thue 0%

        emp1.calculateNetSalary();
        emp2.calculateNetSalary();
        emp3.calculateNetSalary();
    }
}
