package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "invoice")
@Getter
@Setter
@SQLDelete(sql = "UPDATE invoice SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate date;
    //soft-delete
    private Boolean deleted = Boolean.FALSE;
    @Column(name="invoice_type_id", nullable = false)
    private Long invoiceTypeId;
    @Column(name="sale_id", nullable = false)
    private Long saleId;
    @Column(name="user_id", nullable = false)
    private Long userId;
    //User
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user; // search info into user datatable
    //InvoiceType
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "invoice_type_id", insertable = false, updatable = false)
    private InvoiceTypeEntity invoiceType; // search info into invoice_type datatable
    //Sale
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "sale_id", insertable = false, updatable = false)
    private SaleEntity sale; // search info into sale datatable
}
