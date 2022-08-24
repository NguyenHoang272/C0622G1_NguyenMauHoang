package ss17_binary_file_serialization.product_manage.sevice.impl;

import ss17_binary_file_serialization.product_manage.model.Product;
import ss17_binary_file_serialization.product_manage.sevice.IProduceService;
import ss17_binary_file_serialization.product_manage.ultil.data.ReadFile;
import ss17_binary_file_serialization.product_manage.ultil.data.WriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProduceService implements IProduceService {
    static List<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE = "C0622G1_NguyenMauHoang\\src\\ss17_binary_file_serialization\\product_manage\\ultil\\data\\product.dat";

    @Override
    public void addProduce() throws IOException, ClassNotFoundException {
        products = ReadFile.readFileProduct(PATH_FILE);
        System.out.println("------------------------------------------------");
        System.out.println("Chào mừng bạn đến với chức năng thêm mới");
        Product product = this.infoProduce();
        products.add(product);
        System.out.println("Bạn đã thêm thành công");
        WriteFile.writeFileProduce(PATH_FILE, products);
    }

    @Override
    public void displayProduce() throws IOException, ClassNotFoundException {
        products = ReadFile.readFileProduct(PATH_FILE);
        System.out.println("------------------------------------------------");
        System.out.println("Chào mừng bạn đến với chức năng hiển thị");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Bạn đã hiển thị thành công");
    }

    @Override
    public void searchProduce() throws IOException, ClassNotFoundException {
        products = ReadFile.readFileProduct(PATH_FILE);
        System.out.println("------------------------------------------------");
        System.out.println("Chào mừng bạn đến với chức năng tìm kiếm");
        System.out.println("Nhập vào id bạn muốn tìm kiếm");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println("Thông tin sản phẩm có id là " + product.getId() + " :");
                System.out.println(product);
            } else {
                System.out.println("Sản phẩm bạn cần tìm không có trong danh sách sản phẩm");
            }
        }
    }

    public Product infoProduce() {
        System.out.println("Hãy nhập vào mã sản phẩm");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Hãy nhập vào tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Hãy nhập vào hãng sản xuất");
        String productCompany = scanner.nextLine();
        System.out.println("Hãy nhập vào giá sản phẩm");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, productCompany, price);
        return product;
    }

}