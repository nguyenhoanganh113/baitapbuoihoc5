package buoi5.baitapvenha.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public String showInfo(){
        return String.format("[ID: %s | Tên: %s | Giá: %.0f | SL: %d | Tổng: %.0f]"
                            , id, name, price, quantity, price * quantity );
    }
}
