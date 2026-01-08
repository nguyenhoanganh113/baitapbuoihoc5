package buoi4;

public class Bai6 {

    public static int useMethodIndexOf(String s){
        int firstIndex = s.indexOf("T3H");
        if(firstIndex != -1){
            System.out.println(String.format("Vị trí của \"T3H\" là: %d", firstIndex + 1));
        }
        else{
            System.out.println("Không tìm thấy \"T3H\" trong mảng gốc!");
        }
        return firstIndex;
    }

    public static void useMethodSubstring(String s) {
        String target = "T3H";

        int firstIndex = s.indexOf(target);

        if (firstIndex != -1) {
            int lengthOfTarget = target.length();
            int lastIndex = firstIndex + lengthOfTarget;

            String sentenceAfterUsingSubString = s.substring(firstIndex, lastIndex);

            System.out.println(String.format("Dùng substring lấy được chuỗi: \"%s\"", sentenceAfterUsingSubString));
        } else {
            System.out.println("Không tìm thấy từ khóa để cắt!");
        }
    }

    public static void main(String[] args){
        String sentence = "Học viện công nghệ thông tin T3H";
        useMethodIndexOf(sentence);
        useMethodSubstring(sentence);
    }
}
