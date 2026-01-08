package buoi11.baitaptrenlop.entity;

@FunctionalInterface
public interface StudentFilter {
    boolean filter(Student student);
}
