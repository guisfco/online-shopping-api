package br.com.guisfco.onlineshopping.service.product;

import br.com.guisfco.onlineshopping.domain.ProductRequest;
import br.com.guisfco.onlineshopping.entity.Product;
import br.com.guisfco.onlineshopping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaveProductService {

    private final ProductRepository repository;

    @Transactional
    public Product save(final ProductRequest request) {

        final Product product = Product.builder()
                .description(request.getDescription())
                .enabled(request.isEnabled())
                .imageUrl(request.getImageUrl())
                .name(request.getName())
                .price(request.getPrice())
                .stockLevel(request.getStockLevel())
                .build();

        return repository.saveAndFlush(product);
    }
}
