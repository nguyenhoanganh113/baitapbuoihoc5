package buoi4;

import java.util.Scanner;

/*
Cho một mảng hai chiều kích thước n x n (ma trận vuông)
Yêu cầu: Tính tổng các phần tử nằm trên đường chéo chính và đường chéo phụ của ma trận.
 */
public class Bai15 {
     static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập kích thước của ma trận hình vuông đó: ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        System.out.println("Nhập các phần tử của ma trận: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Ma trận vừa nhập");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        long tongDuongCheoChinh = 0;
        long tongDuongCheoPhu = 0;

        for (int i = 0; i < n; i++) {
            // Cộng phần tử đường chéo chính (i, i)
            tongDuongCheoChinh += arr[i][i];

            // Cộng phần tử đường chéo phụ (i, n - 1 - i)
            tongDuongCheoPhu += arr[i][n - 1 - i];
        }

        System.out.println("--------------------------------------");
        System.out.println("Tổng đường chéo CHÍNH: " + tongDuongCheoChinh);
        System.out.println("Tổng đường chéo PHỤ:   " + tongDuongCheoPhu);

        long tongCaHai = tongDuongCheoChinh + tongDuongCheoPhu;

        //Nếu kichs thước lẻ thì sẽ trừ đi 1 ô ở tâm
        if(n % 2 != 0){
            tongCaHai -= arr[n/2][n/2];
        }

        System.out.println("Tổng các số nằm trên hình chữ X (Hợp của 2 đường chéo): " + tongCaHai);

        sc.close();
    }
}
