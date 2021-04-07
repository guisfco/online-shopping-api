package br.com.guisfco.onlineshopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "checkout_order")
public class Order implements Serializable {

    private static final long serialVersionUID = -2106725126960095733L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns =
    @JoinColumn(name = "product_id"))
    private List<Product> products;

    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }
}
