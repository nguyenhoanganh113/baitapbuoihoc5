package buoi11.baitaptrenlop.entity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartTimeStudent extends Student {

    static final double PRICE_PER_CREDIT = 500.0;

    public PartTimeStudent(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public double calculateTuitionFee() {
        int tongTinChi = 0;

        for(Course course : enrolledCourses){
            tongTinChi += course.getCredits();
        }

        return tongTinChi *  PRICE_PER_CREDIT;
    }

    @Override
    protected String getRole() {
        return "PART_TIME_STUDENT";
    }
}
