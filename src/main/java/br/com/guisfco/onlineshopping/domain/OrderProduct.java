package br.com.guisfco.onlineshopping.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = -9169206731662794362L;

    private Long id;

    private int quantity;
}
