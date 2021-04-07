package br.com.guisfco.onlineshopping.service.product;

import br.com.guisfco.onlineshopping.entity.Product;
import br.com.guisfco.onlineshopping.exception.ProductNotFoundException;
import br.com.guisfco.onlineshopping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class FindProductByIdService {

    private final ProductRepository repository;

    public Product findById(final Long id) {
        return ofNullable(repository.findById(id)).orElseThrow(ProductNotFoundException::new);
    }
}
