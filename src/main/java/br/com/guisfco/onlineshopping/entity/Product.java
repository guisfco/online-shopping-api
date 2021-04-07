package br.com.guisfco.onlineshopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@EqualsAndHashCode(of = "id")
public class Product implements Serializable {

    private static final long serialVersionUID = -3373069553815431812L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    private String imageUrl;

    private int stockLevel;

    private boolean enabled;

    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    @JsonIgnore
    public List<Order> getOrders() {
        return orders;
    }
}
