package setting_insertion_sort;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.net.SocketTimeoutException;
import java.util.Arrays;

public class SettingInsertionSort {
    public static void insertSort(int[] arr) {
        for(int i=1; i< arr.length;i++){
            int key = arr[i];
            int j;
            for (j = i-1; j >=0 && arr[j] > key; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }

}
