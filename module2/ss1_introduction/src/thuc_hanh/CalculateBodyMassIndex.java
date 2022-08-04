package thuc_hanh;

import java.util.Scanner;

public class CalculateBodyMassIndex {
    public static void main(String[] args){
        double bmi,height,weight;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập cân nặng:");
        weight = scanner.nextDouble();
        System.out.print("Nhập chiều cao:");
        height = scanner.nextDouble();
        bmi = weight / Math.pow(height, 2);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");

        if (bmi<18.5){
            System.out.print(bmi+":Underweight");
        } else if (bmi < 25) {
            System.out.print(bmi+ ":Normal");
        }else if (bmi < 30) {
            System.out.print(bmi+":Overweight");
        }else {
            System.out.print(bmi+":Obese");
        }
    }
}