package com.gelinski.engsoftwaregame.controller;

import com.gelinski.engsoftwaregame.dto.AnsweredQuestionDTO;
import com.gelinski.engsoftwaregame.model.Question;
import com.gelinski.engsoftwaregame.service.PhaseTwoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phase-two")
@RequiredArgsConstructor
public class PhaseTwoController {
    private final PhaseTwoService service;

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> findAllQuestions() {
        return ResponseEntity.ok(service.findAllQuestions());
    }

    @PostMapping("/answer/{studentId}/{questionId}")
    public ResponseEntity<Boolean> saveStudentQuestion(@RequestBody AnsweredQuestionDTO answer, @PathVariable Long studentId, @PathVariable Long questionId) {
        Boolean result;
        try {
            result = service.saveStudentQuestion(answer, studentId, questionId);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
