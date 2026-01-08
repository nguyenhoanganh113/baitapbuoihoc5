package buoi5.baitaptrenlop.bai2;

import buoi5.baitaptrenlop.bai1.*;

import static buoi5.baitaptrenlop.bai1.Bai1.formatName;

public class Main {

    public static Product createProduct(String id, String rawName, double price, int quantity) {
        String cleanName = formatName(rawName);
        return new Product(id, cleanName, price, quantity);
    }
    public static Product findCheapest(Product[] list) {
        if(list == null || list.length == 0) return null;

        Product minProduct = null;

        for (Product p : list) {
            if (p == null) {
                continue;
            }
            if (minProduct == null || p.price < minProduct.price) {
                minProduct = p;
            }
        }
        return minProduct;
    }
    public static double calculateTotalValue(Product[] list) {
        double total = 0;
        for (Product p : list) {
            if (p != null) {
                total += (p.price * p.quantity);
            }
        }
        return total;
    }

    static void main(String[] args) {
        Product[] list = new Product[100];
        int count = 0;
        list[count++] = createProduct("A1", " tivi   ", 5000, 2);
        list[count++] = createProduct("A2", "  chuot   ", 200, 10);
        System.out.print("Tên chuẩn hóa: ");
        for (int i = 0; i < count; i++) {
            System.out.print(list[i].name);
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        Product cheapest = findCheapest(list);
        if (cheapest != null) {
            System.out.println("Sản phẩm rẻ nhất: " + cheapest.name + " (" + cheapest.price + ")");
        }

        double totalValue = 0;
        StringBuilder formula = new StringBuilder();
        for (int i = 0; i < count; i++) {
            Product p = list[i];
            formula.append("(").append((int)p.price).append("*").append(p.quantity).append(")");
            totalValue = calculateTotalValue(list);
            if (i < count - 1) {
                formula.append(" + ");
            }
        }

        System.out.println("Tổng giá trị kho: " + formula + " = " + totalValue);
    }
}
