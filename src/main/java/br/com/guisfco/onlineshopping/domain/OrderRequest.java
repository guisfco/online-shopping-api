package br.com.guisfco.onlineshopping.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest implements Serializable {

    private static final long serialVersionUID = 4150168179310689669L;

    private Long customerId;

    private List<OrderProduct> products;
}