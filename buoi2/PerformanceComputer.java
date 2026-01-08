package buoi2;

import java.util.Scanner;

public class PerformanceComputer {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Hãy nhập vào dung lượng RAM: ");
        int ram = sc.nextInt();

        System.out.println("Có SSD hay không? (true/false): ");
        boolean hasSSD = sc.nextBoolean();

        String type;

        if(ram >= 16 && hasSSD == true){
            type = "Loại VIP";
        }
        else if(ram >= 8 && ram < 16 && hasSSD == true){
            type = "Loại khá";
        }
        else if(ram >= 8 && hasSSD == false){
            type = "Loại TB";
        }
        else{
            type = "Loại Yếu";
        }
        System.out.println("Kết quả đánh giá: " + type);
        sc.close();
    }

}
