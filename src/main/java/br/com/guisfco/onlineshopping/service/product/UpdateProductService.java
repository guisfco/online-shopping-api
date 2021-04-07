package br.com.guisfco.onlineshopping.service.product;

import br.com.guisfco.onlineshopping.domain.ProductRequest;
import br.com.guisfco.onlineshopping.entity.Product;
import br.com.guisfco.onlineshopping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductService {

    private final ProductRepository repository;

    private final FindProductByIdService findProductByIdService;

    public Product update(final Long id, final ProductRequest request) {

        final Product product = findProductByIdService.findById(id);

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setEnabled(request.isEnabled());
        product.setImageUrl(request.getImageUrl());
        product.setPrice(request.getPrice());
        product.setStockLevel(request.getStockLevel());

        return repository.save(product);
    }
}
