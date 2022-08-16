package product_management.view;

import product_management.controller.ProductController;

public class MainView {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.productManagement();
    }

}
