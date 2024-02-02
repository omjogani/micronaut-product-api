package co.incubyte.product;

import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Error;

import java.util.List;

@Controller("/product")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Get("/all")
    List<Product> getProducts() {
            return productService.getProducts();
        }

    @Get("/{id}")
    Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }
    @Post()
    Product addProduct(@Body ProductRequest body) {
        return productService.addProduct(body);
    }

    @Get
    List<Product> getProductByName(@QueryValue(value = "name", defaultValue = "") String name) {
        return productService.getProductByName(name);
    }

//    @Error(global = true)
//    String notFound() {
//        return "Not found";
//    }
}
