package buoi2;

public class Product {

    private static final String productName = "Iphone 17 Pro";
    private static final Double price = 43000000.00;
    private static final Integer quantity = 2;

    public static void main(String[] args){
        double discount;
        discount = quantity > 10 ? 0.1 : 0.05;
        double total;
        total = (price * quantity) * (1 - discount);
        String result = String.format("San pham[%s] - Tong tien: [%,.0f]", productName, total);
        System.out.println(result);
    }
}
