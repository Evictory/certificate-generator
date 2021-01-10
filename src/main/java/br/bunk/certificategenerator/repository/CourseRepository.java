package br.bunk.certificategenerator.repository;

import br.bunk.certificategenerator.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
