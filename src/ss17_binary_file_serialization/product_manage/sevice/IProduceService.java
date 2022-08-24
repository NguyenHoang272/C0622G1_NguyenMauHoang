package ss17_binary_file_serialization.product_manage.sevice;

import java.io.IOException;

public interface IProduceService {
    void addProduce() throws IOException, ClassNotFoundException;

    void displayProduce() throws IOException, ClassNotFoundException;

    void searchProduce() throws IOException, ClassNotFoundException;
}
