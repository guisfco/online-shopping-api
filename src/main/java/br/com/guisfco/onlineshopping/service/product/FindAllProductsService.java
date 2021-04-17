package br.com.guisfco.onlineshopping.service.product;

import br.com.guisfco.onlineshopping.entity.Product;
import br.com.guisfco.onlineshopping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllProductsService {

    private final ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }
}
