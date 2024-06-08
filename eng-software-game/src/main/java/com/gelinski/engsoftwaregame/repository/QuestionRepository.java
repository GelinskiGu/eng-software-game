package com.gelinski.engsoftwaregame.repository;

import com.gelinski.engsoftwaregame.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}