package tech.neckel.perfectApi.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.neckel.perfectApi.exception.BadResquestException;
import tech.neckel.perfectApi.exception.NotFoundResquestException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        if(product.getId() != null){
            throw new BadResquestException("To create a record, you cannot have an ID");
        }

        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        if(product.getId() == null){
            throw new BadResquestException("To update a record, you must have an ID");
        }

        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundResquestException("Not found object with id: " + id));
    }
}
