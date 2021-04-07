package br.com.guisfco.onlineshopping.controller;

import br.com.guisfco.onlineshopping.domain.ProductListResponse;
import br.com.guisfco.onlineshopping.domain.ProductRequest;
import br.com.guisfco.onlineshopping.entity.Product;
import br.com.guisfco.onlineshopping.service.product.DeleteProductService;
import br.com.guisfco.onlineshopping.service.product.FindAllProductsService;
import br.com.guisfco.onlineshopping.service.product.SaveProductService;
import br.com.guisfco.onlineshopping.service.product.UpdateProductService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final SaveProductService saveProductService;

    private final FindAllProductsService findAllProductsService;

    private final DeleteProductService deleteProductService;

    private final UpdateProductService updateProductService;

    @ApiOperation("Consulta todos os produtos")
    @GetMapping("/product")
    private ResponseEntity<ProductListResponse> get() {
        return ResponseEntity.ok(findAllProductsService.findAll());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Adiciona um produto")
    @PostMapping("/product")
    private ResponseEntity<Product> save(@RequestBody final ProductRequest request) {
        return ResponseEntity.ok(saveProductService.save(request));
    }

    @ApiOperation("Atualiza as informações de um produto através do id")
    @PutMapping("/product/{id}")
    private ResponseEntity<Product> update(@PathVariable("id") final Long id,
                                           @RequestBody final ProductRequest request) {

        return ResponseEntity.ok(updateProductService.update(id, request));
    }

    @ApiOperation("Deleta um produto através do id")
    @DeleteMapping("/product/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable("id") final Long id) {
        deleteProductService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
