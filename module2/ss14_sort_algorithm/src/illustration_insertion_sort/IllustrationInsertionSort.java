package illustration_insertion_sort;

import java.util.Arrays;

public class IllustrationInsertionSort {
    public static void main(String args[]) {
        int arr[] = { 1,6,4,3,7,8,9,5 };
        System.out.println("Mảng ban đầu:");
        printArray(arr);
        System.out.println("Mảng sau khi sắp xếp:");
        insertSort(arr);
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void insertSort(int[] arr) {
        for(int i=1; i< arr.length;i++){
            int key = arr[i];
            int j;
            for (j = i-1; j >=0 && arr[j] > key; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = key;
        }
       System.out.println(Arrays.toString(arr));
    }

}
