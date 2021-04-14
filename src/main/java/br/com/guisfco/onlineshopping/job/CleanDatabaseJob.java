package br.com.guisfco.onlineshopping.job;

import br.com.guisfco.onlineshopping.fixture.CustomerRequestFixture;
import br.com.guisfco.onlineshopping.fixture.ProductRequestFixture;
import br.com.guisfco.onlineshopping.repository.CustomerRepository;
import br.com.guisfco.onlineshopping.repository.OrderRepository;
import br.com.guisfco.onlineshopping.repository.ProductRepository;
import br.com.guisfco.onlineshopping.service.customer.SaveCustomerService;
import br.com.guisfco.onlineshopping.service.product.SaveProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    /**
     * Executa a limpeza dos registros da base de dados a cada 3 horas
     */
    @Scheduled(fixedDelay = 10800000)
    public void execute() {

        log.info("Executando limpeza de registros.");

        orderRepository.deleteAll();
        customerRepository.deleteAll();
        productRepository.deleteAll();

        insertCustomerMockData();
        insertProductMockData();
    }

    private void insertCustomerMockData() {

        for (int i = 0; i < nextInt(1, 6); i++) {
            saveCustomerService.save(CustomerRequestFixture.get().random().build());
        }
    }

    private void insertProductMockData() {

        for (int i = 0; i < nextInt(1, 6); i++) {
            saveProductService.save(ProductRequestFixture.get().random().build());
        }
    }
}
