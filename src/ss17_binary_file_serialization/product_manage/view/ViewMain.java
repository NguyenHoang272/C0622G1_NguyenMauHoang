package ss17_binary_file_serialization.product_manage.view;

import ss17_binary_file_serialization.product_manage.controller.ProductController;

import java.io.IOException;

public class ViewMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProductController productController = new ProductController();
        productController.productManager();
    }
}