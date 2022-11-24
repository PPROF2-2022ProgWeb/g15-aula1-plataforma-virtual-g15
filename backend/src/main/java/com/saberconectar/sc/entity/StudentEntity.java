package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    private Long id;

    @Size(min = 3, max = 50, message = "{student.name.size}")
    @NotNull(message = "{student.name.null}")
    private String name;

    @Size(min = 3, max = 50, message = "{student.lastname.size}")
    @NotNull(message = "{student.lastname.null}")
    private String lastname;

    @Column(name = "document_number")
    @Length(min = 7, message = "{student.documentNumber.length}")
    @NotNull(message = "{student.documentNumber.null}")
    private String documentNumber;

    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @NotNull(message = "{student.date.null}")
    private LocalDate date;

    //soft-delete
    @AssertFalse(message = "{user.deleted.boolean}")
    private Boolean deleted = Boolean.FALSE;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
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
