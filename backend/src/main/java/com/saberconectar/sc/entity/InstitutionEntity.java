package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "institution")
@Getter
@Setter
@SQLDelete(sql = "UPDATE institution SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class InstitutionEntity {
    @Id
    private Long id;
    private String name;
    private String cuitNumber;
    //soft-delete
    private Boolean deleted = Boolean.FALSE;


    //User relationship
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private UserEntity userEntity;




    //Courses relationships
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "institution_course",
            joinColumns = @JoinColumn(name = "institution_id"),
            inverseJoinColumns = @JoinColumn(name="course_id"))
    private Set<CourseEntity> courses = new HashSet<>();
    //Careers relationship
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "institution_career",
            joinColumns = @JoinColumn(name = "institution_id"),
            inverseJoinColumns = @JoinColumn(name="career_id"))
    private Set<CareerEntity> careers = new HashSet<>();


}

