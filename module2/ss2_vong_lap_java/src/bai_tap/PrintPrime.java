package bai_tap;

import java.util.Scanner;

public class PrintPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá trị giới hạn hiển thị");
        int number = scanner.nextInt();
        int check = 1;
        System.out.println("Hiển thị 20 chữ số nguyên tố đầu tiên");
        for (int i = 2; i < number; i++) {
            int count = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(i);
                check++;
            }
            if (check > 20) {
                break;
            }
        }
    }
}


