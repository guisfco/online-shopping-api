package br.com.guisfco.onlineshopping.job;

import br.com.guisfco.onlineshopping.repository.CustomerRepository;
import br.com.guisfco.onlineshopping.repository.OrderRepository;
import br.com.guisfco.onlineshopping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class CleanDatabaseJob {

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    private final OrderRepository orderRepository;

    /**
     * Executa a limpeza dos registros da base de dados a cada 3 horas
     */
    @Scheduled(fixedDelay = 10800000)
    public void execute() {

        log.info("Executando limpeza de registros.");

        orderRepository.deleteAll();
        customerRepository.deleteAll();
        productRepository.deleteAll();
    }
}
