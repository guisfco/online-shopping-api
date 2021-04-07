package br.com.guisfco.onlineshopping.domain;

import br.com.guisfco.onlineshopping.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerListResponse implements Serializable {

    private static final long serialVersionUID = 1594761636094824414L;

    private List<Customer> customers;
}