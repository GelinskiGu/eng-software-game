package com.gelinski.engsoftwaregame.repository;

import com.gelinski.engsoftwaregame.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}