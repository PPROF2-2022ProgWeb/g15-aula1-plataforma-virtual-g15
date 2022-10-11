package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
@Entity
@Table(name = "user")
@Getter
@Setter
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;
    private String password;
    //soft-delete
    private Boolean deleted = Boolean.FALSE;
    @Column(name="country_id", nullable = false)
    private Long countryId;
    @Column(name="province_id", nullable = false)
    private Long provinceId;
    @Column(name="city_id", nullable = false)
    private Long cityId;
    //COUNTRY
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private CountryEntity country; // search info into country datatable
    //PROVINCE
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "province_id", insertable = false, updatable = false)
    private ProvinceEntity province; // search info into province datatable
    //CITY
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private CityEntity city; // search info into city datatable

    @OneToOne(mappedBy = "userEntity")
    private StudentEntity studentEntity;

    @OneToOne(mappedBy = "userEntity")
    private InstitutionEntity institutionEntity;
}
