package co.incubyte.product;

import de.huxhorn.sulky.ulid.ULID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProductServiceShould {

    ProductService productService;

    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(productRepository);

        productService = new ProductService(productRepository);
    }

    @Test
    void add_product_to_repository() {
//        Product product = new Product(new ULID().nextULID(), "Om");
//        when(productRepository.save(product)).thenReturn(product);
//
//        Product addedProduct = productService.addProduct(product);
//
//        verify(productRepository).save(product);
//        assertThat(addedProduct).isEqualTo(product);
    }
}