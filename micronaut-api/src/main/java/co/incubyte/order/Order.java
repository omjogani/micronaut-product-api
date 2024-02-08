package co.incubyte.order;
import co.incubyte.product.Product;
import io.micronaut.data.annotation.DateCreated;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;
    private double amount;

    @DateCreated
    OffsetDateTime createdAt;


    public Order() {
    }

    public Order(String id, int quantity, double amount, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.amount = amount;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

