package buoi7.baitaptrenlop.ex1;

import java.util.*;

public class QuanLyNhanVien {
    private List<Employee> danhSachNV = new ArrayList<>();

    public void themNhanVien(Scanner scanner) {
        System.out.println("Chọn loại nhân viên: 1. Developer | 2. Tester");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Xử lý trôi lệnh

        System.out.print("Nhập Mã NV: ");
        String maNV = scanner.nextLine();
        System.out.print("Nhập Họ Tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập Lương Cơ Bản: ");
        double luongCB = scanner.nextDouble();

        if (choice == 1) {
            System.out.print("Nhập tiền Overtime: ");
            double ot = scanner.nextDouble();
            Employee dev = new Developer(maNV, hoTen, luongCB, ot);
            danhSachNV.add(dev);
        } else if (choice == 2) {
            System.out.print("Nhập số lỗi phát hiện: ");
            int loi = scanner.nextInt();
            Employee tester = new Tester(maNV, hoTen, luongCB, loi);
            danhSachNV.add(tester);
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
        System.out.println("Thêm thành công!");
    }

    public void hienThiDanhSach() {
        System.out.println("\n--- DANH SÁCH NHÂN VIÊN ---");
        if (danhSachNV.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (Employee e : danhSachNV) {
                System.out.println(e.toString());
            }
        }
    }

    public void tinhTongLuongCongTy() {
        long tongLuong = 0;
        for (Employee e : danhSachNV) {
            tongLuong += e.calculateSalary();
        }
        System.out.println("Tổng lương công ty phải trả: " + tongLuong + " VND");
    }

    public void timKiemTheoMa(String maCanTim) {
        System.out.println("\n--- KẾT QUẢ TÌM KIẾM (" + maCanTim + ") ---");
        boolean timThay = false;
        for (Employee e : danhSachNV) {
            if (e.getEmployeeId().equalsIgnoreCase(maCanTim)) {
                System.out.println(e.toString());
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy nhân viên có mã: " + maCanTim);
        }
    }

    public void locNhanVien(int loai, double mucLuongSan) {
        System.out.println("\n--- KẾT QUẢ LỌC ---");
        boolean coKetQua = false;

        for (Employee e : danhSachNV) {
            if (loai == 1 && e instanceof Developer) {
                if (e.calculateSalary() > mucLuongSan) {
                    System.out.println(e.toString());
                    coKetQua = true;
                }
            }
            else if (loai == 2 && e instanceof Tester) {
                if (e.calculateSalary() > mucLuongSan) {
                    System.out.println(e.toString());
                    coKetQua = true;
                }
            }
        }

        if (!coKetQua) {
            System.out.println("Không có nhân viên nào thỏa mãn điều kiện.");
        }
    }
}
