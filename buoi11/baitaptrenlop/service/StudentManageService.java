package buoi11.baitaptrenlop.service;

import buoi11.baitaptrenlop.entity.FullTimeStudent;
import buoi11.baitaptrenlop.entity.PartTimeStudent;
import buoi11.baitaptrenlop.entity.Course;
import buoi11.baitaptrenlop.entity.Student;
import buoi11.baitaptrenlop.entity.StudentFilter;
import buoi11.baitaptrenlop.exception.*;
import buoi11.baitaptrenlop.repository.Repository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.*;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentManageService {

    Repository<Student> studentRepository;
    Repository<Course> courseRepository;
    Map<String, Map<String, Double>> scoreBoard;

    //Khởi tạo dữ liệu mẫu
    public void initSampleData() {

        // Tạo 5 khóa học
        Course c1 = new Course("C01", "OOP", 3);
        Course c2 = new Course("C02", "DSA", 4);
        Course c3 = new Course("C03", "Database", 3);
        Course c4 = new Course("C04", "Java", 3);
        Course c5 = new Course("C05", "Web", 2);

        addCourse(c1);
        addCourse(c2);
        addCourse(c3);
        addCourse(c4);
        addCourse(c5);

        List<Course> allCourses = courseRepository.findAll();

        // Tạo 10 sinh viên
        Student s1 = new FullTimeStudent("FT01", "An", "an@gmail.com");
        Student s2 = new FullTimeStudent("FT02", "Binh", "binh@gmail.com");
        Student s3 = new FullTimeStudent("FT03", "Cuong", "cuong@gmail.com");
        Student s4 = new FullTimeStudent("FT04", "Dung", "dung@gmail.com");
        Student s5 = new FullTimeStudent("FT05", "Huy", "huy@gmail.com");

        Student s6 = new PartTimeStudent("PT01", "Lan", "lan@gmail.com");
        Student s7 = new PartTimeStudent("PT02", "Mai", "mai@gmail.com");
        Student s8 = new PartTimeStudent("PT03", "Nam", "nam@gmail.com");
        Student s9 = new PartTimeStudent("PT04", "Nga", "nga@gmail.com");
        Student s10 = new PartTimeStudent("PT05", "Phuc", "phuc@gmail.com");

        addStudent(s1);
        addStudent(s2);
        addStudent(s3);
        addStudent(s4);
        addStudent(s5);
        addStudent(s6);
        addStudent(s7);
        addStudent(s8);
        addStudent(s9);
        addStudent(s10);

        List<Student> students = studentRepository.findAll();

        // Mỗi sinh viên đăng ký ngẫu nhiên 2–3 môn
        Random random = new Random();

        for (Student student : students) {
            Collections.shuffle(allCourses);

            int soMon = 2 + random.nextInt(2);

            for (int i = 0; i < soMon; i++) {
                student.enrollCourse(allCourses.get(i));
            }
        }
    }



    //Thêm học sinh
    public void addStudent(Student student) {
        if (studentRepository.exists(student.getId())) {
            throw new DuplicateStudentException(
                    "Sinh viên với số ID sau đã tồn tại: " + student.getId()
            );
        }
        studentRepository.add(student.getId(), student);
    }

    //Thêm môn học
    public void addCourse(Course course) {
        if (courseRepository.exists(course.getCourseId())) {
            throw new DuplicateCourseException(
                    "Môn học với số ID như sau đã tồn tại: " + course.getCourseId()
            );
        }
        courseRepository.add(course.getCourseId(), course);
    }

    //Thêm học sinh vào môn học
    public void enrollStudentToCourse(String studentId, String courseId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Sinh viên với số ID như sau không tìm thấy: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new CourseNotFoundException(
                                "Môn học với số ID như sau không tìm thấy: " + courseId));

        //Thêm môn học với courseId vào Student với studentId
        student.enrollCourse(course);
    }

    //Nhập điểm với studentId và courseId
    public synchronized void inputScore(String studentId, String courseId, double score) {

        //Kiểm tra input score
        if (score < 0 || score > 10) {
            throw new InvalidScoreException(
                    "Điểm không hợp lệ (phải nằm trong khoảng 0–10): " + score
            );
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException("Không tìm thấy sinh viên: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new CourseNotFoundException("Không tìm thấy môn học: " + courseId));

        if (!student.getEnrolledCourses().contains(course)) {
            throw new InvalidScoreException("Sinh viên chưa đăng ký môn học này");
        }

        if (!scoreBoard.containsKey(studentId)) {
        //Nếu mà chưa có Student với studentId truyền vào thì tạo bảng điểm mới
        scoreBoard.put(studentId, new HashMap<>());
        }
        //Nếu mà studentId có rồi thì lấy ra value của Map Table gồm 2 cột(1 cột là StudentId,
        // 1 cột là HashMap là bảng điểm mà cột này chứa đựng 1 HashMap Table có 2 cột là courseId và score
        // method get(studentId) chính là lấy ra HashMap Table (column VALUE của HashMap Table lớn)
        scoreBoard.get(studentId).put(courseId, score);
    }

    //In ra bảng đểm của Student với id
    public void printStudentScoreBoard(String studentId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Không tìm thấy sinh viên: " + studentId));

        //Lấy bảng điểm của sinh viên với id đã nhập
        Map<String, Double> scores = scoreBoard.get(studentId);

        if (scores == null || scores.isEmpty()) {
            System.out.println("Sinh viên chưa có điểm môn nào.");
            return;
        }

        System.out.println("BẢNG ĐIỂM CỦA SINH VIÊN: " + student.getName());
        System.out.println("----------------------------------");

        Map<Course, Double> scoreForGPA = new HashMap<>();

        for (Map.Entry<String, Double> entry : scores.entrySet()) {

            String courseId = entry.getKey();
            double score = entry.getValue();
            Course course = courseRepository.findById(courseId).get();

            System.out.println(
                    course.getCourseName() +
                            " (" + course.getCredits() + " tín chỉ): " +
                            score
            );

            scoreForGPA.put(course, score);
        }

        // 4. Tính & in điểm trung bình
        double gpa = student.calculateAverageScore(scoreForGPA);
        System.out.println("----------------------------------");
        System.out.println("Điểm trung bình (GPA): " + String.format("%.2f", gpa));
    }

    //Lấy bảng điểm theo id sinh viên
    public Optional<Student> searchStudent(String id) {
        return studentRepository.findById(id);
    }

    //Lấy bảng điểm theo tên và gpa tối thiểu
    public List<Student> searchStudent(String name, double minGpa) {
        List<Student> result = new ArrayList<>();
        for (Student s : studentRepository.findAll()) { //lấy bảng điểm
            if (s.getName().toLowerCase().contains(name.toLowerCase())
                    && s.getGpa() >= minGpa) {
                result.add(s);
            }
        }
        return result;
    }

    //Tính học phí
    public double calculateTuition(Student student){
        return student.calculateTuitionFee();
    }

    public List<Student> filterStudents(String name) {
        return studentRepository.findAll().stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public List<Student> filterStudents(StudentFilter filter){
        List<Student> result = new ArrayList<>();

        for(Student student : studentRepository.findAll()){
            if(filter.filter(student)){
                result.add(student);
            }
        }
        return result;
    }

    //Sắp xếp học sinh theo gpa giảm dần
    public List<Student> sortStudentsByGpaDesc(){
        return studentRepository.findAll().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .toList();
    }

    //Sắp xếp học sinh theo tên
    public List<Student> sortStudentsByNameAsc(){
        return studentRepository.findAll().stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
    }

}
