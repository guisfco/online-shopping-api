package br.com.guisfco.onlineshopping.repository;

import br.com.guisfco.onlineshopping.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends org.springframework.data.repository.Repository<Product, Long> {

    List<Product> findAll();

    @Query("from Product where id in :ids and enabled = true and stockLevel > 0")
    List<Product> findAll(@Param("ids") List<Long> ids);

    Product findById(Long id);

    void deleteById(Long id);

    Product save(Product product);

    void deleteAll();
}
