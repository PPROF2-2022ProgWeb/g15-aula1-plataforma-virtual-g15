package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "course")
@Getter
@Setter
@SQLDelete(sql = "UPDATE course SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    @Column(name = "beginning_day")
    @DateTimeFormat(pattern = "yyy/MM/dd")
    private LocalDate beginningDay;
    @Column(name = "ending_day")
    @DateTimeFormat(pattern = "yyy/MM/dd")
    private LocalDate endingDay;
    private Boolean deleted = Boolean.FALSE;
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.REFRESH)
    private List<InstitutionEntity> institutions = new ArrayList<>();
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.REFRESH)
    private List<StudentEntity> students = new ArrayList<>();
}
