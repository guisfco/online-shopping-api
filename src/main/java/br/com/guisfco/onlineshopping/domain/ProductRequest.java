package br.com.guisfco.onlineshopping.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequest implements Serializable {

    private static final long serialVersionUID = -7349272682761793524L;

    private String name;

    private String description;

    private BigDecimal price;

    private String imageUrl;

    private int stockLevel;

    private boolean enabled;
}