package baitapcuoimodule1;

import baitapcuoimodule1.entity.*;


public class Main {
    public static void main(String[] args){
        Warehouse warehouse = new Warehouse();

        System.out.println();
        System.out.println("---------------CHỨC NĂNG 1: THÊM SẢN PHẨM VÀO KHO---------------------");
        System.out.println("========= TEST CASE 1: THÊM THÀNH CÔNG =========");
        Product p1 = new Product(1, "Iphone 15", 25000000, 10);
        warehouse.addProductToWarehouse(0, p1);

        System.out.print("\n========= TEST CASE 2: TRÙNG SẢN PHẨM =========");
        Product p2 = new Product(1, "IPHONE 15", 30000000, 5);
        warehouse.addProductToWarehouse(0, p2);

        System.out.println("\n========= TEST CASE 3: DANH MỤC ĐẦY =========");
        for (int i = 0; i < 20; i++) {
            // Giả lập danh mục 2 (Thực phẩm) bị đầy bằng vòng lặp
            warehouse.addProductToWarehouse(2, new Product(100 + i, "Bánh " + i, 1000, 1));
        }

        System.out.println("-> Thử thêm sản phẩm thứ 21:");
        // Input: Thêm khi count == 20
        Product pFull = new Product(999, "Kẹo Cu Đơ", 5000, 1);
        warehouse.addProductToWarehouse(2, pFull);

        System.out.println();
        System.out.println();
        System.out.println("---------------CHỨC NĂNG 2: TÌM KIẾM SẢN PHẨM THEO TÊN---------------------");
        warehouse.addProductToWarehouse(0, new Product(1, "Iphone 15", 25000000, 10));
        warehouse.addProductToWarehouse(0, new Product(2, "Iphone 14 Pro", 20000000, 5));
        warehouse.addProductToWarehouse(0, new Product(3, "Samsung Galaxy", 15000000, 8));
        // --- CASE 1: TÌM CÓ KẾT QUẢ ---
        warehouse.searchProduct("iphone");
        // --- CASE 2: KHÔNG CÓ KẾT QUẢ ---
        warehouse.searchProduct("nokia");


        System.out.println();
        System.out.println();
        System.out.println("---------------CHỨC NĂNG 3: XÓA SẢN PHẨM THEO ID---------------------");
        System.out.println("--- KHO TRƯỚC KHI XÓA ---");
        warehouse.showAllInventory();
        warehouse.deleteProduct(2);
        System.out.println("--- KHO SAU KHI XÓA ID 2 ---");
        warehouse.showAllInventory();
        // --- CASE 2: KHÔNG TÌM THẤY ---
        warehouse.deleteProduct(999);


        warehouse.sortAllProductsByPrice();
    }
}
