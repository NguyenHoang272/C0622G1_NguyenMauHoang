package bai_tap;

import java.util.Scanner;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần xóa: ");
        int num = Integer.parseInt(scanner.nextLine());
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                index = i;
            }
        }

        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
    }


