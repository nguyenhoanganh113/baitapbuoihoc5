package buoi3;

import java.util.Scanner;

public class Bai1 {

    public static boolean checkLapYear(int year){
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year =  sc.nextInt();
        if(checkLapYear(year)){
            System.out.println(year + " Là năm nhuận");
        }
        else
        {
            System.out.println(year + " Là năm không nhuận");
        }
        sc.close();
    }

}
