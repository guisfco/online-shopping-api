package br.com.guisfco.onlineshopping.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderListResponse implements Serializable {

    private static final long serialVersionUID = 6630383985766111074L;

    private List<OrderResponse> orders;
}