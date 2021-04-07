package br.com.guisfco.onlineshopping.service.customer;

import br.com.guisfco.onlineshopping.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCustomerService {

    private final CustomerRepository repository;

    private final FindCustomerByIdService findCustomerByIdService;

    public void deleteById(final Long id) {
        repository.deleteById(findCustomerByIdService.findById(id).getId());
    }
}
