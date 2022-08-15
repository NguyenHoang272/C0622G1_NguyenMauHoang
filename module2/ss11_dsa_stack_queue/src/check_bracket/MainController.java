package check_bracket;

import java.util.Stack;

public class MainController {
    public static void main(String[] args) {
        String word = "s * (s – a) * (s – b * (s – c)";
        String[] words = word.split("");
        boolean check = false;
        String left = "";
        Stack<String> stringStack = new Stack<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("(")) {
                stringStack.push(words[i]);
            } else if (words[i].equals(")")) {
                if (stringStack.isEmpty()) {
                    check = false;
                    break;
                } else {
                    left = stringStack.pop();
                    if (!left.equals("(") || !words[i].equals(")")) {
                        check = false;
                        break;
                    }
                }
            }
            if (i == words.length - 1) {
                check = stringStack.isEmpty();
            }
        }
        System.out.println(check);
    }
}
