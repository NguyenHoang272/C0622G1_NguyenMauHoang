package ss17_binary_file_serialization.product_manage.controller;

import ss17_binary_file_serialization.product_manage.sevice.IProduceService;
import ss17_binary_file_serialization.product_manage.sevice.impl.ProduceService;
import ss17_binary_file_serialization.product_manage.ultil.data.OptionException;

import java.io.IOException;
import java.util.Scanner;

public class ProductController {
    public static void productManager() throws IOException {
        IProduceService produceService = new ProduceService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("MENU");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm ");
            System.out.println("3. Tìm kiếm sản phẩm ");
            System.out.println("4. Exit ");
            int choice;
            try {
                System.out.println("Hãy nhập lựa chọn của bạn");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 4) {
                    throw new OptionException("Hãy nhập lựa chọn chính xác");
                } else {
                    switch (choice) {
                        case 1:
                            produceService.addProduce();
                            break;
                        case 2:
                            produceService.displayProduce();
                            break;
                        case 3:
                            produceService.searchProduce();
                            break;
                        case 4:
                            System.out.println("Cám ơn bạn đã sử dụng phần mềm!");
                            return;
                    }
                }
            } catch (OptionException e) {
                System.out.println(e.getMessage());
            } catch ( NumberFormatException e) {
                System.out.println("Hãy nhập đúng định dạng");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
