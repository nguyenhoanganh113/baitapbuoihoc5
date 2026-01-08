package baitapcuoimodule1.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    //Field
    int id;
    String name;
    double price;
    int quantity;

    @Override
    public boolean equals(Object obj) {
        //so sánh địa chỉ ô nhớ
        if (this == obj) return true;
        //Kiểm tra là null hoặc khác class
        if (obj == null || getClass() != obj.getClass()) return false;
        //ép kiểu đối tượng trong param thành product để so sánh dữ liệu bên trong
        Product product = (Product) obj;
        //cùng 1 Id
        boolean isIdMatch = (this.id == product.id);
        //So sánh Name (bỏ qua hoa thường)
        boolean isNameMatch = (this.name != null) && this.name.equalsIgnoreCase(product.name);
        return isIdMatch && isNameMatch;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(this.id).append(" | Name: ").append(this.name).append(" | Price: ").append(this.price).
        append(" | Quantity: ").append(this.quantity);
        return sb.toString();
    }

    public static String formatName(String name){
        if(name == null || name.trim().isEmpty()) return "";
        String[] words = name.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            //viết hoa ký tự đầu tiên
            String firstChar = word.substring(0, 1).toUpperCase();
            //các ký tự còn lại viết thường hết
            String restChar = word.substring(1).toLowerCase();
            result.append(firstChar).append(restChar).append(" ");
        }
        return result.toString().trim();
    }
}
