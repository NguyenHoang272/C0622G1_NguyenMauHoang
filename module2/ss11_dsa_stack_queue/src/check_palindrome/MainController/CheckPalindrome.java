package check_palindrome.MainController;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckPalindrome {
    public static class Palindrome {
        public static void main(String[] args) {
            Stack<String> stack = new Stack<>();
            Queue<String> queue = new LinkedList<>();
            String str;
            Scanner sc = new Scanner(System.in);

            System.out.println("Nhập vào chuỗi cần kiểm tra: ");
            str = sc.nextLine();

            for (int i = 0; i < str.length(); i++) {
                String temp = str.substring(i, i + 1).toLowerCase();
                stack.push(temp);
                queue.add(temp);
            }

            while (!stack.isEmpty()) {
                if (!stack.pop().equals(queue.poll())) {
                    System.out.println("Đây không phải là chuỗi Palindrome!");
                    break;
                }
            }

            if (stack.isEmpty()) {
                System.out.println("Đây là chuỗi Palindrome!");
            }
        }
    }
}
