package ch3;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Tuesday 12 October 2021 - 6:57 AM
 */
public class ProductsMain {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("/home/oracle/Documents/lenhac/Final Project IZ0-819/data/products/products.csv");

        ProductsService product = new ProductsService();
        ProductsService p2 = new ProductsService();


        product.createProduct("T-Shirt", "Clothing", new BigDecimal(500), new BigDecimal(360));
        p2.createProduct("Trouser", "Clothing", new BigDecimal(1500), new BigDecimal(1360));
        product.createProduct("Cup", "Homeware", new BigDecimal(685), new BigDecimal(360));
        product.createProduct("Fridge", "Electronics", new BigDecimal(98000), new BigDecimal(11800));



       // product.getProducts(path);

    }
}
