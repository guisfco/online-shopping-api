package br.com.guisfco.onlineshopping.service.order;

import br.com.guisfco.onlineshopping.domain.OrderProduct;
import br.com.guisfco.onlineshopping.domain.OrderRequest;
import br.com.guisfco.onlineshopping.domain.OrderResponse;
import br.com.guisfco.onlineshopping.entity.Customer;
import br.com.guisfco.onlineshopping.entity.Order;
import br.com.guisfco.onlineshopping.entity.Product;
import br.com.guisfco.onlineshopping.exception.InvalidOrderException;
import br.com.guisfco.onlineshopping.mapper.OrderResponseMapper;
import br.com.guisfco.onlineshopping.repository.OrderRepository;
import br.com.guisfco.onlineshopping.repository.ProductRepository;
import br.com.guisfco.onlineshopping.service.customer.FindCustomerByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class SaveOrderService {

    private static final int MINIMUM_QUANTITY = 1;

    private final OrderRepository repository;

    private final ProductRepository productRepository;

    private final FindCustomerByIdService findCustomerByIdService;

    public OrderResponse save(final OrderRequest request) {

        final Customer customer = findCustomerByIdService.findById(request.getCustomerId());

        final List<Long> productsIds = request.getProducts().stream()
                .map(OrderProduct::getId)
                .collect(Collectors.toList());

        final List<Product> products = productRepository.findAll(productsIds);

        if (isEmpty(products)) {
            throw new InvalidOrderException("Não foi possível realizar a compra dos produtos solicitados.");
        }

        final List<Product> orderProducts = new ArrayList<>();

        request.getProducts().forEach(orderProduct -> {

            int quantity = Integer.max(orderProduct.getQuantity(), MINIMUM_QUANTITY);
            final Product product = filterById(products, orderProduct.getId());

            if (quantity > product.getStockLevel()) {
                quantity = product.getStockLevel();
            }

            product.setStockLevel(product.getStockLevel() - quantity);

            for (int i = 0; i < quantity; i++) {
                orderProducts.add(product);
            }
        });

        final Order order = Order.builder()
                .customer(customer)
                .products(orderProducts)
                .build();

        final Order savedOrder = repository.save(order);

        return OrderResponseMapper.apply(savedOrder);
    }

    private Product filterById(final List<Product> products, final Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }
}
