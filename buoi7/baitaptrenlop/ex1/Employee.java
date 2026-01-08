package buoi7.baitaptrenlop.ex1;

import lombok.*;
import lombok.experimental.FieldDefaults;

/*
Tạo lớp cha NhanVien và các lớp con để tối ưu mã nguồn.
•	Lớp NhanVien: Các thuộc tính chung: maNV (String), hoTen (String), luongCoBan (double).
•	Lớp Developer: Kế thừa từ NhanVien, thêm thuộc tính: tienOvertime (double).
•	Lớp Tester: Kế thừa từ NhanVien, thêm thuộc tính: soLoiPhatHien (int).
Yêu cầu: Viết Constructor, Getter/Setter cho các lớp.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class Employee {
    String employeeId;
    String employeeName;
    double employeeSalary;

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "MaNV: " + employeeId +
                ", HoTen: " + employeeName +
                ", LuongCoBan: " + employeeSalary;
    }
}
