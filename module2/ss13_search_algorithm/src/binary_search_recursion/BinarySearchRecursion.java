package binary_search_recursion;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài mảng:");
        int num= Integer.parseInt(scanner.nextLine());
        int []arr = new int[num];

        for (int i = 0; i <arr.length ; i++) {
            System.out.println("Nhập phần tử:");
            arr[i]= Integer.parseInt(scanner.nextLine());
        }

        sortASC(arr);
        System.out.println("Dãy số được sắp xếp tăng dần: ");
        show(arr);

        System.out.println("Nhập số cần tìm:");
        int so = Integer.parseInt(scanner.nextLine());
       int arrArrange= binarySearch(arr,so,0,arr.length);
        System.out.println("\n Vị trí:" + arrArrange);
    }

    public static void show(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sortASC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }



    public static int binarySearch(int []arr, int k, int left, int right) {

        if (left <= right) {
            int mid = (left + right) / 2;

            if ((k == arr[mid])) {
                return mid;
            }

            if(k> arr[mid]){
                return binarySearch(arr,k,mid+1,right);
            }
            return binarySearch(arr, k, left, mid-1);
        }

            return -1;
        }

}

