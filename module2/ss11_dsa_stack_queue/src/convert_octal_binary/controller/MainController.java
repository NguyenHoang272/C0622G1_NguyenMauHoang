package convert_octal_binary.controller;

import java.util.Scanner;
import java.util.Stack;

public class MainController {
    public static void main(String[] args) {
        System.out.println("Số bạn cần nhập:");
        Stack<Integer> integerStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        while (number!=0){
            integerStack.push(number%2);
            number /= 2;//number = number/2;
        }
        while (!integerStack.isEmpty()){
            System.out.print(integerStack.pop());
        }

    }
}
