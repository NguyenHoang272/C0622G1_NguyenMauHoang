package count_occurrences_word;

import java.util.Map;
import java.util.TreeMap;

public class CountOccurrencesWord {
    public static void main(String[] args) {
        String str = "Hi em hi em anh anh dung day tu chieu";
        String strLow = str.toLowerCase();
        String[] strings = strLow.split(" ");
        Map<String, Integer> treeMap = new TreeMap<>();
        for (String key :
              strings) {
            if (treeMap.containsKey(key)){
                Integer value = treeMap.get(key);
                value++;
                treeMap.replace(key,value);
            }else {
                treeMap.put(key,1);
            }
        }
        System.out.println(treeMap);
    }
}
