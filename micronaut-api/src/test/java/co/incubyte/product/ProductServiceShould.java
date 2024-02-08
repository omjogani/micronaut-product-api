package co.incubyte.product;

import de.huxhorn.sulky.ulid.ULID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.AdditionalAnswers.returnsFirstArg;

import static org.mockito.Mockito.when;

class ProductServiceShould {

    ProductService productService;

    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);

        productService = new ProductService(productRepository);
    }

    @Test
    void add_product_to_repository() {
        when(productRepository.save(any(Product.class))).then(returnsFirstArg());

        Product product = productService.addProduct(new ProductRequest("FAKE_NAME"));

        verify(productRepository).save(product);
        Assertions.assertThat(product.getName()).isEqualTo("FAKE_NAME");
    }

    @Test
    void demo() {
        
    }
}