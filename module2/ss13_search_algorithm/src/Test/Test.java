package Test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String charStart = "CodegymDaNang";
        String[] strings = charStart.split("");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == strings[i].toUpperCase() && i != 0) {
                list.add(" ");
                list.add(strings[i]);
            } else {
                list.add(strings[i]);
            }
        }
        String str="";
        for (int i = 0; i <list.size() ; i++) {
            str+=list.get(i);
        }
        System.out.println(str.toLowerCase());
    }
}
