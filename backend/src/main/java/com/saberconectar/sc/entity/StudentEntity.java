package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "student")
@Getter
@Setter
@SQLDelete(sql = "UPDATE student SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    @Column(name = "document_number")
    private String documentNumber;
    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;
    //soft-delete
    private Boolean deleted = Boolean.FALSE;
    //User relationship
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    //Courses relationship
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id"))
    private Set<CourseEntity> courses = new HashSet<>();
    //Careers relationship
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "student_career",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name="career_id"))
    private Set<CareerEntity> careers = new HashSet<>();
}
