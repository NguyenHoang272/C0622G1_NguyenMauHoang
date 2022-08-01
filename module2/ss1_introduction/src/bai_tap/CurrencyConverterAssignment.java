package bai_tap;

import java.util.Scanner;

public class CurrencyConverterAssignment {
    public static void main(String[] args){
        int quyDoi;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền USD:");
        int usd = scanner.nextInt();
        quyDoi = usd * 23000;
        System.out.print("Nhập số tiền quy đổi thành"+ quyDoi);

    }
}
