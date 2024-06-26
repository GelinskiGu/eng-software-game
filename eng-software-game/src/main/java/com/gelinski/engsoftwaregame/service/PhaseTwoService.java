package com.gelinski.engsoftwaregame.service;

import com.gelinski.engsoftwaregame.dto.AnsweredQuestionDTO;
import com.gelinski.engsoftwaregame.model.Question;
import com.gelinski.engsoftwaregame.model.Student;
import com.gelinski.engsoftwaregame.model.StudentQuestion;
import com.gelinski.engsoftwaregame.repository.QuestionRepository;
import com.gelinski.engsoftwaregame.repository.StudentQuestionRepository;
import com.gelinski.engsoftwaregame.repository.StudentRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class PhaseTwoService {
    private final QuestionRepository questionRepository;
    private final StudentQuestionRepository studentQuestionRepository;
    private final StudentRepository studentRepository;
    private final Gson gson = new Gson();

    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    public Boolean saveStudentQuestion(AnsweredQuestionDTO answeredQuestionDTO, Long studentId, Long questionId) {
        log.info("AnsweredQuestionDTO: {}, studentId {}, questionId {}", gson.toJson(answeredQuestionDTO), studentId, questionId);
        try {
            Question question = questionRepository.findById(questionId).orElseThrow();
            Student student = studentRepository.findById(studentId).orElseThrow();
            StudentQuestion studentQuestion = new StudentQuestion();

            studentQuestion.setCorrect(Objects.equals(answeredQuestionDTO.getAnswer(), question.getAnswer()));
            studentQuestion.setAnswer(answeredQuestionDTO.getAnswer());
            studentQuestion.setCorrectAnswer(question.getAnswer());
            studentQuestion.setSeconds(answeredQuestionDTO.getSeconds());
            studentQuestion.setStudent(student);
            studentQuestion.setQuestion(question);
            studentQuestionRepository.save(studentQuestion);
            return studentQuestion.isCorrect();
        } catch (Exception e) {
            log.error("Error saving student question: {}", e.getMessage());
            throw new RuntimeException("Error saving student question");
        }
    }
}
