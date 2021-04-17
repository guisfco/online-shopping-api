package br.com.guisfco.onlineshopping.service.customer;

import br.com.guisfco.onlineshopping.entity.Customer;
import br.com.guisfco.onlineshopping.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllCustomersService {

    private final CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
