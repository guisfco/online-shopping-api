package br.com.guisfco.onlineshopping.job;

import br.com.guisfco.onlineshopping.domain.OrderProduct;
import br.com.guisfco.onlineshopping.domain.OrderRequest;
import br.com.guisfco.onlineshopping.entity.Customer;
import br.com.guisfco.onlineshopping.entity.Product;
import br.com.guisfco.onlineshopping.fixture.CustomerRequestFixture;
import br.com.guisfco.onlineshopping.fixture.ProductRequestFixture;
import br.com.guisfco.onlineshopping.repository.CustomerRepository;
import br.com.guisfco.onlineshopping.repository.OrderRepository;
import br.com.guisfco.onlineshopping.repository.ProductRepository;
import br.com.guisfco.onlineshopping.service.customer.SaveCustomerService;
import br.com.guisfco.onlineshopping.service.order.SaveOrderService;
import br.com.guisfco.onlineshopping.service.product.SaveProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static br.com.guisfco.onlineshopping.util.RandomUtils.nextInt;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class CleanDatabaseJob {

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    private final OrderRepository orderRepository;

    private final SaveCustomerService saveCustomerService;

    private final SaveProductService saveProductService;

    private final SaveOrderService saveOrderService;

    /**
     * Executa a limpeza dos registros da base de dados a cada 3 horas
     */
    @Scheduled(fixedDelay = 10800000)
    public void execute() {

        log.info("Executando limpeza de registros.");

        orderRepository.deleteAll();
        customerRepository.deleteAll();
        productRepository.deleteAll();

        insertMockData();
    }

    private void insertMockData() {

        for (int i = 0; i < nextInt(1, 6); i++) {
            saveCustomerService.save(CustomerRequestFixture.get().random().build());
        }

        for (int i = 0; i < nextInt(1, 6); i++) {
            saveProductService.save(ProductRequestFixture.get().random().build());
        }

        final List<Customer> customers = customerRepository.findAll();
        final List<Product> products = productRepository.findAll();

        for (int i = 0; i < nextInt(1, 6); i++) {

            final Long customerId = customers.get(nextInt(0, customers.size())).getId();
            final Long productId = products.get(nextInt(0, products.size())).getId();

            final OrderRequest orderRequest = new OrderRequest(customerId, Collections.singletonList(new OrderProduct(productId, 1)));

            saveOrderService.save(orderRequest);
        }
    }
}
