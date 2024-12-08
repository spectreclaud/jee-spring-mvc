package pl.coderslab.web;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {
    public List<Product> getList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Chleb", 5.0));
        products.add(new Product(2L, "Mleko", 3.5));
        products.add(new Product(3L, "Ser", 8.0));
        return products;
    }
}
