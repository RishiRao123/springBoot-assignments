package org.raoamigos.coursemanagementsystem.repository;

import org.raoamigos.coursemanagementsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
