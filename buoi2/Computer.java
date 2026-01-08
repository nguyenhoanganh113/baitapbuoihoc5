package buoi2;

public class Computer {
    public static int totalComputersCreated = 0;

    String name;

    public Computer(String name) {
        this.name = name;
        totalComputersCreated++;
    }

    public static void changeDeviceName(Computer computer, String newName){
        computer.name = newName;
    }

    public static void main(String[] args){
        Computer c1 = new Computer("Asus");
        Computer c2 = new Computer("Dell");
        System.out.println("Tổng số máy tính đã tạo: " + Computer.totalComputersCreated);
        System.out.println("Tên ban đầu của c1: " + c1.name);
        changeDeviceName(c1, "Apple");
        System.out.println("Tên của c1 sau khi sử dụng method changeDeviceName: " + c1.name);
    }

}
