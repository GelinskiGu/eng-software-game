package com.gelinski.engsoftwaregame.controller;

import com.gelinski.engsoftwaregame.dto.AnsweredQuestionDTO;
import com.gelinski.engsoftwaregame.service.PhaseOneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phase-one")
@RequiredArgsConstructor
public class PhaseOneController {
    private final PhaseOneService service;

    @PostMapping("/answer/{studentId}")
    public ResponseEntity<Boolean> saveStudentQuestion(@RequestBody AnsweredQuestionDTO answer, @PathVariable Long studentId) {
        Boolean result;
        try {
            result = service.savePhaseOneAnswer(answer, studentId);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
