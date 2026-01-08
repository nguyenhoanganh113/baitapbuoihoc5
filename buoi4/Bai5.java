package buoi4;

import java.util.Arrays;

public class Bai5 {

    public static int firstIndexOfP(String data){
        int viTri = data.indexOf('P');
        if (viTri != -1) {
            String ketQua = String.format("Ký tự 'P' xuất hiện lần đầu tại chỉ số: %d", viTri + 1);
            System.out.println(ketQua);
        } else {
            System.out.println("Không tìm thấy ký tự 'P' trong chuỗi!");
        }
        return viTri + 1;
    }

    public static String[] useMethodSplitOfString(String data){
        String[] dataAfterUseMethodSplit = data.split(",");
        for (int i = 0; i < dataAfterUseMethodSplit.length; i++) {
            String phanTuHienTai = dataAfterUseMethodSplit[i];
            boolean startsWithJava = phanTuHienTai.startsWith("Java");
            if (startsWithJava) {
                System.out.println(String.format("Phần tử thứ %d (%s): Bắt đầu bằng 'Java'", i + 1, phanTuHienTai));
            } else {
                System.out.println(String.format("Phần tử thứ %d (%s): KHÔNG bắt đầu bằng 'Java'", i + 1, phanTuHienTai));
            }
        }
        return dataAfterUseMethodSplit;
    }

    public static void main(String[] args){
        String data = "Java,Python,C++,PHP,JavaScript";
        useMethodSplitOfString(data);
        firstIndexOfP(data);
    }
}
