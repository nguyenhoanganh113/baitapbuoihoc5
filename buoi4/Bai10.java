package buoi4;
/*
Tối ưu hiệu suất với StringBuilder
So sánh hiệu suất khi nối chuỗi:
•	Viết một đoạn mã sử dụng String để nối 10,000 ký tự 'A' vào một chuỗi ban đầu (giải thích tại sao String lại tạo ra nhiều đối tượng vùng nhớ do tính chất immutable)
•	Viết lại đoạn mã đó bằng StringBuilder và phương thức append().
•	Nêu lý do vì sao nên dùng StringBuilder cho ứng dụng đơn luồng và StringBuffer cho ứng dụng đa luồng
 */
public class Bai10 {
    public static void main(String[] args){
        StringBuilder result = new StringBuilder();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            result.append('A');
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Độ dài chuỗi: "+ result.length());
        System.out.println("Thời gian thực thi: " + (endTime - startTime) + "ms");
    }
}
