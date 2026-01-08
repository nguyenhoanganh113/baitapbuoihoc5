package buoi11.baitaptrenlop.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PROTECTED)
public abstract class Person {

    String id;
    String name;
    String email;

    protected abstract String getRole();

}
