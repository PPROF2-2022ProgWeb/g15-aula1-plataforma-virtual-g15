package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
@Entity
@Table(name = "sale")
@Getter
@Setter
@SQLDelete(sql = "UPDATE sale SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer productQuantity;
    private Double totalPrice;
    //soft-delete
    private Boolean deleted = Boolean.FALSE;
    @Column(name="product_id", nullable = false)
    private Long productId;
    //Product
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product; // search info into product datatable
}
