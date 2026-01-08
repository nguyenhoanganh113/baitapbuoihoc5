package buoi4;
/*
Thay vì tạo một mảng mới, hãy viết chương trình đảo ngược thứ tự các phần tử của một mảng số nguyên ngay trên chính mảng đó.
Yêu cầu: Sử dụng vòng lặp và kỹ thuật hoán đổi (swap) phần tử đầu với phần tử cuối, phần tử thứ hai với phần tử áp chót,
và cứ tiếp tục như vậy cho đến giữa mảng2.
 */
public class Bai11 {
    public static void main(String[] args){
        int[] arr = new int[]{1, 3, 2, 1, 2};

        int left = 0;
        int right = arr.length-1;

        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
