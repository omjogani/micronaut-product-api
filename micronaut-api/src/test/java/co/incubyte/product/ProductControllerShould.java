package co.incubyte.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductControllerShould {

  ProductService productService;

  ProductController productController;

  @BeforeEach
  void setUp() {
    productService = Mockito.mock(ProductService.class);

    productController = new ProductController(productService);
  }

  @Test
  void invoke_add_product_in_service() {
//    when(productService.addProduct(any(ProductRequest.class))).thenReturn();
  }
}
