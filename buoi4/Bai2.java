package buoi4;

import java.util.Scanner;

public class Bai2 {

    public static void thaoTacVoiChuoi(String s){
        System.out.println("Độ dài của mảng là: " + s.length());
        String chuHoa = s.toUpperCase();
        String chuThuong = s.toLowerCase();
        System.out.println(String.format("Mảng thành chữ hoa: %s", chuHoa));
        System.out.println(String.format("Mảng thành chữ thường: %s", chuThuong));
        String chuoiDaTrim = s.trim();
        System.out.println(String.format("Chuỗi sau khi trim: %s", chuoiDaTrim));
        System.out.println(String.format("Độ dài sau khi trim: %d ký tự", chuoiDaTrim.length()));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập một chuỗi bất kỳ: ");
        String input = sc.nextLine();
        thaoTacVoiChuoi(input);
    }
}
