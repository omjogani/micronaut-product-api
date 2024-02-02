package co.incubyte.order;

import co.incubyte.exception.EntityNotFound;
import co.incubyte.product.ProductService;
import de.huxhorn.sulky.ulid.ULID;
import jakarta.inject.Singleton;

import co.incubyte.product.Product;
import java.util.List;

@Singleton
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;


    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    public Order addOrder(OrderRequest orderRequest) {
        Product product = productService.getProductById(orderRequest.productId());
        Order order = new Order(new ULID().nextULID(), orderRequest.quantity(), orderRequest.amount(), product);
        return orderRepository.save(order);
    }

    public Order getOrderById(String id) {
    return orderRepository.findById(id).orElseThrow(() -> new EntityNotFound("Order with id [" + id + "] not found!"));
    }
}
