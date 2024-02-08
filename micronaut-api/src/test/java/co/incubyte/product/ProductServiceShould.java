package co.incubyte.product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

        Product product = productService.addProduct(new ProductRequest("FAKE_NAME", 100.0));

        verify(productRepository).save(product);
        Assertions.assertThat(product.getName()).isEqualTo("FAKE_NAME");
    }

    // add test to add price in the product
    @Test
    void add_price_to_product() {
        when(productRepository.save(any(Product.class))).then(returnsFirstArg());

        Product product = productService.addProduct(new ProductRequest("FAKE_NAME", 100.0));

        verify(productRepository).save(product);
        Assertions.assertThat(product.getName()).isEqualTo("FAKE_NAME");
        Assertions.assertThat(product.getPrice()).isEqualTo(100.0);
    }

    // add test to get product by id
    @Test
    void get_product_by_id() {
        when(productRepository.findById("FAKE_ID")).thenReturn(java.util.Optional.of(new Product("FAKE_ID", "FAKE_NAME", 100.0)));

        Product product = productService.getProductById("FAKE_ID");

        verify(productRepository).findById("FAKE_ID");
        Assertions.assertThat(product.getName()).isEqualTo("FAKE_NAME");
        Assertions.assertThat(product.getPrice()).isEqualTo(100.0);
    }
}