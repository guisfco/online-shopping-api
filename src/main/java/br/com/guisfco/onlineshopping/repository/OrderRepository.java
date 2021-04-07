package br.com.guisfco.onlineshopping.repository;

import br.com.guisfco.onlineshopping.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends org.springframework.data.repository.Repository<Order, Long> {

    List<Order> findAll();

    Order save(Order order);

    void deleteAll();
}
