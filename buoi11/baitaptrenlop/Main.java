package buoi11.baitaptrenlop;

import buoi11.baitaptrenlop.entity.*;
import buoi11.baitaptrenlop.repository.Repository;
import buoi11.baitaptrenlop.service.StudentManageService;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManageService service = new StudentManageService(
                new Repository<>(),
                new Repository<>(),
                new HashMap<>()
        );

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Khởi tạo dữ liệu mẫu");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Thêm khóa học");
            System.out.println("4. Đăng ký khóa học cho sinh viên");
            System.out.println("5. Nhập điểm cho sinh viên");
            System.out.println("6. Xem bảng điểm của 1 sinh viên");
            System.out.println("7. Tìm kiếm sinh viên theo ID");
            System.out.println("8. Lọc & sắp xếp sinh viên theo GPA");
            System.out.println("9. Tính học phí sinh viên");
            System.out.println("10. Nhập điểm tự động (đa luồng)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {

                    // 1. Dữ liệu mẫu
                    case 1 -> {
                        service.initSampleData();
                        System.out.println("Khởi tạo dữ liệu mẫu thành công!");
                    }

                    // 2. Thêm sinh viên
                    case 2 -> {
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Loại (1-FullTime | 2-PartTime): ");
                        int type = Integer.parseInt(scanner.nextLine());

                        Student student = (type == 1)
                                ? new FullTimeStudent(id, name, email)
                                : new PartTimeStudent(id, name, email);

                        service.addStudent(student);
                        System.out.println("Thêm sinh viên thành công!");
                    }

                    // 3. Thêm môn học
                    case 3 -> {
                        System.out.print("Course ID: ");
                        String courseId = scanner.nextLine();
                        System.out.print("Tên môn: ");
                        String courseName = scanner.nextLine();
                        System.out.print("Số tín chỉ: ");
                        int credits = Integer.parseInt(scanner.nextLine());

                        service.addCourse(new Course(courseId, courseName, credits));
                        System.out.println("Thêm khóa học thành công!");
                    }

                    // 4. Đăng ký môn học theo ID sinh viên
                    case 4 -> {
                        System.out.print("Student ID: ");
                        String sid = scanner.nextLine();
                        System.out.print("Course ID: ");
                        String cid = scanner.nextLine();

                        service.enrollStudentToCourse(sid, cid);
                        System.out.println("Đăng ký khóa học thành công!");
                    }

                    // 5. Nhập điểm theo ID sinh viên và ID môn học
                    case 5 -> {
                        System.out.print("Student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Course ID: ");
                        String courseId = scanner.nextLine();
                        System.out.print("Score: ");
                        double score = Double.parseDouble(scanner.nextLine());

                        service.inputScore(studentId, courseId, score);
                        System.out.println("Nhập điểm thành công!");
                    }

                    // 6. Xem bảng điểm của sinh viên với số ID
                    case 6 -> {
                        System.out.print("Student ID: ");
                        String sid = scanner.nextLine();
                        service.printStudentScoreBoard(sid);
                    }

                    // 7. Tìm sinh viên bằng ID
                    case 7 -> {
                        System.out.print("Student ID: ");
                        String sid = scanner.nextLine();

                        service.searchStudent(sid)
                                .ifPresentOrElse(
                                        s -> System.out.println(s.getId() + " | " + s.getName() + " | GPA: " + s.getGpa()
                                        ),
                                        () -> System.out.println("Không tìm thấy sinh viên")
                                );
                    }

                    // 8. Lọc và sắp xếp sinh viên
                    case 8 -> {

                        System.out.print("Nhập tên sinh viên : ");
                        String name = scanner.nextLine();

                        System.out.print("GPA tối thiểu: ");
                        double minGpa = Double.parseDouble(scanner.nextLine());

                        System.out.print("Chọn kiểu sắp xếp (1-GPA giảm dần | 2-Tên tăng dần): ");
                        int sortType = Integer.parseInt(scanner.nextLine());

                        List<Student> sorted = (sortType == 1)
                                ? service.sortStudentsByGpaDesc()
                                : service.sortStudentsByNameAsc();

                        List<Student> filtered = service.searchStudent(name, minGpa);
                        List<Student> result = new ArrayList<>();

                        for (Student s : sorted) {
                            if (filtered.contains(s)) {
                                result.add(s);
                            }
                        }

                        if (result.isEmpty()) {
                            System.out.println("Không tìm thấy sinh viên phù hợp.");
                        } else {
                            System.out.println("Danh sách sinh viên :");
                            result.forEach(s ->
                                    System.out.println(
                                            s.getId() + " | " + s.getName() + " | GPA: " + s.getGpa()
                                    )
                            );
                        }
                    }

                    // 9. Tính học phí sinh viên
                    case 9 -> {
                        System.out.print("Student ID: ");
                        String sid = scanner.nextLine();

                        Student student = service.searchStudent(sid)
                                .orElseThrow(() ->
                                        new RuntimeException("Không tìm thấy sinh viên"));

                        double tuition = service.calculateTuition(student);
                        System.out.println("Học phí: " + tuition);
                    }

                    // 10. Multi-thread demo
                    case 10 -> {
                        System.out.println("Demo nhập điểm đa luồng (gọi safeInputScore)");
                        System.out.println("Hoàn tất demo đa luồng!");
                    }

                    case 0 -> System.out.println("Thoát chương trình!");

                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }

        } while (choice != 0);

        scanner.close();
    }
}
