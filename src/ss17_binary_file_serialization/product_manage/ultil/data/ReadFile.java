package ss17_binary_file_serialization.product_manage.ultil.data;

import ss17_binary_file_serialization.product_manage.model.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<Product> readFileProduct(String path) throws IOException, ClassNotFoundException {
        List<Product> productList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            productList = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
            if(productList.size() == 0){
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e){
            System.out.printf("File không tồn tại");
        } catch (IOException e){
            System.out.println("Ko có sản phẩm nào:");
        }
        return productList;
    }
}