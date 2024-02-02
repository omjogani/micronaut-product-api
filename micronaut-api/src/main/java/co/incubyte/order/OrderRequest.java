package co.incubyte.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderRequest(@Min(1) int quantity, @Min(1) double amount, @NotNull @NotBlank String productId) {}
