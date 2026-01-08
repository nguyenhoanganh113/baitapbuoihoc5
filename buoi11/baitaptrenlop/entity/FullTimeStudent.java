package buoi11.baitaptrenlop.entity;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class FullTimeStudent extends Student {

    static final double PRICE_PER_CREDIT = 300.0;

    public FullTimeStudent(String id, String name, String email) {
        super(id, name, email);
    }


    @Override
    protected String getRole(){
        return "FULL_TIME_STUDENT";
    }

    //Tổng tín chỉ × PRICE_PER_CREDIT
    @Override
    public double calculateTuitionFee() {
        int tongTinChi = 0;

        for(Course course : enrolledCourses){
            tongTinChi += course.getCredits();
        }

        return  PRICE_PER_CREDIT * tongTinChi;
    }
}
