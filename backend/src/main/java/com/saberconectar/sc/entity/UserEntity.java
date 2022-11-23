package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
@Getter
@Setter
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull(message = "{user.email.null}")
    private String email;

    @Length(min = 8, message = "{user.password.length}")
    @NotNull(message = "{user.password.null}")
    private String password;

    //soft-delete
    @AssertFalse(message = "{user.deleted.boolean}")
    private Boolean deleted = Boolean.FALSE;

    @NotNull(message = "{user.country.null}")
    private String countryId;

    @NotNull(message = "{user.province.null}")
    private String provinceId;

    @NotNull(message = "{user.city.null}")
    private String cityId;

    //@NotNull(message = "Insert true if you are a student.")
    @NotNull(message = "{user.isStudent.null}")
    private Boolean isStudent;

    /*
    //TODO se modificaron los tipos de datos de ciudad , provincia y pais para facilitar los tiempos de produccion
    @Column(name="country_id", nullable = false)
    private Long countryId;
    @Column(name="province_id", nullable = false)
    private Long provinceId;
    @Column(name="city_id", nullable = false)
    private Long cityId;
    //COUNTRY
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private CountryEntity country; // search info into country datatable
    //PROVINCE
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "province_id", insertable = false, updatable = false)
    private ProvinceEntity province; // search info into province datatable
    //CITY
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private CityEntity city; // search info into city datatable
*/
    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private StudentEntity student;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private InstitutionEntity institution;

}
