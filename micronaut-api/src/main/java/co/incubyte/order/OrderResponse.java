package co.incubyte.order;

import co.incubyte.Config;
import com.fasterxml.jackson.annotation.JsonFormat;
import co.incubyte.product.Product;

import java.time.OffsetDateTime;

public record OrderResponse(
    String id,
    int quantity,
    double amount,

    Product product,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Config.DATE_PATTERN, timezone = "UTC")
    OffsetDateTime createdAt) {}
