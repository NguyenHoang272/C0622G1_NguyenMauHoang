package bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MaxArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập hàng:\n");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập cột:\n");
        int columns = Integer.parseInt(scanner.nextLine());
        double [][] array = new double[row][columns];

        int i;
        int j;
        for (i = 0; i < row ; i++) {
            for (j = 0; j <columns ; j++) {
                System.out.printf("Nhập mảng: [%d][%d]\n",i,j);
                array [i][j] = Integer.parseInt(scanner.nextLine());

            }
        }
        System.out.print("Mảng 2 chiều là " + Arrays.deepToString(array) + "\n");
        int index1=0;
        int index2=0;
        int max = (int) array[0][0];
        for (i = 0; i <array.length ; i++) {
            for (j = 0; j <=i ; j++) {
                if(array[i][j] > max){
                    max= (int)array[i][j];
                    index1= i;
                    index2= j;
                }

            }
            System.out.printf("Giá trị lớn nhất[%d] tại vị trí [%d][%d]",max,index1,index2);
        }

    }
}
