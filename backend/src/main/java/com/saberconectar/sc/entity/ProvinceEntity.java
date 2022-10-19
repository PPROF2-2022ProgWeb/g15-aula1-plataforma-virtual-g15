package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
@Entity
@Table(name = "province")
@Getter
@Setter
@SQLDelete(sql = "UPDATE province SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Boolean deleted = Boolean.FALSE;
}
