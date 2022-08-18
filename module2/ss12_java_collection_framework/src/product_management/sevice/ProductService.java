package product_management.sevice;

import product_management.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProduct {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("1", "Hoàng", 10000));
    }

    @Override
    public void add() {
        Product product = this.info();
        products.add(product);
        System.out.println("Thêm mới thành công");
    }

    private Product info() {
        String id;
        do {
            System.out.println("Nhập mã sản phẩm");
            id = scanner.nextLine();
            boolean isCheck = true;
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    System.out.println("Mã sản phẩm bị trùng nhập lại");
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) break;
        } while (true);

        System.out.println("Nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        int price = Integer.parseInt(scanner.nextLine());
        Product product = new Product(id, name, price);
        return product;
    }

    @Override
    public void update() {
        Product product = this.searchId();
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm");
        } else {
            System.out.println("Nhập mã sản phẩm");
            String id = scanner.nextLine();
            product.setId(id);
            System.out.println("Nhập tên sản phẩmm");
            String name = scanner.nextLine();
            product.setName(name);
            System.out.println("Nhập giá sản phẩm");
            int price = Integer.parseInt(scanner.nextLine());
            product.setPrice(price);
            System.out.println("Sửa thành công");
        }
    }

    @Override
    public void delete() {
        Product product = this.searchId();
        if (product == null) {
            System.out.println("Không tim thấy sản phẩm");
        } else {
            System.out.println("Bạn có muốn xóa sản phẩm " + product.getName() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            System.out.println("Nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                products.remove(product);
                System.out.println("Xóa thành côngg");
            }
        }
    }

    private Product searchId() {
        System.out.println("Nhập vào mã sản phẩm muốn tìm");
        String id = scanner.nextLine();
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void display() {
        System.out.println("Hiển thị sản phẩm");
        System.out.println("1. Hiển thị theo thứ tự tăng dần");
        System.out.println("2. Hiện thị theo thứ tự giảm dần");
        int choice = Integer.parseInt(scanner.nextLine());
        while (true) {
            switch (choice) {
                case 1:
                    Collections.sort(products, (o1, o2) -> o1.getPrice() - o2.getPrice());
                    for (Product product: products
                    ) {
                        System.out.println(product);
                    }
                    return;
                case 2:
                    Collections.sort(products, (o1, o2) -> o2.getPrice() - o1.getPrice());
                    for (Product product: products
                    ) {
                        System.out.println(product);
                    }
                    return;
                case 3:
                    return;
                default:
                    System.out.println("Nhập lại lựa chọn");
                    break;
            }
        }
    }

    @Override
    public void find() {
        Product product = this.searchName();
        if (product == null) {
            System.out.println("Không có sản phẩm");
        } else {
            System.out.println(product);
        }
    }


    private Product searchName() {
        System.out.println("Nhập vào tên sản phẩm muốn tìm");
        String name = scanner.nextLine();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}