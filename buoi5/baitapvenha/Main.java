package buoi5.baitapvenha;

import buoi5.baitapvenha.entity.Product;

import java.util.Scanner;

import static buoi5.baitaptrenlop.bai1.Bai1.formatName;

public class Main {
    static Product[] storage = new Product[100];
    static int count = 0; //Số lượng sản phẩm thực tế
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println("\n====== MENU QUẢN LÝ SẢN PHẨM ======");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị và Thống kê");
            System.out.println("3. Tìm sản phẩm rẻ nhất");
            System.out.println("4. Sửa thông tin sản phẩm");
            System.out.println("5. Xóa sản phẩm");
            System.out.println("6. Sắp xếp theo giá giảm dần");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showAndStats();
                    break;
                case 3:
                    if(count > 0) findCheapestProduct(storage, count);
                    else System.out.println("Danh sách trống!");
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    sortProductDescByPrice();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập lại!");
            }
        }
    }

    public static void addProduct(){
        if(count >= 100){
            System.out.println("Error: Kho chứa đã đầy!");
            return;
        }

        System.out.print("Nhập ID: ");
        String id = sc.nextLine().trim();

        //Kiểm tra trùng ID
        for(int i = 0; i < count; i++){
            if(storage[i].getId().equalsIgnoreCase(id)){
                System.out.println("Lỗi: ID này đã tồn tại");
                return;
            }
        }

        System.out.print("Nhập tên: ");
        String nameProduct = sc.nextLine();
        String nameProductAfterFormatName= formatName(nameProduct);

        System.out.print("Nhập giá: ");
        double priceProduct = Double.parseDouble(sc.nextLine()); //convert từ String sang double

        System.out.print("Nhập số lượng: ");
        int quantityProduct = Integer.parseInt(sc.nextLine()); //convert từ String sang int

        storage[count] = new Product(id,nameProductAfterFormatName,priceProduct,quantityProduct);
        count++;
        System.out.println("Sản phẩm với ID { "+ id +" } đã được thêm thành công!");
    }

    public static void showAndStats(){
        if(count == 0){
            System.out.println("Danh sách sản phẩm trong kho đang trống!");
            return;
        }
        System.out.println("-----Danh sách sản phẩm-----");
        for(int i = 0; i < count; i++){
            System.out.println(storage[i].showInfo());
        }
        calculateTotalValue();
    }

    public static void calculateTotalValue() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += storage[i].getPrice() * storage[i].getQuantity();
        }
        System.out.println("TỔNG GIÁ TRỊ KHO HÀNG: " + total + " VNĐ");
    }

    public static void findCheapestProduct(Product[] list, int n) {
        Product minProduct = list[0];
        for (int i = 1; i < n; i++) {
            if (list[i].getPrice() < minProduct.getPrice()) {
                minProduct = list[i];
            }
        }
        System.out.println("Sản phẩm rẻ nhất là:");
        System.out.println(minProduct.showInfo());
    }

    public static void updateProduct() {

        System.out.print("Nhập ID hoặc Tên sản phẩm cần sửa: ");
        String keyword = sc.nextLine().toLowerCase();
        int foundIndex = -1;

        for (int i = 0; i < count; i++) {
            if (storage[i].getId().toLowerCase().equals(keyword) ||
                    storage[i].getName().toLowerCase().contains(keyword)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("Sản phẩm không tồn tại.");
        } else {
            System.out.println("Đã tìm thấy: " + storage[foundIndex].showInfo());
            System.out.println("Nhập thông tin mới (ID giữ nguyên):");

            System.out.print("Nhập tên mới: ");
            String newName = formatName(sc.nextLine());
            storage[foundIndex].setName(newName);

            System.out.print("Nhập giá mới: ");
            storage[foundIndex].setPrice(Double.parseDouble(sc.nextLine()));

            System.out.print("Nhập số lượng mới: ");
            storage[foundIndex].setQuantity(Integer.parseInt(sc.nextLine()));

            System.out.println("Cập nhật sản phẩm với ID{" + storage[foundIndex].getId() + "} thành công!");
        }
    }

    public static void deleteProduct() {
        System.out.print("Nhập ID cần xóa: ");
        String id = sc.nextLine();
        int indexToDelete = -1;

        for (int i = 0; i < count; i++) {
            if (storage[i].getId().equalsIgnoreCase(id)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Không tìm thấy ID này!");
        } else {
            for (int i = indexToDelete; i < count - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[count - 1] = null; // Xóa phần tử cuối cùng bị dư
            count--;
            System.out.println("Đã xóa thành công!");
        }
    }

    public static void sortProductDescByPrice() {
        //Bubble Sort
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (storage[j].getPrice() < storage[j + 1].getPrice()) {
                    Product temp = storage[j];
                    storage[j] = storage[j + 1];
                    storage[j + 1] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp danh sách theo giá giảm dần!");
        showAndStats();
    }

}
