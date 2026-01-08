package buoi11.baitaptrenlop.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@FieldDefaults(level= AccessLevel.PROTECTED)
public abstract class Student extends Person {

    double gpa; //Điểm trung bình toàn khóa
    List<Course> enrolledCourses; //Danh sách môn đã đăng ký

    public Student(String id, String name, String email) {
        super(id, name, email);
        this.enrolledCourses = new ArrayList<>();
    }

    //Thêm khóa học nếu chưa tồn tại trong danh sách
    public void enrollCourse(Course course){
        if(enrolledCourses.contains(course)){
            return;
        }
        enrolledCourses.add(course);
    }

    //Hủy đăng ký học
    public void removeCourse(Course course){
        enrolledCourses.remove(course);
    }

    //Tính điểm trung bình dựa trên bảng điểm của sinh viên
    public double calculateAverageScore(Map<Course, Double> scores){
        double tongDiemCacMonHoc = 0;
        int tongTinChi = 0;
        for(Map.Entry<Course, Double> entry : scores.entrySet()){

            Course course = entry.getKey();
            double score = entry.getValue();

            //Điểm từng môn học nhân với tín chỉ của từng môn
            tongDiemCacMonHoc += score * course.getCredits();
            tongTinChi += course.getCredits();

        }

        if(tongTinChi == 0) return 0;

        return tongDiemCacMonHoc / tongTinChi;
    }


    //Tính học phí(đa hình giữa các loại sinh viên)
    public abstract double calculateTuitionFee();
}
