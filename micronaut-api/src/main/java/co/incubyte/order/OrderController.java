package co.incubyte.order;

import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/order")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @Get
  List<OrderResponse> getAllOrders() {
    List<Order> allOrders = orderService.getAllOrders();
    return allOrders.stream()
        .map(order -> new OrderResponse(order.getId(), order.getQuantity(), order.getAmount(), order.getProduct(), order.getCreatedAt()))
        .toList();
  }

  @Post
  OrderResponse addOrder(@Body OrderRequest orderRequest) {
      Order order = orderService.addOrder(orderRequest);
      return new OrderResponse(order.getId(), order.getQuantity(), order.getAmount(), order.getProduct(), order.getCreatedAt());
  }

  @Get("/{id}")
  OrderResponse getOrderById(@PathVariable String id) {
      Order order = orderService.getOrderById(id);
      return new OrderResponse(order.getId(), order.getQuantity(), order.getAmount(), order.getProduct(), order.getCreatedAt());
  }
}
