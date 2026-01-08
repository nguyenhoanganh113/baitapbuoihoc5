package baitapcuoimodule1.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Warehouse {
    Category[] categories;

    public Warehouse(){
        categories = new Category[5];
        categories[0] = new Category("0 - Điện tử");
        categories[1] = new Category("1 - Gia dụng");
        categories[2] = new Category("2 - Thực phẩm");
        categories[3] = new Category("3 - Thời trang");
        categories[4] = new Category("4 - Khác");
    }

    public void addProductToWarehouse(int categoryId, Product p) {
        if (categoryId < 0 || categoryId > 4) {
            System.out.println("Lỗi: Mã danh mục không hợp lệ (0-4).");
            return;
        }

        // Gọi hàm xử lý của Category và in ra kết quả
        String result = categories[categoryId].addProduct(p);
        System.out.println(result);
    }

    public Category getCategory(int index) {
        return categories[index];
    }

    public void searchProduct(String keyword) {
        System.out.println(">>> Đang tìm kiếm từ khóa: \"" + keyword + "\"");

        // 1. Chuẩn hóa từ khóa về chữ thường để so sánh
        String lowerKeyword = keyword.toLowerCase();
        boolean foundAny = false; // Cờ đánh dấu xem có tìm thấy sản phẩm nào bằng keyWord hay không?

        // 2. Duyệt qua từng danh mục
        for (Category cat : categories) {
            Product[] products = cat.getProducts();
            int count = cat.getCount();

            // 3. Duyệt qua từng sản phẩm trong danh mục đó
            for (int i = 0; i < count; i++) {
                Product p = products[i];

                // 4. Logic so sánh:
                // - Lấy tên sản phẩm, chuyển về chữ thường
                // - Kiểm tra xem nó có CHỨA (contains) từ khóa không
                if (p.getName().toLowerCase().contains(lowerKeyword)) {
                    System.out.println(p.toString() + " - [Nằm trong: " + cat.getName() + "]");
                    foundAny = true;
                }
            }
        }

        // 5. Nếu quét hết kho mà cờ vẫn false -> Không tìm thấy
        if (!foundAny) {
            System.out.println("Không tìm thấy sản phẩm phù hợp.");
        }
        System.out.println("------------------------------------------------");
    }

    //Xóa
    public void deleteProduct(int id) {
        System.out.println(">>> Yêu cầu xóa sản phẩm ID: " + id);
        boolean isDeleted = false;

        // Duyệt qua từng danh mục (0 -> 4)
        for (Category cat : categories) {
            if (cat.removeProductById(id)) {
                System.out.println(" Đã xóa thành công sản phẩm ID " + id + " khỏi danh mục '" + cat.getName() + "'");
                System.out.println("   (Số lượng còn lại trong danh mục: " + cat.getCount() + ")");
                isDeleted = true;
                break; // Xóa xong thì thoát vòng lặp ngay, không cần tìm danh mục khác
            }
        }

        if (!isDeleted) {
            System.out.println("Lỗi: Không tìm thấy sản phẩm có ID " + id + " để xóa.");
        }
        System.out.println("------------------------------------------------");
    }

    //Sort
    public void sortAllProductsByPrice() {
        System.out.println(">>> CHỨC NĂNG 4: SẮP XẾP TOÀN KHO (GIÁ GIẢM DẦN - THỦ CÔNG)");

        // BƯỚC 1: GOM DỮ LIỆU VÀO MẢNG TẠM
        // Kho có tối đa 5 danh mục * 20 sản phẩm = 100 chỗ
        Product[] allProducts = new Product[100];
        int totalCount = 0;

        // Duyệt từng danh mục để lấy sản phẩm bỏ vào mảng chung
        for (Category cat : categories) {
            Product[] catProducts = cat.getProducts();
            int catCount = cat.getCount();

            for (int i = 0; i < catCount; i++) {
                allProducts[totalCount] = catProducts[i];
                totalCount++; // Tăng biến đếm tổng số lượng
            }
        }

        if (totalCount == 0) {
            System.out.println("Kho hàng trống, không có gì để sắp xếp.");
            return;
        }

        // BƯỚC 2: THUẬT TOÁN BUBBLE SORT (Sắp xếp nổi bọt)
        // Logic: So sánh 2 phần tử kề nhau, nếu sai thứ tự thì đổi chỗ (Swap)
        for (int i = 0; i < totalCount - 1; i++) {
            for (int j = 0; j < totalCount - 1 - i; j++) {
                // Kiểm tra: Nếu giá thằng trước (j) NHỎ HƠN thằng sau (j+1)
                // => Sai thứ tự giảm dần => Cần đổi chỗ
                if (allProducts[j].getPrice() < allProducts[j + 1].getPrice()) {

                    // Thực hiện Swap (Đổi chỗ)
                    Product temp = allProducts[j];
                    allProducts[j] = allProducts[j + 1];
                    allProducts[j + 1] = temp;
                }
            }
        }

        // BƯỚC 3: IN KẾT QUẢ
        // Chỉ duyệt đến totalCount (số lượng thực tế)
        for (int i = 0; i < totalCount; i++) {
            System.out.println(allProducts[i].toString());
        }

        System.out.println("------------------------------------------------");
    }


    public void showAllInventory() {
        System.out.println("\n========= TỔNG KHO HÀNG =========");
        for (Category cat : categories) {
            cat.displayCategory();
        }
    }
}
