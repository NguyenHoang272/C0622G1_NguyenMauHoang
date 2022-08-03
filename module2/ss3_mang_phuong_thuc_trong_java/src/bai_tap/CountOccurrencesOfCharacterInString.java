package bai_tap;

import java.util.Scanner;

public class CountOccurrencesOfCharacterInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str= "Nguyen Mau Hoang";
        System.out.print("Nhập ký tự:");
        char check = scanner.nextLine().charAt(0);
        int count = 0;
        int i;
        for (i = 0; i <str.length() ; i++) {
            if(check == str.charAt(i)){
                count++;
            }
        }
        System.out.print(count);
    }
}
