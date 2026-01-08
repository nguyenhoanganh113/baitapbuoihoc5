package buoi5.baitaptrenlop.bai2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Product{
    String id;
    String name;
    double price;
    int quantity;
}
