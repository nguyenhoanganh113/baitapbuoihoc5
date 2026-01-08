package buoi4;

import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {
        int[] arr = new int[10];
        input(arr);
        System.out.println("---------------------------------------");
        output(arr);
        System.out.println("---------------------------------------");
        length(arr);
    }

    public static void input(int[] arr){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < arr.length; i++){
            boolean valid = false;
            while(!valid){
                String thongBaoInput = String.format("Nhập phần tử thứ %02d: ", i + 1);
                System.out.print(thongBaoInput);

                arr[i] = sc.nextInt();

                if (arr[i] >= 1 && arr[i] <= 9) {
                    valid = true;
                } else {
                    System.out.println(String.format("Lỗi: Số %d nằm ngoài phạm vi 1-9. Nhập lại!", arr[i]));
                }
            }
        }
    }

    public static void output(int[] arr){
        Scanner sc = new Scanner(System.in);
        System.out.print("Mảng bạn vừa nhập: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(String.format("%-2d", arr[i]));
        }
        System.out.println();
    }

    public static void length(int[] arr){
        Scanner sc = new Scanner(System.in);
        System.out.print(String.format("Tổng số phần tử của mảng là: %d phần tử", arr.length));
        System.out.println();
    }
}
