package buoi9.baitaptrenlop.bai1;

/*
Kiến thức: Encapsulation, Inheritance, Abstract, Interface, Mảng 1 chiều.
•	Câu 1: Tạo Interface IWorkable với phương thức void doWork().
•	Câu 2: Tạo lớp trừu tượng Employee triển khai IWorkable. Có thuộc tính id, name, baseSalary.
•	Câu 3: Tạo lớp Developer (có mảng 1 chiều String[] skills) và lớp Tester (có int bugsFound). Cả hai kế thừa từ Employee.
•	Câu 4: Ghi đè calculateSalary():
        Developer: baseSalary x 1.5.
        Tester: baseSalary + (bugsFound x 100,000).
 */
public class Main {
    public static void main(String[] args){
        Developer dev = new Developer(1, "Linh", 20_000_000, new String[]{"Java", "Spring", "SQL"});
        Tester tester = new Tester(2, "Minh", 15_000_000, 2);

        dev.doWork();
        System.out.println(dev);
        System.out.println();

        tester.doWork();
        System.out.println(tester);
        System.out.println();


    }
}
