package bai_tap;

import java.util.Scanner;

public class PrintIsoscelesTriangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hight, k = 0;
        System.out.println("Nhập vào chiều cao của tam giác: ");
        hight = sc.nextInt();
        for (int i = 1; i <= hight; ++i, k = 0) {
            for (int j = 1; j <= hight - i; ++j) {
                System.out.print("  ");
            }
            while (k != 2 * i - 1) {
                System.out.print("* ");
                ++k;
            }
            System.out.println();
        }
    }
}
