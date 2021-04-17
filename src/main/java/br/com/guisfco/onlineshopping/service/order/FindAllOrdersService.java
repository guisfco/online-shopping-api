package br.com.guisfco.onlineshopping.service.order;

import br.com.guisfco.onlineshopping.domain.OrderResponse;
import br.com.guisfco.onlineshopping.mapper.OrderResponseMapper;
import br.com.guisfco.onlineshopping.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllOrdersService {

    private final OrderRepository repository;

    public List<OrderResponse> findAll() {
        return repository.findAll().stream().map(OrderResponseMapper::apply).collect(Collectors.toList());
    }
}
