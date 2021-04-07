package br.com.guisfco.onlineshopping.service.product;

import br.com.guisfco.onlineshopping.domain.ProductListResponse;
import br.com.guisfco.onlineshopping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllProductsService {

    private final ProductRepository repository;

    public ProductListResponse findAll() {
        return new ProductListResponse(repository.findAll());
    }
}
