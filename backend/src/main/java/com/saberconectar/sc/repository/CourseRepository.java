package com.saberconectar.sc.repository;

import com.saberconectar.sc.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
