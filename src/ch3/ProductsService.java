package ch3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Tuesday 12 October 2021 - 7:43 AM
 */
public class ProductsService {

    private Path path = Path.of("/home/oracle/Documents/lenhac/Final Project IZ0-819/data/products/products.csv");

    public void createProduct(String name, String category, BigDecimal sp, BigDecimal cost_price) throws IOException {
        List<ProductModel> products = new ArrayList<>();
        ProductModel product = new ProductModel(name, category, sp, cost_price);
        products.add(product);
        storeProducts(products, path);}




    public void storeProducts(List<ProductModel>  products, Path path) throws IOException {
        try (var out = Files.newBufferedWriter(path)) {
             for (ProductModel productModel: products) {
                 out.write(productModel.toString());
             }
        }
    }


    public void getProducts(Path path) throws IOException {
        try(var p = Files.lines(path)) {
            p.forEach(System.out::println);
        }
    }
}
