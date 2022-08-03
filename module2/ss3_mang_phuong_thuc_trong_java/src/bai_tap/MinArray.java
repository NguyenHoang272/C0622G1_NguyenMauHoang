package bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i,size;
        do {
            System.out.println("Nhập độ dài mảng");
            size = Integer.parseInt(scanner.nextLine());
            if (size <= 0) {
                System.out.println("Không hợp lệ, nhập lại");
            }
        } while (size <= 0);

        int[] array = new int[size];

        for (i = 0; i < size; i++) {
            System.out.println("Nhập phần tử của mảng: " + (i + 1));
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Mảng in ra là: " + Arrays.toString(array));

        int min = array[0];
        for (i = 1; i < size; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        System.out.println("Giá trị nhỏ nhất của mảng là: " + min);
    }
}
