package buoi7.baitaptrenlop.ex1;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Developer developer = new Developer("NV01", "Nguyen Van A", 5000000, 50000);
        System.out.println(developer.toString());
        System.out.println("--------------------------");
        Tester tester = new Tester("NV02", "Tran Van B", 4000000, 5);
        System.out.println(tester.toString());

        Scanner scanner = new Scanner(System.in);
        QuanLyNhanVien ql = new QuanLyNhanVien();

        while (true) {
            System.out.println("\n========= MENU QUẢN LÝ NHÂN SỰ =========");
            System.out.println("1. Thêm nhân viên mới (Nhập danh sách)");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Tính tổng lương công ty");
            System.out.println("4. Tìm kiếm theo Mã NV");
            System.out.println("5. Lọc nhân viên theo Lương và Loại");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Xử lý trôi lệnh

            switch (choice) {
                case 1:
                    ql.themNhanVien(scanner);
                    break;
                case 2:
                    ql.hienThiDanhSach();
                    break;
                case 3:
                    ql.tinhTongLuongCongTy();
                    break;
                case 4:
                    System.out.print("Nhập mã nhân viên cần tìm: ");
                    String maTK = scanner.nextLine();
                    ql.timKiemTheoMa(maTK);
                    break;
                case 5:
                    System.out.println("Chọn loại muốn lọc: 1. Developer | 2. Tester");
                    int loaiLoc = scanner.nextInt();
                    System.out.print("Nhập mức lương sàn (lương > mức này): ");
                    double luongSan = scanner.nextDouble();
                    ql.locNhanVien(loaiLoc, luongSan);
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Chức năng không tồn tại!");
            }
        }
    }
}
