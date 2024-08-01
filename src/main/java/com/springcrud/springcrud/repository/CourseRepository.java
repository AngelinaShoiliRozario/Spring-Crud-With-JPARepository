package com.springcrud.springcrud.repository;

import com.springcrud.springcrud.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "topics")
public interface CourseRepository extends JpaRepository<Course, Long> {
}
