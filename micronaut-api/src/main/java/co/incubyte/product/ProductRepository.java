package co.incubyte.product;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ProductRepository  extends CrudRepository<Product, String> {
    List<Product> findByName(String name);
}
