package br.com.guisfco.onlineshopping.service.customer;

import br.com.guisfco.onlineshopping.domain.CustomerRequest;
import br.com.guisfco.onlineshopping.entity.Customer;
import br.com.guisfco.onlineshopping.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCustomerService {

    private final CustomerRepository repository;

    private final FindCustomerByIdService findCustomerByIdService;

    public Customer update(final Long id, final CustomerRequest request) {

        final Customer customer = findCustomerByIdService.findById(id);

        customer.setBirthDateInMillis(request.getBirthDateInMillis());
        customer.setBlacklist(request.isBlacklist());
        customer.setName(request.getName());
        customer.setPhoneNumber(request.getPhoneNumber());

        return repository.save(customer);
    }
}
