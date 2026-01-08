package buoi9.baitaptrenlop.bai2;

import buoi9.baitaptrenlop.bai1.*;

import java.util.Scanner;

/*
•	Câu 5: Khai báo Employee[][] company để quản lý $N$ phòng ban.
•	Câu 6: Tạo ngoại lệ InvalidDataException. Viết phương thức nhập lương, nếu lương <= 0 thì throw ngoại lệ này.
•	Câu 7: Sử dụng try-catch-finally để đảm bảo khi nhập liệu sai, chương trình không bị "văng"
    mà yêu cầu nhập lại, đồng thời khối finally sẽ in ra trạng thái bộ nhớ sau mỗi phòng ban.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[][] company;

        System.out.print("Nhập số phòng ban: ");
        int N = scanner.nextInt();
        company = new Employee[N][];

        for (int i = 0; i < N; i++) {
            System.out.println("=== Phòng ban " + (i + 1) + " ===");
            System.out.print("Số nhân viên: ");
            int M = scanner.nextInt();
            company[i] = new Employee[M];

            for (int j = 0; j < M; j++) {
                System.out.println("Nhân viên " + (j + 1));

                scanner.nextLine();
                System.out.print("Tên: ");
                String name = scanner.nextLine();

                double salary = 0;
                while (true) {
                    try {
                        salary = InputSalary.inputSalary(scanner);
                        break;
                    } catch (InvalidDataException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    } finally {
                        System.out.println("=> Bộ nhớ tạm sau nhập lương:");
                        System.out.println("Tên hiện tại: " + name);
                    }
                }

                company[i][j] = new Developer(j + 1, name, salary, new String[]{"Java"});
            }
        }

        System.out.println("\n=== DANH SÁCH NHÂN VIÊN ===");
        for (Employee[] dept : company) {
            for (Employee emp : dept) {
                System.out.println(emp);
            }
        }
    }

}
