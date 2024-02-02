package co.incubyte.product;

import co.incubyte.exception.EntityNotFound;
import de.huxhorn.sulky.ulid.ULID;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFound("Product with id [" + id + "] Not Found!"));
    }

    public List<Product> getProducts()  {
        return productRepository.findAll();
    }

    public Product addProduct(ProductRequest body) {
        String id = new ULID().nextULID();
        Product product = new Product(id, body.name());
        return productRepository.save(product);
    }

    public List<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }
}

