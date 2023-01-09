package com.matheus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheus.model.Course;

//@Repository //Ao declarar com interface conseguimos extender as interfaces que temos do jpa do spring data
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
