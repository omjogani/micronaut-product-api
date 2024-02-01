@Singleton

Micronaut handle the initialization of the Object. Spring compile all the annotations at run time. Micronaut does all those things at compiler tile.
Startup time in the Micronaut is faster than Spring, but compile time is slower in case of Micronaut because all the annotations at compile time.

//@Singleton
//public class ProductRepository {
//
//    public List<Product> products = new ArrayList<>();
//
//    public Product getProductById(String productId){
//        return products.stream()
//                .filter(product -> product.getId().equals(productId))
//                .findFirst().orElseThrow(EntityNotFound::new);
//    }
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public Product addProduct(Product product) {
//        products.add(product);
//        return product;
//    }
//}