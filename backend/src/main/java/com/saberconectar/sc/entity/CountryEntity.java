package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
@Entity
@Table(name = "country")
@Getter
@Setter
@SQLDelete(sql = "UPDATE country SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean deleted = Boolean.FALSE;
}
