package com.gelinski.engsoftwaregame.service;

import com.gelinski.engsoftwaregame.model.Student;
import com.gelinski.engsoftwaregame.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
