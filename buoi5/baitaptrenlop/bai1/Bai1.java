package buoi5.baitaptrenlop.bai1;

public class Bai1 {
    public static String formatName(String name){
        if(name == null || name.trim().isEmpty()) return "";
        String[] words = name.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            //viết hoa ký tự đầu tiên
            String firstChar = word.substring(0, 1).toUpperCase();
            //các ký tự còn lại viết thường hết
            String restChar = word.substring(1).toLowerCase();
            result.append(firstChar).append(restChar).append(" ");
        }
        return result.toString().trim();
    }

    public static String generateID(String name, int index){
        if(name == null || name.trim().isEmpty()) return "";
        String[] words = name.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            String firstChar = word.substring(0, 1).toUpperCase();
            result.append(firstChar);
        }
        return result.append(index).toString().trim();
    }

    public static void main(String[] args) {
        String input = "  nGuYen   VaN A  ";

        String output = formatName(input);
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Output with formatName method: \"" + output + "\"");

        String output1 = generateID(input, 1);
        System.out.println("Output with generateID method: \"" + output1 + "\"");
    }
}
