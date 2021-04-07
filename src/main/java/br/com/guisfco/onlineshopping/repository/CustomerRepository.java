package br.com.guisfco.onlineshopping.repository;

import br.com.guisfco.onlineshopping.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends org.springframework.data.repository.Repository<Customer, Long> {

    List<Customer> findAll();

    Customer findById(Long id);

    void deleteById(Long id);

    Customer save(Customer customer);

    void deleteAll();
}
