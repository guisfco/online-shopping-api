package br.com.guisfco.onlineshopping.service.product;

import br.com.guisfco.onlineshopping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductService {

    private final ProductRepository repository;

    private final FindProductByIdService findProductByIdService;

    public void deleteById(final Long id) {
        repository.deleteById(findProductByIdService.findById(id).getId());
    }
}
