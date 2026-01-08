package buoi4;

/*
Tìm kiếm và Sắp xếp Mảng
Viết chương trình nhập vào một mảng gồm n số nguyên: 9
  •	Tìm và in ra giá trị lớn nhất (Max) và nhỏ nhất (Min) trong mảng.
  •	Thực hiện sắp xếp mảng theo thứ tự tăng dần và in mảng sau khi sắp xếp ra màn hình
  •	Tìm phaanf tử lớn thứ hai trong mảng
  •	Tìm kiếm một số nguyên x trong mảng
  và in ra vị trí của nó (nếu có nhiều vị trí thì in ra tất cả các vị trí, nếu không tìm thấy thì in ra)
*/
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Bai4 {

    public static final int N = 9;

    public static int[] arr = new int[N];


    //3. Tìm phần tử lớn thứ N
    public static int findNthLargest(int[] nums, int n) {

        //Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.add(num);
        }

        for (int i = 0; i < n - 1; i++) {
            pq.poll();
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        //1
        System.out.println("Số lớn nhất trong mảng là: " + max);
        System.out.println("Số nhỏ nhất trong mảng là: " + min);

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        //2
        System.out.println("--------------------");
        System.out.print("Mảng sau khi sắp xếp tăng dần: ");
        for(int i = 0; i < N; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //3
        System.out.println("Hãy nhập phần tử lớn thứ N mà bạn muốn: ");
        int phanTuMaxThuN = sc.nextInt();
        int result = findNthLargest(arr,  phanTuMaxThuN);
        System.out.println(result);
        sc.close();
    }
}
