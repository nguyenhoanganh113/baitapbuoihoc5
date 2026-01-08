package buoi6.bai1;

public class Main {
    public static void main(String[] args){
        Employee employeeTechnical = new EmployeeTechnical("NV01", "Nguyen Van A","Ha Noi", 123111, 24);
        employeeTechnical.displayInfo();

        System.out.println();

        Employee saleTechnical = new EmployeeSales("NV02", "Tran Van B","Lao Cai", 3213212, 12);
        saleTechnical.displayInfo();
    }
}
