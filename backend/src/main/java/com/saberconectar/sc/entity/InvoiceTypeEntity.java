package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
@Entity
@Table(name = "invoice_type")
@Getter
@Setter
@SQLDelete(sql = "UPDATE invoice_type SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class InvoiceTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Character type;
    //soft-delete
    private Boolean deleted = Boolean.FALSE;
}
