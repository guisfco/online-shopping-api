package br.com.guisfco.onlineshopping.service.customer;

import br.com.guisfco.onlineshopping.entity.Customer;
import br.com.guisfco.onlineshopping.exception.CustomerNotFoundException;
import br.com.guisfco.onlineshopping.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCustomerByIdService {

    private final CustomerRepository repository;

    public Customer findById(final Long id) {
        return repository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }
}
