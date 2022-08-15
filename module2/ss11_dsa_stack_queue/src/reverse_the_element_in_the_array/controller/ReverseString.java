package reverse_the_element_in_the_array.controller;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Stack<String> stringStack = new  Stack<>();
        String word = "Hi em!";
        String [] words = word.split("");
        for (int i = 0; i <words.length ; i++) {
            stringStack.push(words[i]);
        }
        System.out.println("Chuỗi khi chưa đảo ngược:");
        System.out.println((word));
        int j;
        for (j = 0; j < words.length; j++) {
            words[j] = stringStack.pop();
        }

        String wordRe = "";
        int k;
        for (k = 0; k < words.length; k++) {
            wordRe += words[k];
        }
        System.out.print("Chuỗi khi đảo ngược: ");
        System.out.println(wordRe);
    }
}
