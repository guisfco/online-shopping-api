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
public class CustomerRequest implements Serializable {

    private static final long serialVersionUID = -9171711134699242662L;

    private String name;

    private long birthDateInMillis;

    private String phoneNumber;

    private boolean blacklist;
}