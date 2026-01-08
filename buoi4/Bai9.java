package buoi4;

import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(checkName(s)) System.out.println("Input vừa nhập là \"T3H\"");
        else System.out.println("Input vừa nhập không phải là \"T3H\"");
    }
    public static boolean checkName(String name){
        return name.equals("T3H");
    }
}
