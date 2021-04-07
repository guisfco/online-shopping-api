package br.com.guisfco.onlineshopping.domain;

import br.com.guisfco.onlineshopping.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponse implements Serializable {

    private static final long serialVersionUID = -6273444651952571931L;

    private List<Product> products;
}