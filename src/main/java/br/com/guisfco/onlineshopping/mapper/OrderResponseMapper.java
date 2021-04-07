package br.com.guisfco.onlineshopping.mapper;

import br.com.guisfco.onlineshopping.domain.OrderProductResponse;
import br.com.guisfco.onlineshopping.domain.OrderResponse;
import br.com.guisfco.onlineshopping.entity.Order;
import br.com.guisfco.onlineshopping.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OrderResponseMapper {

    public static OrderResponse apply(final Order order) {

        final double total = order.getProducts().stream()
                .map(product -> product.getPrice().doubleValue())
                .mapToDouble(Double::doubleValue)
                .sum();

        final List<OrderProductResponse> products = order.getProducts().stream()
                .distinct()
                .map(product -> mapOrderProductResponse(product, order.getProducts()))
                .collect(Collectors.toList());

        return OrderResponse.builder()
                .customer(order.getCustomer())
                .id(order.getId())
                .products(products)
                .total(new BigDecimal(total))
                .build();
    }

    private static long getQuantity(final Long productId, final List<Product> products) {
        return products.stream().filter(product -> product.getId().equals(productId)).count();
    }

    private static OrderProductResponse mapOrderProductResponse(final Product product, final List<Product> orderProducts) {

        return OrderProductResponse.builder()
                .id(product.getId())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(Math.toIntExact(getQuantity(product.getId(), orderProducts)))
                .build();
    }
}
