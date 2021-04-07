package br.com.guisfco.onlineshopping.service.customer;

import br.com.guisfco.onlineshopping.domain.CustomerRequest;
import br.com.guisfco.onlineshopping.entity.Customer;
import br.com.guisfco.onlineshopping.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCustomerService {

    private final CustomerRepository repository;

    public Customer save(final CustomerRequest request) {

        final Customer customer = Customer.builder()
                .birthDateInMillis(request.getBirthDateInMillis())
                .blacklist(request.isBlacklist())
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .build();

        return repository.save(customer);
    }
}
