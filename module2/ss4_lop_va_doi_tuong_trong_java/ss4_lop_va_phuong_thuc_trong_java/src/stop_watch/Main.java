package stop_watch;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StopWatch stopWatch = new StopWatch();
        System.out.print("Thời gian bắt đầu " + stopWatch.start() + "\n");
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = (int)Math.floor(Math.random()*100000);
        }
        Arrays.sort(array);
        System.out.print("Mảng là " + Arrays.toString(array));
        System.out.print("\nThời gian kết thúc " + stopWatch.stop());
        System.out.print("\nThời gian đếm được bằng mili giây là " + stopWatch.getElapsedTime());
    }
}
