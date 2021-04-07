package br.com.guisfco.onlineshopping.domain;

import br.com.guisfco.onlineshopping.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse implements Serializable {

    private static final long serialVersionUID = -8277591926485713927L;

    private Long id;

    private BigDecimal total;

    private Customer customer;

    private List<OrderProductResponse> products;
}