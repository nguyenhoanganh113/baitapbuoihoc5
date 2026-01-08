package buoi9.baitaptrenlop.bai2;

import java.util.Scanner;

public class InputSalary {

    public static double inputSalary(Scanner scanner) throws InvalidDataException {
        System.out.print("Nhập lương: ");
        String input = scanner.nextLine().trim();

        // cho phép “1,000,000”
        input = input.replace(",", "");

        try {
            double salary = Double.parseDouble(input);

            if (salary <= 0) {
                throw new InvalidDataException("Lương phải > 0!");
            }

            return salary;

        } catch (NumberFormatException e) {
            throw new InvalidDataException("Không đúng định dạng số!");
        }
    }
}


