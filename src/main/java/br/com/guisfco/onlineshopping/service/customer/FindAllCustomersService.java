package br.com.guisfco.onlineshopping.service.customer;

import br.com.guisfco.onlineshopping.domain.CustomerListResponse;
import br.com.guisfco.onlineshopping.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllCustomersService {

    private final CustomerRepository repository;

    public CustomerListResponse findAll() {
        return new CustomerListResponse(repository.findAll());
    }
}
