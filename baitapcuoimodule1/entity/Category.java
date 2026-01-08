package baitapcuoimodule1.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
    String name;
    Product[] products;
    int count; //Đếm sản phẩm hiện tại
    final int MAX_PRODUCTS = 20;

    public Category(String name){
        this.name = name;
        this.products = new Product[MAX_PRODUCTS];
        this.count = 0;
    }

    public String addProduct(Product p) {
        StringBuilder sb = new StringBuilder();

        // 1. Kiểm tra danh mục đầy
        if (count >= MAX_PRODUCTS) {
            sb.append("Danh mục ").append(this.name)
                    .append(" đã đầy, không thể thêm sản phẩm.");
            return sb.toString();
        }

        // 2. Kiểm tra trùng lặp bằng equals()
        for (int i = 0; i < count; i++) {
            if (products[i].equals(p)) {
                sb.append("Sản phẩm ").append(p.getName()) // Giả sử có getter name
                        .append(" đã tồn tại trong danh mục (Trùng ID và Tên).");
                return sb.toString();
            }
        }

        // 3. Nếu hợp lệ -> Thêm vào cuối
        products[count] = p;
        count++;

        // 4. Thông báo thành công
        sb.append("Đã thêm sản phẩm ").append(p.toString())
                .append(" vào danh mục ").append(this.name);

        return sb.toString();
    }

    //Xóa sản phẩm theo Id
    public boolean removeProductById(int id) {
        int indexFound = -1;

        // 1. Tìm vị trí (index) của sản phẩm trong mảng
        for (int i = 0; i < count; i++) {
            if (products[i].getId() == id) {
                indexFound = i;
                break;
            }
        }

        // Nếu không tìm thấy trong danh mục này -> trả về false
        if (indexFound == -1) {
            return false;
        }

        // 2. THỰC HIỆN DỊCH MẢNG (Shifting)
        // Dời tất cả phần tử phía sau vị trí tìm thấy lên trước 1 nấc
        // Ví dụ: [A, B(xóa), C, D] -> [A, C, D]
        for (int i = indexFound; i < count - 1; i++) {
            products[i] = products[i + 1];
        }

        // BƯỚC 3: Xử lý phần tử cuối và giảm count
        products[count - 1] = null; // Xóa phần thừa ở cuối (D thừa) -> [A, C, D, null]
        count--; // Giảm số lượng

        return true; // Báo đã xóa thành công
    }

    public void displayCategory() {
        System.out.println("--- DANH MỤC: " + name + " (" + count + "/20) ---");
        if (count == 0) {
            System.out.println("(Chưa có sản phẩm)");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(products[i].toString());
            }
        }
        System.out.println();
    }
}
