package bai_tap;
import java.util.Arrays;
public class AddElementFromArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,6,7,8};
        int index=1;
        int k=4;

        for (int i = array.length-1; i > index ; i--) {
            //Duyệt từ cuối mảng đến ngay trước vị trí index cần thêm
            array[i]=array[i-1];
        }
        array[index]=k;
        System.out.println(Arrays.toString(array));
    }
}
