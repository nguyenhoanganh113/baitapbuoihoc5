package buoi4;

public class Bai7 {

    public static boolean soSanhDiaChi(String s1, String s2) {
        if (s1 == s2) return true;
        else return false;
    }
    public static boolean soSanhNoiDung(String s1, String s2) {
        if (s1.equals(s2)) return true;
        else return false;
    }

    public static void main(String[] args){
        String s1 = "t3h";
        String s2 = new String("t3h");

        if (soSanhDiaChi(s1, s2)) {
            System.out.println(String.format("1. (s1 == s2) là TRUE"));
        } else {
            System.out.println(String.format("1. (s1 == s2) là FALSE -> Vì khác địa chỉ ô nhớ"));
        }

        if (soSanhNoiDung(s1, s2)) {
            System.out.println(String.format("2. (s1.equals(s2)) là TRUE -> Vì giống nội dung văn bản"));
        } else {
            System.out.println(String.format("2. (s1.equals(s2)) là FALSE"));
        }

        if(soSanhDiaChi("JAVA", "java")){
            System.out.println(String.format("3. (JAVA == java) là TRUE"));
        }
        else{
            System.out.println(String.format("3. (JAVA == java) là FALSE"));
        }

        if (soSanhNoiDung("JAVA", "java")) {
            System.out.println(String.format("4. (JAVA.equals(java)) là TRUE -> Vì giống nội dung văn bản"));
        } else {
            System.out.println(String.format("4. (JAVA.equals(java)) là FALSE"));
        }
    }
}
