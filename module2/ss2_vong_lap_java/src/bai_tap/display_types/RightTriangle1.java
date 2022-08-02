package bai_tap;

import java.util.Scanner;

public class RightTriangle1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hight;
        System.out.println("Nhập vào chiều cao của tam giác: ");
        hight = sc.nextInt();
        for (int i = 1; i <= hight; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
