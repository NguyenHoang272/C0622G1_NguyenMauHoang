package reverse_the_element_in_the_array.controller;

import java.util.Arrays;
import java.util.Stack;

public class ReverseElement {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,9,10};
        Stack<Integer> integerStack = new Stack<>();
        int i;
        for (i = 0; i < array.length; i++) {
            integerStack.push(array[i]);

        }
        System.out.println("Trước khi đảo");
        System.out.println(integerStack);
        for (int j = 0; j <array.length ; j++) {
            array[j]= integerStack.pop();

        }
        System.out.println("Sau khi đảo");
        System.out.println(Arrays.toString(array));
    }
}
