package tech.neckel.perfectApi.product;

import java.util.List;

public interface ProductService {
    List<Product> listAll();
    Product create(Product product);
    Product update(Product product);
    void delete(Long id);

    Product findById(Long id);
}
